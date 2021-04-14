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
    
    <title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<h1>New Product</h1>
		<form:form action="/products/new" method="post" modelAttribute="product">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:input path="description"/>
			</div>
			<div class="form-group">
				<form:label path="price">Price:</form:label>
				<form:errors path="price"/>
				<form:input path="price"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>