<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>Movie Booking Online</title>
<!-- General CSS Files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/summernote/summernote-bs4.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/codemirror/lib/codemirror.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-timepicker/css/bootstrap-timepicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/codemirror/theme/duotone-dark.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/select2/dist/css/select2.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/jquery-selectric/selectric.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='${pageContext.request.contextPath }/resources/admin/img/favicon.ico' />
</head>

<body>
	<div class="loader"></div>
	<div id="app">
		<div class="main-wrapper main-wrapper-1">

			<!-- Navbar -->
			<jsp:include page="navbar.jsp"></jsp:include>

			<!-- Side bar -->
			<div class="main-sidebar sidebar-style-2">
				<jsp:include page="sidebar.jsp"></jsp:include>
			</div>
			<!-- Main Content -->


			<div class="main-content">
				<jsp:include page="${p }"></jsp:include>
			</div>


			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- General JS Scripts -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/app.min.js"></script>
	<!-- JS Libraies -->

	<!-- Page Specific JS File -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/summernote/summernote-bs4.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/codemirror/lib/codemirror.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/codemirror/mode/javascript/javascript.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/jquery-selectric/jquery.selectric.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/select2/dist/js/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>

	<!-- Page Specific JS File -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/page/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/page/forms-advanced-forms.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/page/index.js"></script>
	<!-- Template JS File -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/scripts.js"></script>
	<!-- Custom JS File -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/custom.js"></script>

</body>


<!-- index.html  21 Nov 2019 03:47:04 GMT -->
</html>