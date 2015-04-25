package controllers;

import models.Game;
import models.Developer;
import play.*;
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

import views.html.*;
import views.*;


public class APITest2 extends Controller {
    
  public static Promise<Result> testGet() {
      String title = Form.form().bindFromRequest().get("title");
      title = title.replaceAll("[\\W]", "+");
      WSRequestHolder holder = WS.url("https://videogamesrating.p.mashape.com/get.php?count=5&game="+title);
      WSRequestHolder complexHolder = holder.setHeader("X-Mashape-Key", "8SOqKF0W6fmshCxJFRKMZikYElTfp1MxFUKjsnKXmJtGjoz2Fp").setHeader("Accept", "application/json");
    return complexHolder.get().map(response ->
        //ok("IGN Score: " + response.asJson().findPath("score").asText())
        ok(IGNAPIresult.render("IGN Score: " + response.asJson().findPath("score").asText()))
    );
}

}
