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
			<h1>What is your question?</h1>
		</div>
		<div class="row">
			<form:form method="post" action="/questions/new" modelAttribute="q">
				<div class="form-group">
					<form:label path="question">Question:</form:label>
					<form:errors path="question"/>
					<form:textarea path="question"/>
				</div>
				<div class="form-group">
					<form:label path="tagString">Tags:</form:label>
					<form:errors path="tagString"/>
					<form:input path="tagString"/>
				</div>
				<button class="btn btn-primary">Post Question</button>
			</form:form>
		</div>
	</div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>