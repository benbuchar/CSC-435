<html>
	<head><title>Game Addition</title></head>
	<h1>Game Addition</h1>
	<br>
	<body>
		<form method ="get" action = "http://localhost:2630/hw3/add">
			<p>JSP test! The time is now <%= new java.util.Date() %> </p>
			<b>Insert The Information You Wish to Add:</b><br>
			Title: <input type = "text" name = "title"><br>
			Developer: <input type = "text" name = "developer"><br>
			Year: <input type = "text" name = "year"></br>
			<input type = "submit">
		</form>
		<br>
		<a href="/hw3/devSearch.jsp">Search For Games</a>
		<br>
		<br>
		<form method="get" action = "http://localhost:2630/hw3/expose">
		<input type = "submit" value="Expose Database">
		
	</body>
</html>