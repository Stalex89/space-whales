package controllers;

import models.Place;
import views.html.*;
import play.*;
import play.data.*;
import play.mvc.*;
import static play.mvc.Http.MultipartFormData;

import java.util.*;
import java.io.*;
import com.google.common.io.Files;
import views.formdata.LoginFormData;
import controllers.routes;
import models.UserInfo;
import models.UserInfoDB;
import javax.inject.Inject;

public class PlaceController extends Controller 
{
    @Inject
    FormFactory formFactory;

    public Result index() 
    {
        return redirect(routes.PlaceController.places());
    }

    public Result places() 
    {
        List<Place> allPlaces = Place.findAll();
        return ok(places.render(allPlaces, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result addPlace() 
    {
        return ok(add_edit_place.render(formFactory.form(Place.class).bindFromRequest(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result editPlace(Place place) 
    {
        Form<Place> filledForm = formFactory.form(Place.class).fill(place);
        return ok(add_edit_place.render(filledForm, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result details(Place place) 
    {
        return ok(details.render(place));
    }

    public Result about() 
    {
        return ok(about.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result save() 
    {
        Form<Place> placeForm = formFactory.form(Place.class).bindFromRequest();
        if (placeForm.hasErrors()) 
        {
            flash("error", "Please correct the form below");
            return badRequest(add_edit_place.render(placeForm, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
        }

        Place place = placeForm.get();

        MultipartFormData body = request().body().asMultipartFormData();
        MultipartFormData.FilePart part = body.getFile("picture");

        if (part != null) 
        {
            File picture = (File) part.getFile();
            try 
            {
                place.picture = Files.toByteArray(picture);
            } catch (IOException e) 
            {
                return internalServerError("Error reading file upload");
            }
        }

        if (place.id == null) 
        {
            place.save();
        } else 
        {
            place.update();
        }

        flash("success", String.format("Successfully added a place: %s", place.name));
        return redirect(routes.PlaceController.places());
    }

    public Result incrRating(Place place) 
    {
        place.rating += 1;
        place.update();
        return ok(place.rating + "");
    }

    public Result decrRating(Place place) 
    {
        place.rating -= 1;
        place.update();
        return ok(place.rating + "");//redirect(routes.PlaceController.places());
    }

    public Result delete(Long id) 
    {

        final Place place = Place.findById(id);
        if (place == null) 
        {
            return badRequest(String.format("Place with %d does not exist.", id));
        }
        place.delete();
        return ok(routes.PlaceController.places().toString());
    }

    public Result picture(Place place) 
    {
        return ok(place.picture);
    }

    /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
    public Result login() 
    {
        if(!UserInfoDB.isUser("admin@example.com")) {
            UserInfoDB.addUserInfo("admin", "admin@example.com", "password");
        }
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class);
        return ok(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
    public Result postLogin() 
    {

    // Get the submitted form data from the request object, and run validation.
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class).bindFromRequest();

        if (formData.hasErrors()) 
        {
        flash("error", "Login credentials not valid.");
        return badRequest(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
        }
        else 
        {
            // email/password OK, so now we set the session variable and only go to authenticated pages.
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.PlaceController.profile());
        }
    }
  
    /**
    * Logs out (only for authenticated users) and returns them to the Index page. 
    * @return A redirect to the Index page. 
    */
    @Security.Authenticated(Secured.class)
    public Result logout() 
    {
        session().clear();
        return redirect(routes.PlaceController.index());
    }

    /**
    * Provides the Profile page (only to authenticated users).
    * @return The Profile page. 
    */
    @Security.Authenticated(Secured.class)
    public Result profile() 
    {
        return ok(profile.render("profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
}