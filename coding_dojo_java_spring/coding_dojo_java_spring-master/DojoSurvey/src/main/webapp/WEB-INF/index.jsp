<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <title>Dojo Survey</title>
</head>
<body>
	<div class="container">
		<form method="POST" action="/submit">
			<h2> <c:out value="${error}"/> </h2>
			<div class="form-group">
				<label for="name">Your Name:</label>
				<input type="text" class="form-control" name="name">
			</div>
			<div class="form-group">
				<label for="dojoLocation">Dojo Location:</label>
				<select class="form-select" name="dojoLocation">
					<option selected>Pick a Dojo Location</option>
					<option value="1">San Jose</option>
					<option value="2">Seattle</option>
					<option value="3">Orange County</option>
				</select>
			</div>
			<div class="form-group">
				<label for="favoriteLanguage">Favorite Language:</label>
				<select class="form-select" name="favoriteLanguage">
					<option selected>Pick your favorite language</option>
					<option value="1">Python</option>
					<option value="2">Java</option>
					<option value="3">Javascript</option>
				</select>
			</div>
			<div class="form-group">
				<label for="comments">Comments:</label>
				<textarea class="form-control" name="comments"></textarea>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>