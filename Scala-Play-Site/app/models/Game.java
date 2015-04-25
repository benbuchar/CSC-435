package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;

@Entity
public class Game extends Model{
    
    @Id
    public String id;
    public String title;
    public String developer;
    public int year;
    public JsonNode ignscore;
    public String newsupdate;
    
    public void setNewsUpdate(String news){
        newsupdate = news;
    }
    
    public void setIGNScore(JsonNode score) {
        ignscore = score;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getTitleForIGN(){
        title = title.replaceAll("[\\W]", "+");
        return title;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getDeveloper(){
        return developer;
    }
}