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

public class HomeController extends Controller 
{
    public Result index() 
    {
        return ok(places.render(allPlaces, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

}