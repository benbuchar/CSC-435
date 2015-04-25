package controllers;

import models.Game;
import models.Developer;
import play.*;
import play.mvc.*;
import play.data.Form;
import play.db.ebean.*;
import com.avaje.ebean.Query;
import play.db.ebean.Model;


import com.fasterxml.jackson.databind.JsonNode;


import static play.libs.Json.*;
import views.html.*;
import java.util.List;

import play.mvc.*;
import play.libs.ws.*;
import play.libs.F.Function;
import play.libs.F.Promise;

public class AddGamesControl1 extends Controller {
    
    public static Result addGame(){
        Game game = Form.form(Game.class).bindFromRequest().get();
        game.save();
        return redirect(routes.Application.index());
        
        
        
    }
    
}