<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Form</title>
	</head>
	<body>
	<p><b>@[result]</b></p>
	</br>
        <g:form controller="hello" action="save">
            <label>Title: </label>
            <g:textField name="title"/><br/>
            <label>Developer: </label>
            <g:textField name="developer"/><br/>
            <label>Year: </label>
            <g:textField name="year"/><br/></br>
            <g:actionSubmit value="Save"/>
        </g:form>
		</br></br></br>
		<%= link(action:'index', controller:'search') { 'Search For Games' } %>
		</br>
		<a href="/games">Expose Database</a>
	</body>
</html>
