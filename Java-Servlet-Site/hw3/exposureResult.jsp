<%@ page import="gamedb.Game" %>

<html>
<head><title>Exposure</title></head>
<p>
<body>
			<%= request.getAttribute("jsonArray").toString().replaceAll(",null", "") %>
			
		
		<br>
		<br>
		<a href="/hw3/gameAdd.jsp">Back to Add</a>
</body>
</html>