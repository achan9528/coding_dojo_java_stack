<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Code</title>
</head>
<body>
	<form action="/TryCode" method="POST">
		<h2> <c:out value="${error}"/> </h2>
		<h2>What is the code?</h2>
		<label for="userInput">Try Code</label>
		<input type="text" name="userInput">
		<button type="submit"></button>
	</form>
</body>
</html>