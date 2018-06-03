package controllers;

import views.html.*;
import play.*;
import play.data.*;
import play.mvc.*;
import java.util.*;
import java.io.*;

public class GambleController extends Controller
{
    public Result bundle() {
        return ok(bundle.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result chest() {
        return ok(chest.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
}