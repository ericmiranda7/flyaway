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
	Thank you for booking with us, ${booking.username} ! Please save your flight details <br/>
	Email-ID: ${booking.username }
	<br/>
	Flight Number: ${booking.flightNumber}
	<br/>
	Booking ID: ${booking.bookingId}
	<br/>
	
	<a href="/FlyAway/">Go home...</a>
</body>
</html>