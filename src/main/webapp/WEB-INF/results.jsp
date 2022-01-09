<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${flights.isEmpty()}">
			<p>Sorry, no flights available according to search criteria.</p>
			<a href="/FlyAway/">Go back</a>
		</c:when>
		<c:otherwise>
			<table style="border: 1px solid black;">
				<tr style="text-align: center;">
					<th>Name</th>
					<th>Price</th>
					<th>Flight Number</th>
					<th>From</th>
					<th>To</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Total Seats</th>
					<th>Booked Seats</th>
					<th>Seat Availability</th>
					<th>Travel Date</th>
					<th>Class</th>
				</tr>
				<c:forEach var="object" items="${flightList}">
					<tr>
						<c:forEach var="field" items="${object['class'].declaredFields}">
							<c:catch>
								<td style="padding: 15px; text-align: center;"><c:choose>
										<c:when test="${field.name == 'name' }">
											<c:set var="flightNumberLink" value="/FlyAway/pages/flight?number=${object.number}" />
											<a href="${flightNumberLink}">${object[field.name]}</a>
										</c:when>
										<c:otherwise>
									${object[field.name]}
									</c:otherwise>
									</c:choose></td>
							</c:catch>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>