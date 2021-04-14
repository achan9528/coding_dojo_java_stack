<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <title>Book Store</title>
</head>
<body>
	<div class="container">
		<h1>All Books</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Title</th>
		            <th>Description</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${books}" var="book">
		        <tr>
		            <td><c:out value="${book.title}"/></td>
		            <td><c:out value="${book.description}"/></td>
		            <td><c:out value="${book.language}"/></td>
		            <td><c:out value="${book.numberOfPages}"/></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/books/new">New Book</a>
		<%-- <form method="POST" action="/submit">
			<h2> <c:out value="${error}"/> </h2>
			<div class="form-group">
				<label for="name">Your Name:</label>
				<input type="text" class="form-control" name="name">
			</div>
			<button class="btn btn-primary">Submit</button>
		</form> --%>
	</div>
</body>
</html>