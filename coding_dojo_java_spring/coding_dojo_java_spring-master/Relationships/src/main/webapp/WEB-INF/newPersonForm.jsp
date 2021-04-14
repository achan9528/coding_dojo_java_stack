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
    
    <title>Relationships</title>
</head>
<body>
	<div class="container">
		<h1>New Person</h1>
		<form:form action="/persons/new" method="post" modelAttribute="newPerson">
			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Artist:</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>