<html>
<head><title>Game Developer Search</title></head>
<h1>Game Developer Search</h1>
<p>
<body>
	<form method="get" action="http://localhost:2630/hw3/search">
		<p>The time is now <%= new java.util.Date() %> </p>
		<b>Choose a Developer:</b>
		<input type="radio" name="developer" value="Turtle Rock Studios">Turtle Rock Studios
		<input type="radio" name="developer" value="Kojima Productions">Kojima Productions
		<input type="text" name="developer">
		<input type="submit" value="Search">
	</form>
	<br>
	<a href="gameAdd.jsp">Add Games</a>
</body>
</html>