<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:userTemplate title="welcome">
	<jsp:attribute name="content">	
<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- CSS files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/plugins.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/booking.css">
	<div class="page-single-2">
		<div class="container">
			<div class="row">
				<div class="middle-content">
					<a href="index-2.html"><img class="md-logo"
								src="images/logo1.png" alt=""></a> <img
								src="images/uploads/err-img.png" alt="">
					<h1>Success</h1>
					<a href="${pageContext.request.contextPath}/home/" class="redbtn">go home</a>
				</div>
			</div>
		</div>
	</div>


	<script
				src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
	<script
				src="${pageContext.request.contextPath }/resources/js/plugins.js"></script>
	<script
				src="${pageContext.request.contextPath }/resources/js/plugins2.js"></script>
	<script
				src="${pageContext.request.contextPath }/resources/js/custom.js"></script>

		</jsp:attribute>
</mt:userTemplate>