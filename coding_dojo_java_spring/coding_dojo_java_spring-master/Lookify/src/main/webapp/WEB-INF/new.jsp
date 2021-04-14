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
    
    <title>Lookify</title>
</head>
<body>
	<div class="container">
		<form:form action="/songs/new" method="post" modelAttribute="song">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div class="form-group">
				<form:label path="artist">Artist:</form:label>
				<form:errors path="artist"/>
				<form:input path="artist"/>
			</div>
			<div class="form-group">
				<form:label path="rating">Rating:</form:label>
				<form:errors path="rating"/>
				<form:input path="rating"/>
			</div>
			<button class="btn btn-primary">Add Song</button>
		</form:form>
	</div>
</body>
</html>