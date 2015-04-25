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
import play.libs.ws.*;

public class SearchGamesControl2 extends Controller {

    public static Result getGames(){
        String title = Form.form().bindFromRequest().get("title");
        Query<Game> query = new Model.Finder(String.class, Game.class).where("title = '" + title + "'");
        List<Game> games = query.findList();
        if(games.size()!=0){

        return ok(SearchGamesResult.render(games.get(0)));
    } else {
        return ok(NotFoundResult.render());
    }
}
}
