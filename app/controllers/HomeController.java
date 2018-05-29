package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class HomeController extends Controller
{
    public Result index ()
    {
        return ok("This is the main page for Space whales project");
    }
}
