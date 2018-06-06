package controllers;

import views.html.*;
import models.Chest;
import models.TShirt;
import models.UserInfo;
import play.*;
import play.libs.Json;
import play.data.*;
import play.mvc.*;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GambleController extends Controller
{

    public Result chest(Chest ch) {
        return ok(chest.render(ch, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    @Security.Authenticated(Secured.class)
    public Result openChest(Chest ch) {
        return ok(roulette.render(ch, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    private List<TShirt> getRandomPoolFromChest(Chest ch) {
        List<TShirt> tshirts = new ArrayList<TShirt>();
        float sumRarity = 0;
        for (TShirt tshirt : ch.tShirts) {
            sumRarity += tshirt.rarity.rarityCoeff();
        }
        for (int i = 0; i < 100; i++) {
            tshirts.add(selectRandomWithDistribution(ch.tShirts, sumRarity));
        }
        return tshirts;
    }

    private TShirt selectRandomWithDistribution(List<TShirt> tshirts, float sumRarity) {
        Random rand = new Random();
        float randFloat = rand.nextFloat()*sumRarity;
        TShirt selected = null;
        for (TShirt tshirt : tshirts) {
            randFloat -= tshirt.rarity.rarityCoeff();
            selected = tshirt;
            if (randFloat <= 0) {
                break;
            }
        }

        return selected;
    }

    @Security.Authenticated(Secured.class)
    public Result roulette(Chest ch) {
        List<TShirt> tshirts = getRandomPoolFromChest(ch);
        Random rand = new Random();
        int  n = rand.nextInt(50) + 50;
        ObjectNode response = Json.newObject();
        response.put("selected", n);
        response.set("tshirts", Json.toJson(tshirts));
        UserInfo ui = Secured.getUserInfo(ctx());
        if (ui == null) {
            System.out.println("user is null");
        } else {
            ui.addWonTShirt(tshirts.get(n));
        }
        return ok(response);
    }

}