<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Form</title>
	</head>
	<body>
	<p><b>Check Database:</b></p>
	</br>
        <g:form controller="search" action="search">
            <label>Title: </label>
			<g:textField name="title"/><br/></br>
            <g:actionSubmit value="Search"/>
        </g:form>
		</br></br></br>
		<%= link(action:'index', controller:'hello') { 'Back To Add' } %>
	</body>
</html>