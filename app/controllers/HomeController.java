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

public class HomeController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index() {
        return ok(index.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result contact() {
        return ok(contact.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result register() {
        return ok(register.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result showcase() {
        return ok(showcase.render());
    }




    /**
     * Provides the Login page (only to unauthenticated users).
     * 
     * @return The Login page.
     */
    public Result login() {
        if (!UserInfoDB.isUser("admin@example.com")) {
            UserInfoDB.addUserInfo("admin", "admin@example.com", "password");
        }
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class);
        return ok(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
    }

    /**
     * Processes a login form submission from an unauthenticated user. First we bind
     * the HTTP POST data to an instance of LoginFormData. The binding process will
     * invoke the LoginFormData.validate() method. If errors are found, re-render
     * the page, displaying the error data. If errors not found, render the page
     * with the good data.
     * 
     * @return The index page with the results of validation.
     */
    public Result postLogin() {

        // Get the submitted form data from the request object, and run validation.
        Form<LoginFormData> formData = formFactory.form(LoginFormData.class).bindFromRequest();

        if (formData.hasErrors()) {
            flash("error", "Login credentials not valid.");
            return badRequest(login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
        } else {
            // email/password OK, so now we set the session variable and only go to
            // authenticated pages.
            session().clear();
            session("email", formData.get().email);
            return redirect(routes.HomeController.profile());
        }
    }

    /**
     * Logs out (only for authenticated users) and returns them to the Index page.
     * 
     * @return A redirect to the Index page.
     */
    @Security.Authenticated(Secured.class)
    public Result logout() {
        session().clear();
        return redirect(routes.HomeController.index());
    }

    /**
     * Provides the Profile page (only to authenticated users).
     * 
     * @return The Profile page.
     */
    @Security.Authenticated(Secured.class)
    public Result profile() {
        return ok(profile.render("profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

}
