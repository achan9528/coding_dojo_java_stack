<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <title>Books API</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="/api/books/{id}" method="POST">
				<div class="form-group">
					<label for="title">Book Title:</label>
					<input type="text" name="title" class="form-control">
				</div>
				<div class="form-group">
					<label for="language">Language:</label>
					<input type="text" name="language" class="form-control">
				</div>
				<div class="form-group">
					<label for="numOfPages">Number of Pages:</label>
					<input type="text" name="numOfPages" class="form-control">
				</div>
				<div class="form-group">
					<label for="description">Description:</label>
					<input type="text" name="description" class="form-control">
				</div>
				<button type="submit">Submit</button>
			</form>
		</div>
		<div class="row">
	</div>
</body>
</html>