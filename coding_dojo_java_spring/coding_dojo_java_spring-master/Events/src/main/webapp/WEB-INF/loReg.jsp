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
    
    <title>Events App</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Welcome to the Events App! Please sign in</h1>
		</div>
		<div class="row">
			<form:form method="post" action="/register" modelAttribute="regUser" class="col">
				<h2>Register</h2>
				<div class="form-group">
					<form:label path="firstName">First Name:</form:label>
					<form:errors path="firstName"/>
					<form:input path="firstName" placeholder="First Name"/>
				</div>
				<div class="form-group">
					<form:label path="lastName">Last Name:</form:label>
					<form:errors path="lastName"/>
					<form:input path="lastName" placeholder="Last Name"/>
				</div>
				<div class="form-group">
					<form:label path="email">Email:</form:label>
					<form:errors path="email"/>
					<form:input path="email" placeholder="johndoe@123mail.com"/>
				</div>
				<div class="form-group">
					<form:label path="city">Location:</form:label>
					<form:errors path="city"/>
					<form:input path="city" placeholder="City"/>
					
					<form:errors path="state"/>
					<form:select path="state" placeholder="0">
						<form:option value="CA">CA</form:option>
						<form:option value="AZ">AZ</form:option>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="password">Password:</form:label>
					<form:errors path="password"/>
					<form:input path="password" placeholder="password"/>
				</div>
				<div class="form-group">
					<form:label path="passwordConfirmation">Password Confirmation:</form:label>
					<form:errors path="passwordConfirmation"/>
					<form:input path="passwordConfirmation" placeholder="password"/>
				</div>
				<button class="btn btn-primary">Register</button>
			</form:form>
			<form method="post" action="/login" class="col">
				<h2>Login</h2>
				<div class="form-group">
					<label for="logEmail">Email:</label>
					<input name="logEmail" type=text>
				</div>
				<div class="form-group">
					<label for="logPassword">Password:</label>
					<form:errors name="logPassword"/>
					<input name="logPassword" type=text>
				</div>
				<button class="btn btn-primary">Log In</button>
			</form>
		</div>
	</div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>