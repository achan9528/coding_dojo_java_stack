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
		<div class="row">
			<a href="/songs/new">Add New Song</a>
			<a href="/top">Top Songs</a>
			<form action="/search" method="post">
				<input name="searchValue">
				<button class="btn btn-primary">Search</button>
			</form>
		</div>
		<div class="row">
			<table class="table">
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Rating</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${songs}" var="songs">
			        <tr>
			            <td><a href="/songs/${songs.id}"><c:out value="${songs.name}"/></a></td>
			            <td><c:out value="${songs.rating}"/></td>
			            <td><a href="/songs/${songs.id}/delete">Delete</a></td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>