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
		<form>
			<div class="form-group">
				<label for="name">Your Name:</label>
				<input type="text" readonly class="form-control-plaintext" name="name" value=<c:out value="${name}"/> >
			</div>
			<div class="form-group">
				<label for="dojoLocation">Dojo Location:</label>
				<input type="text" readonly class="form-control-plaintext" name="dojoLocation" <c:out value="value=${dojo}"/> >
			</div>
			<div class="form-group">
				<label for="favoriteLanguage">Favorite Language:</label>
				<input type="text" readonly class="form-control-plaintext" name="favoriteLanguage" <c:out value="value=${fav}"/> >
			</div>
			<div class="form-group">
				<label for="comments">Comments:</label>
				<textarea readonly class="form-control-plaintext" name="comments"><c:out value="${comments}"/></textarea>
			</div>
		</form>
	</div>
</body>
</html>