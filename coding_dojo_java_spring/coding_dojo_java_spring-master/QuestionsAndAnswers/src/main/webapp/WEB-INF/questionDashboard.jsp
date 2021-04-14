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
    
    <title>Questions and Answers</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Question Dashboard</h1>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Question</th>
						<th>Tag</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${questions}" var="q">
						<tr>
							<td><c:out value="${q.question}"></c:out></td>
							<td>
								<c:forEach items="${q.tags}" var="t">
									<c:out value="${t.subject},"></c:out>
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row">
				<a href="/questions/new">New Question</a>
			</div>
		</div>
	</div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>