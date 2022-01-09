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
	<em><c:out value="${result }"/></em>
	<c:remove var="result"/>
	<form action="/FlyAway/action/changepass" method="POST">
		<label for="oldpass">Enter old password</label>
		<input type="password" name="oldpass"/>
		<br/>
		<label for="newpass">Enter new password</label>
		<input type="password" name="newpass"/>
		<br/>
		<label for="confirmpass">Confirm new password</label>
		<input type="password" name="confirmpass"/>
		<br/>
		<input type="submit" value="Change password" />
	</form>
</body>
</html>