<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<mt:userTemplate title="welcome">
	<jsp:attribute name="content">		
	<div class="page-single-2">
	<div class="container">
		<div class="row">
			<div class="middle-content">
				<a href="index-2.html"><img class="md-logo" src="images/logo1.png" alt=""></a>
				<img src="images/uploads/err-img.png" alt="">
				<h1>You do not have permission to access this page</h1>
				<a href="${pageContext.request.contextPath }/home" class="redbtn">go home</a>
			</div>
		</div>
	</div>
</div>
	
	</jsp:attribute>
</mt:userTemplate>
</body>
</html>