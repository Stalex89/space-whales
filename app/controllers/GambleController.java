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

    public Result tshirt(TShirt ts) {
        return ok(tshirt.render(ts, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }

    @Security.Authenticated(Secured.class)
    public Result openChest(Chest ch) {
        System.out.println("Opening chest " + ch);
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
        UserInfo ui = Secured.getUserInfo(ctx());
        if (ui == null) {
            System.out.println("roulette: user is null");
            List<TShirt> tshirts = getRandomPoolFromChest(ch);
            Random rand = new Random();
            int  n = rand.nextInt(50) + 50;
            ObjectNode response = Json.newObject();
            response.put("selected", n);
            response.set("tshirts", Json.toJson(tshirts));
            return ok(response);
        } else {
            System.out.println("roulette: user is finishing to play roulette!");
            Chest uiChest = ui.finishPlayingRoulette();
            if (uiChest != null && uiChest.id == ch.id) {
                System.out.println("roulette: yay!");
                List<TShirt> tshirts = getRandomPoolFromChest(ch);
                Random rand = new Random();
                int  n = rand.nextInt(50) + 50;
                ObjectNode response = Json.newObject();
                response.put("selected", n);
                response.set("tshirts", Json.toJson(tshirts));
                ui.addWonTShirt(tshirts.get(n));
                return ok(response);
            } else {
                System.out.println("roulette: chest = " + ch.id + "; uiChest = " + uiChest);
            }
        }
        return badRequest("/chest/" + ch.id);
    }

}