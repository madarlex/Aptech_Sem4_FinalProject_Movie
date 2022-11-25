<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>Otika - Admin Dashboard Template</title>
<!-- General CSS Files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/app.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-timepicker/css/bootstrap-timepicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-tagsinput/dist/bootstrap-tagsinput.css">
<style type="text/css">
td {
				padding: 15PX 15px
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript">
	function addViaAjax() {

		var name = $("#movie").val();

		console.log(name);
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/schedule/test",
			data : {
				name : name,
			},
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				var result = "<h3> You just add new Person </h3>"
						+ "<strong>Name:</strong> " + data.name + "<br>"
						+ "<strong>Age:</strong> " + data.age;
				$("#ajax-response").html(result);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	}

	var isClicked = false;

	function toggle() {
		isClicked = !isClicked;
		console.log("clicked: " + isClicked);

	}
</script>
</head>

<body>
	<!-- Main Content -->
	<section class="section">
		<div class="section-body">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4>Add Hall</h4>
						</div>
						<div class="card-body">
							<!-- choose hall name -->
							<s:form method="post"
								action="${pageContext.request.contextPath }/admin/price/edit"
								modelAttribute="price">
								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Price</label>
									<div class="col-sm-12 col-md-7">
										<s:input type="number" class="form-control" path="price" />
										<s:input type="number" path="id"/>
									</div>
								</div>

								<!-- choose seat quantity -->
								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Description</label>
									<div class="col-sm-12 col-md-7">
										<s:textarea class="summernote" path="description"></s:textarea>
									</div>
								</div>

								<!-- submit button -->
								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-3 col-lg-3"></label>
									<div class="col-sm-12 col-md-7">
										<input class="btn btn-primary" type="submit"
											value="Create Price">
									</div>
								</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script
		src="${pageContext.request.contextPath }/resources/admin/js/jquery.js"></script>

	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/jquery-pwstrength/jquery.pwstrength.min.js"></script>
	<!-- 
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-daterangepicker/daterangepicker.js"></script>
		 -->
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/select2/dist/js/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/jquery-selectric/jquery.selectric.min.js"></script>
	<script>
		$("#button").click(function() {
			$("#toggle").toggle();
		});
	</script>
</body>