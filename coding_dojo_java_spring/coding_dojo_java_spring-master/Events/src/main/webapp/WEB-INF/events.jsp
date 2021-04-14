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
		<div>
			<h1 class="col"><c:out value="Welcom, ${user.firstName}"></c:out></h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="row">
			<h2>Here are some of the events in your state:</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Location</th>
						<th>Host</th>
						<th>Action/Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${events}" var="e">
						<tr>
							<td><a href="/events/${e.id}"><c:out value="${e.name}"></c:out></a></td>
							<td><c:out value="${e.eventDate}"></c:out></td>
							<td><c:out value="${e.city}, ${e.state}"></c:out></td>
							<td><c:out value="${e.host.firstName} ${e.host.lastName}"></c:out></td>
							<td>
								<c:if test="${e.host == user}">
									<a href="events/${e.id}/edit">Edit</a>
									<a href="events/${e.id}/delete">Delete</a>
								</c:if>
								<c:choose>
									<c:when test="${user.eventsAttended.contains(e)}">
										<a href="/events/${e.id}/unjoin">Unjoin</a>
									</c:when>
									<c:otherwise>
										<a href="/events/${e.id}/join">Join</a>
									</c:otherwise>
								</c:choose>
								<a href="events/${e.id}/cancel">Cancel</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<h2>Here are some of the events in other states:</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Date</th>
						<th>Location</th>
						<th>Host</th>
						<th>Action/Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${otherEvents}" var="oe">
						<tr>
							<td><a href="/events/${oe.id}"><c:out value="${oe.name}"></c:out></a></td>
							<td><c:out value="${oe.eventDate}"></c:out></td>
							<td><c:out value="${oe.city}, ${oe.state}"></c:out></td>
							<td><c:out value="${oe.host.firstName} ${oe.host.lastName}"></c:out></td>
							<td>
								<c:choose>
									<c:when test="${user.eventsAttended.contains(oe)}">
										<a href="/events/${oe.id}/unjoin">Unjoin</a>
									</c:when>
									<c:otherwise>
										<a href="/events/${oe.id}/join">join</a>
									</c:otherwise>
								</c:choose>
								<a href="events/${oe.id}/cancel">Cancel</a>
								<a href="events/${oe.id}/edit">Edit</a>
								<a href="events/${oe.id}/delete">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<h2>Create an Event</h2>
			<form:form modelAttribute="newEvent" method="post" action="/events/new">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:errors path="name"/>
					<form:input path="name"/>
				</div>
				<div class="form-group">
					<form:label path="eventDate">Date:</form:label>
					<form:errors path="eventDate"/>
					<form:input type="date" path="eventDate"/>
				</div>
				<div class="form-group">
					<form:label path="city">Location:</form:label>
					<form:errors path="city"/>
					<form:input path="city"/>
					
					<form:errors path="state"/>
					<form:select path="state">
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