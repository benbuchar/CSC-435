package gamedb;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Random;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class AddGameControl extends HttpServlet {
	
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			Connection conn = null;
			Statement stmt = null;
				
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8888/gameDB",
			"myuser", "Pal06018");
			
			stmt = conn.createStatement();
			
			String titleWithPluses = request.getParameter("title").replaceAll("[\\W]", "+");
			URL url = new URL("https://videogamesrating.p.mashape.com/get.php?count=5&game=" + titleWithPluses);
			URLConnection con = url.openConnection();
			con.setRequestProperty("X-Mashape-Key", "8SOqKF0W6fmshCxJFRKMZikYElTfp1MxFUKjsnKXmJtGjoz2Fp");
			InputStream is = con.getInputStream();
			Scanner sc = new Scanner(new InputStreamReader(is));
			String line = sc.nextLine();
			Scanner lineSc = new Scanner(line);
			lineSc.useDelimiter("\"");
			String IGNRating = "";
			while(lineSc.hasNext()){
				if(lineSc.next().equals("score")){
					lineSc.next();
					IGNRating += lineSc.next();
					break;
				}	
			}
			
			int id = getPreviousIdPlusOne();
			Game game = new Game(request.getParameter("title"), request.getParameter("developer"), request.getParameter("year"));
			game.setIGNRating(IGNRating);
			
			String sqlStr = "INSERT INTO games (id, title, developer, year, PlayersOnline, ignrating)" 
			+ "VALUES ('" + id + "', '" + request.getParameter("title") + "', '" 
			+ request.getParameter("developer") + "', '" + request.getParameter("year") + "', '"
			+ getPlayersOnline() + "', '" + IGNRating + "');";
			
			stmt.executeUpdate(sqlStr);
			
			request.setAttribute("game", game);
			
			try{
				request.getRequestDispatcher("/gameAddResult.jsp").forward(request, response);
			} catch (ServletException e){
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}
			
		}catch (SQLException ex){
			ex.printStackTrace();
		} finally {
			out.close();
		}
		try {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch(SQLException ex){
			ex.printStackTrace();
		}		
	}
	
	
	public int getPreviousIdPlusOne(){
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	public int getPlayersOnline(){
		Random r = new Random();
		return r.nextInt(500000);
	}


}