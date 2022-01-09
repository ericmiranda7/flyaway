<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1 style="text-align: center;">Book ${flight.name} flight
		${flight.number}</h1>
	<div style="text-align: center;">
		<p>Please fill in your personal details</p>
		<div>
			<form action="/FlyAway/action/register" method="POST" id="registerForm">
				<label for="fullName">Full name</label> <input type="text"
					name="fullName" /><br />
			</form>
			<label for="address">Address</label>
			<textarea form="registerForm" name="address">Enter your address...</textarea>
			<br /> <label for="age">Age</label> <input form="registerForm"
				name="age" type="number" /><br /> <label for="mobile">Mobile
				Number</label> <input type="text" form="registerForm" name="mobile" /><br />
			<label for="username">Username</label> <input form="registerForm"
				disabled type="text" value="${auth.username}" /><br /> <label
				for="idType">ID Type</label> <select name="idType"
				form="registerForm">
				<c:forEach var="id" items="${applicationScope.idtypes}">
					<c:set var="intId" value="${id.id}" />
					<option value="${intId}">${id.type}</option>
				</c:forEach>
			</select><br /> <label for="country">Country</label> <input type="text"
				form="registerForm" name="country" /><br /> <input type="submit"
				value="Register" form="registerForm" />
		</div>
	</div>
</body>
</html>