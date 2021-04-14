<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
			<h1><c:out value="${book.title}"/></h1>
			<p>Description: <c:out value="${book.description}"/></p>
			<p>Language: <c:out value="${book.language}"/></p>
			<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
			<a href="/books/${book.id}/edit">Edit Book</a>
			<form action="/books/${book.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
		</div>
	</body>   
</html>
