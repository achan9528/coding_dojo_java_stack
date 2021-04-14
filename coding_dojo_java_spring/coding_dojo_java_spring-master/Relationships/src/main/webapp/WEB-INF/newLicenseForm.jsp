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
		<form:form action="/licenses/new" method="post" modelAttribute="newLicense">
			<div class="form-group">
				<form:label path="person">Person</form:label>
				<form:errors path="person"/>
				<form:select path="person" items="${persons}"></form:select>
			</div>
			<div class="form-group">
				<form:label path="state">State:</form:label>
				<form:errors path="state"/>
				<form:input path="state"/>
			</div>
			<div class="form-group">
				<form:label path="expirationDate">Expiration Date:</form:label>
				<form:errors path="expirationDate"/>
				<form:input path="expirationDate" type="date"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>