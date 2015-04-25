package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Title extends Model{
    
    @Id
    public String id;
    public String title;
    
    public String getTitle(){
        return title;
    }
}