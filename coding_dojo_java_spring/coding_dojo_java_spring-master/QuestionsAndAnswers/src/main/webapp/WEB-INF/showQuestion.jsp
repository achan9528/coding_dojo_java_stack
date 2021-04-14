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
			<h1><c:out value="${question.question}"></c:out></h1>
			<h2>Tags: 
				<c:forEach items="${question.tags}" var="t">
					<c:out value="${t.subject}"></c:out>
				</c:forEach>
			</h2>
		</div>
		<div class="row">
			<table class="table" class="col">
				<thead>
					<tr>
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${question.answers}" var="an">
						<tr>
							<td><c:out value="${an.answer}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form:form method="post" action="/questions/${question.id}" modelAttribute="a" class="col">
				<h3>Add Your Answer:</h3>
				<div class="form-group">
					<form:errors path="answer"></form:errors>
					<form:label path="answer">Answer:</form:label>
					<form:textarea path="answer"/>
				</div>
  				<div class="form-group">
					<form:hidden path="question" value="${question.id}"/>
				</div>
				<button class="btn btn-primary">Answer It!</button>
			</form:form>
		</div>
	</div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>