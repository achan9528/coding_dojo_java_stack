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
    
    <title>Languages</title>
</head>
<body>
	<div class="container">
		<h1>All Books</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Current Version</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${langs}" var="langs">
		        <tr>
		            <td><c:out value="${langs.name}"/></td>
		            <td><c:out value="${langs.creator}"/></td>
		            <td><c:out value="${langs.currentVersion}"/></td>
		            <td>
		            	<a href="/languages/<c:out value="${langs.id}"/>/edit" class="col">Edit</a>
		            	<form action="/languages/<c:out value="${langs.id}"/>" class="col">
		            		<button class="btn btn-primary">Delete</button>
		            	</form>
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<form:form action="/languages" method="post" modelAttribute="lang">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</div>
			<div class="form-group">
				<form:label path="creator">Creator:</form:label>
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</div>
			<div class="form-group">
				<form:label path="currentVersion">Current Version:</form:label>
				<form:errors path="currentVersion"/>
				<form:input path="currentVersion"/>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>