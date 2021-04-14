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
		<h1><c:out value="${person.firstName} ${person.lastName}"/> </h1>
		<ul>
			<li>License Number: <c:out value="${person.license.number}"/> </li>
			<li>State: <c:out value="${person.license.state}"/> </li>  
			<li>Expiration Date: <c:out value="${person.license.expirationDate}"/> </li>			
		</ul>
	</div>
</body>
</html>