<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${msg }
<body>
	<h3>Update</h3>
	${account.id } ${account.username }
	<s:form method="post" modelAttribute="account"
		action="${pageContext.request.contextPath }/account/edit">
		<table>
			<tr>
				<td>Password</td>
				<td><s:password path="password" /></td>
			</tr>
			<tr>
				<td><s:hidden path="username" value="${account.username }" /></td>
				<td><s:hidden path="id" value="${account.id }" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Update" /></td>
				<br>
				<a href="${pageContext.request.contextPath }/account/welcome">Welcome
					Page</a>
			</tr>
		</table>
	</s:form>
</body>
</html>