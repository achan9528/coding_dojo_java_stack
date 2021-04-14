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
			<ul class="col">
				<li>Host: <c:out value="${event.host.firstName} ${event.host.lastName}"></c:out></li>
				<li>Date: <c:out value="${event.eventDate}"></c:out></li>
				<li>Location: <c:out value="${event.city}, ${event.state}"></c:out></li>
				<li>Number of Attendees: 
					<c:out value="${event.attendees.size()}"></c:out>
				</li>
			</ul>
			<div class="col">
				<div>
					<h2>Messages</h2>
					<div class="overflow-auto">
						<c:forEach items="${event.messages}" var="msg">
							<p>
								<c:out value="${msg.author.firstName} says ${msg.message}"></c:out>
							</p>
						</c:forEach>
					</div>
				</div>
				<form:form modelAttribute="m" method="post" action="/events/${event.id}" class="col">
					<div class="form-group">
						<form:label path="message"></form:label>
						<form:input type="textarea" path="message"></form:input>
					</div>
					<div class="form-group">
						<form:hidden path="author" value="${user.id}"></form:hidden>
					</div>
					<div class="form-group">
						<form:hidden path="event" value="${event.id}"></form:hidden>
					</div>
					<button class="btn btn-primary">Post Message</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>