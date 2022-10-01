<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	${msg}
	<h3>Welcome ${pageContext.request.userPrincipal.name }</h3>
	<a href="${pageContext.request.contextPath}/account/logout">Logout</a>
	<a href="${pageContext.request.contextPath}/account/edit/${account.id}">Update
		Account</a>
	<a href="${pageContext.request.contextPath}/tables/index">Table Booking</a>
		<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Account Name</th>
				<th>Tables</th>
				<th>Booking Time</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tablebooking" items="${tableBookings }">
				<tr>
					<td>${tablebooking.id }</td>
					<td>${tablebooking.user.username }</td>
					<td>${tablebooking.table.name }</td>
					<td>${tablebooking.bookingTime }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>