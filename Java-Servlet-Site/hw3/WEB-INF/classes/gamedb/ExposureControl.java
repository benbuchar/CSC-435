package gamedb;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONException;

public class ExposureControl extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		response.setContentType("text/html");
		
		Game[] games = new Game[500];
		
		Connection conn = null;
		Statement stmt = null;
		try{
		conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:8888/gameDB", "myuser", "Pal06018");
			
			stmt = conn.createStatement();
			
			String sqlStr = "select * from games;";
			
		    ResultSet rset = stmt.executeQuery(sqlStr);
			
			int count = 0;
			while(rset.next()){
			Game game = new Game(rset.getString("title"), rset.getString("developer"), 
			rset.getString("year"));
			game.setIGNRating(rset.getString("ignrating"));
			games[count]=game;
			request.setAttribute("game"+count, game);
			count++;
			//or put into an array and put the array into the request
			}
			try{
				
			JSONArray json = new JSONArray(games);
			request.setAttribute("numberOfGames", count);
			request.setAttribute("jsonArray", json);
			} catch (JSONException e){
				e.printStackTrace();
			}
			
			try{
				request.getRequestDispatcher("/exposureResult.jsp").forward(request,response);
			} catch (ServletException e){
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}
		} catch (SQLException ex){
			ex.printStackTrace();
		} 
			
			try {
			if(stmt != null) stmt.close();
			if(conn!= null) conn.close();
			} catch (SQLException ex) {
			ex.printStackTrace();
			}
		
		}
	}