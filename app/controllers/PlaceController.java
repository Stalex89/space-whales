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

import controllers.routes;

import javax.inject.Inject;

public class PlaceController extends Controller {
    @Inject
    FormFactory formFactory;

    public Result index() {
        return redirect(routes.PlaceController.places());
    }

    public Result places() {
        List<Place> allPlaces = Place.findAll();
        return ok(places.render(allPlaces));
    }

    public Result addPlace() {
        return ok(add_edit_place.render(formFactory.form(Place.class).bindFromRequest()));
    }

    public Result editPlace(Place place) {
        Form<Place> filledForm = formFactory.form(Place.class).fill(place);
        return ok(add_edit_place.render(filledForm));
    }

    public Result details(Place place) {
        return ok(details.render(place));
    }

    public Result save() {
        Form<Place> placeForm = formFactory.form(Place.class).bindFromRequest();
        if (placeForm.hasErrors()) {
            flash("error", "Please correct the form below");
            return badRequest(add_edit_place.render(placeForm));
        }

        Place place = placeForm.get();

        MultipartFormData body = request().body().asMultipartFormData();
        MultipartFormData.FilePart part = body.getFile("picture");

        if (part != null) {
            File picture = (File) part.getFile();
            try {
                place.picture = Files.toByteArray(picture);
            } catch (IOException e) {
                return internalServerError("Error reading file upload");
            }
        }

        if (place.id == null) {
            place.save();
        } else {
            place.update();
        }

        flash("success", String.format("Successfully added a place: %s", place.name));
        return redirect(routes.PlaceController.places());
    }

    public Result incrRating(Place place) {
        place.rating += 1;
        place.update();
        return ok(place.rating + "");
    }

    public Result decrRating(Place place) {
        place.rating -= 1;
        place.update();
        return ok(place.rating + "");//redirect(routes.PlaceController.places());
    }

    public Result delete(Long id) {

        final Place place = Place.findById(id);
        if (place == null) {
            return badRequest(String.format("Place with %d does not exist.", id));
        }
        place.delete();
        return ok(routes.PlaceController.places().toString());
    }

    public Result picture(Place place) {
        return ok(place.picture);
    }
}