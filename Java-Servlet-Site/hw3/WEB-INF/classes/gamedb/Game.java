package gamedb;
public class Game {


String title;
String developer;
String year;
String ignrating;
String titleForIGN;

public Game(String t, String d, String y){
	title = t;
	developer = d;
	year = y;
}

public String getTitleForIGN(){
	return title.replaceAll("[//W]", "+");
}

public void setIGNRating(String s){
	ignrating = s;
}

public String getTitle(){
	return title;
}

public String getDeveloper(){
	return developer;
}

public String getYear(){
	return year;
}

public String getIGNRating(){
	return ignrating;
}
}//embed into request
//forward to display