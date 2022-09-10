<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${msg }
<body>
	<h3>Login</h3>
	<form method="post" action="${pageContext.request.contextPath }/account/processLogin">
		Username <input type="text" name="username">
		<br>
		Password <input type="password" name="password">
		<br>
		<input type="submit" value="Login">
		<br>
		<a href="${pageContext.request.contextPath }/account/register">Register</a>
	</form>
</body>
</html>