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
    
    <title>Dojos and Ninjas</title>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			<div class="form-group">
				<form:select path="dojo" items="${dojos}"></form:select>
			</div>
			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</div>
			<div class="form-group">
				<form:label path="age">Age:</form:label>
				<form:errors path="age"/>
				<form:input path="age"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>