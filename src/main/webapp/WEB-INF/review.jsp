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
	<h3>Please review the following details before proceeding for
		payment</h3>
	Name: ${regDetails.fullName }
	<br /> Address: ${regDetails.address }
	<br /> Age: ${regDetails.age }
	<br /> Mobile: ${regDetails.mobile }
	<br /> Username: ${auth.username}
	<br /> ID Type: ${regDetails.idType }
	<br /> Country: ${regDetails.country }
	
	<form action="pay">
		<input type="submit" value="Proceed to pay">
	</form>
</body>
</html>