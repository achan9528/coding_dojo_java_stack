<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <title>Languages</title>
</head>
<body>
	<div class="container">
		<form:form action="/languages/${lang.id}" method="post" modelAttribute="lang">
			<input type="hidden" name="_method" value="delete">
			<button class="btn btn-primary">Delete</button>
		</form:form>
		<a href="/languages">Dashboard</a>
		<form:form action="/languages/${lang.id}/" method="post" modelAttribute="lang">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div class="form-group">
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</div>
			<div class="form-group">
				<form:label path="currentVersion">Current Version:</form:label>
				<form:errors path="currentVersion"/>
				<form:input path="currentVersion"/>
			</div>
			<button class="btn btn-primary">Update</button>
		</form:form>
	</div>
</body>
</html>