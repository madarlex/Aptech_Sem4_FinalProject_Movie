<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<h3>Register</h3>
	<s:form method="post" modelAttribute="account"
		action="${pageContext.request.contextPath }/account/register">
		<table>
			<tr>
				<td>Username</td>
				<td><s:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:password path="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save" /></td>
				<br>
				<a href="${pageContext.request.contextPath }/account/login">Login</a>
			</tr>
		</table>
	</s:form>
</body>
</html>