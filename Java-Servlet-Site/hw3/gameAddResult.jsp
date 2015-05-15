<%@ page import="gamedb.Game" %>

<html>
	<head><title>Game Add Success!</title></head>
	<h1>Game Add Success!</h1>
	<br>
	<body>
		<% Game g = ((Game)request.getAttribute("game"));%>
		<p><%=g.getTitle() %>, <%= g.getDeveloper() %>, <%= g.getYear() %> -- IGN Rating: <%= g.getIGNRating() %> </p>
		<a href="/hw3/devSearch.jsp">Search For Games</a>
		<br>
		<a href="/hw3/gameAdd.jsp"> Back to Add</a>
	</body>
</html>