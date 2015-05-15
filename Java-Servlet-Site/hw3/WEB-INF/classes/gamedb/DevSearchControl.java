package gamedb;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DevSearchControl extends HttpServlet {


public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		
		
		Connection conn = null;
		Statement stmt = null;
		try{
		conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:8888/gameDB", "myuser", "Pal06018");
			
			stmt = conn.createStatement();
			
			String sqlStr = "select * from games where developer = " + "'" + 
			request.getParameter("developer") +"'";
			
		    ResultSet rset = stmt.executeQuery(sqlStr);
			
			int count = 0;
			while(rset.next()){
			Game game = new Game(rset.getString("title"), rset.getString("developer"), 
			rset.getString("year"));
			game.setIGNRating(rset.getString("ignrating"));
			request.setAttribute("game"+count, game);
			count++;
			//or put into an array and put the array into the request
			}
			request.setAttribute("numberOfGames", count);
			
			
			try{
				request.getRequestDispatcher("/devSearchResult.jsp").forward(request,response);
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