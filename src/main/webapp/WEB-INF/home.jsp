<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to FlyAway !</title>
</head>
<body>
	<h1>
		<a href="action/logout" style="font-size: 20px; float: right;">Logout</a>
		Welcome Home !
	</h1>

	<h2 style="text-align: center">Search</h2>
	<div style="text-align: center;">
		<div
			style="text-align: center; border: 1px solid gray; display: inline-block; padding: 20px;">
			<form action="action/search" method="POST" id="search">
				<label for="date">Date: </label> <input type="date" name="date">
				<br />
			</form>

			<label for="fromCity">From: </label> <select name="fromCity"
				form="search">
			</select> <br /> <label for="toCity">To: </label> <select name="toCity"
				form="search">
			</select> <br /> <label for="noOfPersons">Persons: </label> <input
				type="number" name="noOfPersons" form="search" />
		</div>
	</div>
</body>
</html>