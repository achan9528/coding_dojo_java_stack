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
    
    <title>Events</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1><c:out value="${event.name}"></c:out></h1>
		</div>
		<div class="row">
			<form:form modelAttribute="event" method="post" action="/events/${event.id}/edit">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:errors path="name"/>
					<form:input path="name"/>
				</div>
				<div class="form-group">
					<form:label path="eventDate">Date:</form:label>
					<form:errors path="eventDate"/>
					<form:input type="date" path="eventDate" placeholder="${event.eventDate}"/>
				</div>
				<div class="form-group">
					<form:label path="city">Location:</form:label>
					<form:errors path="city"/>
					<form:input path="city" placeholder="${event.city}"/>
					
					<form:errors path="state"/>
					<form:select path="state" placeholder="${event.state}">
						<form:option value="CA">CA</form:option>
						<form:option value="AZ">AZ</form:option>
					</form:select>
				</div>
				<button class="btn btn-primary">Create</button>
			</form:form>
		</div>
	</div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>