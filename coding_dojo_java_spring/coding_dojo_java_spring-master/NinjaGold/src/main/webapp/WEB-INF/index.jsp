<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    
    <title>Ninja Gold</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-3">
				<h2 class="col">Your Gold:</h2>
				<h2 class="col"><c:out value="${gold}"/></h2>
			</div>
		</div>
		<div class="row">
			<form method="POST" action="/submit" class="col">
				<div class="form-group">
					<label for="name">Farm (earns 10-20 gold)</label>
					<input type="hidden" name="submitValue" value="1">
				</div>
				<button class="btn btn-primary">Find Gold</button>
			</form>
			<form method="POST" action="/submit" class="col">
				<div class="form-group">
					<label for="name">Cave (earns 5-10 gold)</label>
					<input type="hidden" name="submitValue" value="2">
					
				</div>
				<button class="btn btn-primary">Find Gold</button>
			</form>
			<form method="POST" action="/submit" class="col">
				<div class="form-group">
					<label for="name">House (earns 2-5 gold)</label>
					<input type="hidden" name="submitValue" value="3">
				</div>
				<button class="btn btn-primary">Find Gold</button>
			</form>
			<form method="POST" action="/submit" class="col">
				<div class="form-group">
					<label for="name">Casino! (earns/takes 0 - 50 gold)</label>
					<input type="hidden" name="submitValue" value="4">
				</div>
				<button class="btn btn-primary">Find Gold</button>
			</form>
		</div>
		<div class="row">
			<h2>Activities:</h2>
			<textarea><c:out value="${activities}"/></textarea>
		</div>
	</div>
</body>
</html>