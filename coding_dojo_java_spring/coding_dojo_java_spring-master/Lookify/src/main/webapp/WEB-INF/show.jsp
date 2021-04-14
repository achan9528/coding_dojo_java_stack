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
		<ul>
			<li><h1><c:out value="${song.name}"/></h1></li>
			<li><h2><c:out value="${song.artist}"/></h2></li>
			<li><h2><c:out value="${song.rating}"/></h2></li>
			<li><a href="/songs/${song.id}/delete">Delete</a></li>
		</ul>
	</div>
</body>
</html>