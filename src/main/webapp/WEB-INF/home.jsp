<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to FlyAway !</title>
</head>
<body>
	<h1>
		<a href="action/logout" style="font-size: 20px; float: right;">Logout</a>
		<c:if test="${auth.admin}">
			<a href="pages/changepass" style="font-size: 20px; float: right;">Change Password</a>
		</c:if>
		Welcome Home !
	</h1>

	<h2 style="text-align: center">Search</h2>
	<div style="text-align: center;">
		<div
			style="text-align: center; border: 1px solid gray; display: inline-block; padding: 20px;">
			<form action="action/search" method="GET" id="search">
				<label for="date">Date: </label> <input type="date" name="date">
				<br />
			</form>

			<label for="fromCity">From: </label>
			<select name="fromCity" form="search">
				<c:forEach var="state" items="${states}">
					<option value=${state.id}>${state.name}</option>		
				</c:forEach>
			</select>
			<br />
			<label for="toCity">To: </label>
			<select name="toCity" form="search">
				<c:forEach var="state" items="${states}">
					<option value=${state.id}>${state.name}</option>		
				</c:forEach>
			</select>
			<br />
			<label for="noOfPersons">Persons: </label>
			<input type="number" name="noOfPersons" form="search" />
			<br/>
			<input type="submit" form="search" value="Search" />
		</div>
	</div>
</body>
</html>