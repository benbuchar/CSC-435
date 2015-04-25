package controllers;

import models.Game;
import models.Developer;
import play.*;
import play.data.Form;
import play.db.ebean.*;
import com.avaje.ebean.Query;
import play.db.ebean.Model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


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


public class APITest extends Controller {
    
  public static Promise<Result> testGet() throws FileNotFoundException{
    int found = 26;
    File file = new File("gameIDList.txt");
    String title = Form.form().bindFromRequest().get("title").replaceAll("\\+"," ");
    Scanner sc = new Scanner(file);
    do{
        String line = sc.nextLine();
           if(line.contains(title)){
                Scanner lineSc = new Scanner(line);
                int i = lineSc.nextInt();
                found = i;
                break;
        } 
        
    } while(sc.hasNext());
    final int appid = found;
    
    return WS.url("http://api.steampowered.com/ISteamNews/GetNewsForApp/v0002/?appid="+appid+"&count=3&maxlength=1000&format=json").get().map(response ->
        //ok("Latest News (If found. Steam only has records on a few games. Try Team Fortress 2.): "+response.asJson().findPath("contents").asText())
           ok(steamAPIresult.render("Latest News (If found. Steam only has records on a few games. Try Team Fortress 2.): "+response.asJson().findPath("contents").asText()))

    );
}

}

    
   
