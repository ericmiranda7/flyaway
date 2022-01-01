<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to your account</title>
</head>
<body>
	<p>Please login:</p>
	<form action="/action/login" method="POST">
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