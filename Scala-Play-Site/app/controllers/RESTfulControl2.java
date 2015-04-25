package controllers;

import models.Game;
import models.Developer;
import play.*;
import play.mvc.*;
import play.data.Form;
import play.db.ebean.*;
import com.avaje.ebean.Query;
import play.db.ebean.Model;

import static play.libs.Json.*;
import views.html.*;
import java.util.List;

public class RESTfulControl2 extends Controller {

public static Result getGames(){
        String title = Form.form().bindFromRequest().get("title");
        Query<Game> query = new Model.Finder(String.class, Game.class);
        List<Game> games = query.findList();
        return ok(toJson(games));
    }
}