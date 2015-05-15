<%@ page import="gamedb.Game" %>

<html>
<head><title>Game Developer Search</title></head>
<h1>Game Developer Search</h1>
<p>
<body>
			<% for(int i = 0; i< (int)request.getAttribute("numberOfGames");i++) { 
			  Game g = ((Game)request.getAttribute("game" + i));
			%>
				<p><%= g.getTitle() %>, <%= g.getDeveloper() %>, <%= g.getYear() %>, IGN Rating: <%= g.getIGNRating() %></p> 
			<% } %>
		<a href="/hw3/gameAdd.jsp">Add Games</a>
		<br>
		<a href="/hw3/devSearch.jsp">Back to Search</a>
</body>
</html>