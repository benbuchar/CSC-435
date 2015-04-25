package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Developer extends Model{
    
    @Id
    public String id;
    public String developer;
    
    public String getName(){
        return developer;
    }
}