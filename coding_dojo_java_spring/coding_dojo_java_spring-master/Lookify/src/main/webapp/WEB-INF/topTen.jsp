<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<h2>Top Ten</h2>
			<a href="/dasbhoard">Dashboard</a>
		</div>
		<div class="row">
			<ul>
				<c:forEach items="${songs}" var="songs">
					<li>
						<c:out value="${songs.rating}"/> - <a href="/songs/${songs.id}"><c:out value="${songs.name}"/></a> - <c:out value="${songs.artist}"/>	
					</li>
		        </c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>