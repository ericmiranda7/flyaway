<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to your account</title>
</head>
<body>
	<p style="border: 1px solid red">${result}</p>
	<c:remove var="result" scope="session"/>
	<p>Please login:</p>
	<form action="action/login" method="POST">
		<label for="username">Username: </label>
		<input type="text" name="username" />
		<br/>
		<label for="password">Password: </label>
		<input type="password" name="password" />	
		<br/>
		<input type="submit" value="Login" />
	</form>
</body>
</html>