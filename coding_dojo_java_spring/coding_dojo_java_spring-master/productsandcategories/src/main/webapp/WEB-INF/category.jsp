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
		<div class="row">
			<h1><c:out value="${category.name}"></c:out></h1>
		</div>
		<div class="row">
			<div class="col">
				<h2>Products</h2>
				<ul>
					<c:forEach items="${category.products}" var="p">
					<li><c:out value="${p.name}"/><li>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form:form action="/categories/${category.id}" method="post" modelAttribute="product">
					<div class="form-group">
						<form:select path="name" items="${additionalProducts}"></form:select>
					</div>
					<button class="btn btn-primary">Create</button>
				</form:form>
			</div>
		</div>
		
	</div>
</body>
</html>