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
		<div class="row">
			<h1><c:out value="${dojo.name} Location Ninjas"/></h1>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dojo.ninjas}" var="ninja">
						<tr>
							<td><c:out value="${ninja.firstName}"/></td>
							<td><c:out value="${ninja.lastName}"/></td>
							<td><c:out value="${ninja.age}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>
		
	</div>
</body>
</html>