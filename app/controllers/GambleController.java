package controllers;

import views.html.*;
import play.*;
import play.data.*;
import play.mvc.*;
import java.util.*;
import java.io.*;

public class GambleController extends Controller
{
    public Result chest() {
        return ok(chest.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    public Result roulette() {
        return ok(roulette.render(Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
}