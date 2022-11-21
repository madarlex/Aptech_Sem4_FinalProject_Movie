<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/select2/dist/css/select2.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/jquery-selectric/selectric.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-timepicker/css/bootstrap-timepicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-tagsinput/dist/bootstrap-tagsinput.css">
</head>

<body>
	<!-- Main Content -->

	<section class="section">
		<div class="section-body">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4>Add Movie</h4>
						</div>
						<div class="card-body">
							<s:form modelAttribute="movie" action="${pageContext.request.contextPath }/admin/movie/edit"
								method="post" enctype="multipart/form-data">
								<s:input type="hidden" path="id" />
								<!-- text field name -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Name</label>
								<div class="col-sm-12 col-md-7">
									<s:input type="text" class="form-control" path="name" />
								</div>
							</div>

							<!-- text field trailer to input url link -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Trailer</label>
								<div class="col-sm-12 col-md-7">
									<s:input type="text" class="form-control" path="trailer"/>
								</div>
							</div>

							<!-- upload picture file -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Picture</label>
								<div class="col-sm-12 col-md-7">
									<input type="file" class="form-control" name="file">
								</div>

							</div>

							<!-- editor description -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Description</label>
								<div class="col-sm-12 col-md-7">
									<s:textarea class="summernote" path="description"></s:textarea>
								</div>
							</div>

							<!-- choose date range -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Start Date</label>
								<div class="col-sm-12 col-md-7">
									<div class="input-group">
										<s:input type="date" path="startDate" name="startdate" class="form-control daterange-cus"/>
										<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">End Date</label>
										<s:input type="date" path="endDate" name="enddate" class="form-control daterange-cus"/>
									</div>
								</div>
							</div>

							<!-- Length -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Length</label>
								<div class="col-sm-12 col-md-7">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fas fa-clock"></i>
											</div>
										</div>
										<s:input type="number" class="form-control timepicker" path="length"/>
									</div>
								</div>
							</div>

							<!-- rate -->
							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3">Rate</label>
								<div class="col-sm-12 col-md-7">
									<s:input type="number" class="form-control inputtags" path="rate"/>
								</div>
							</div>

							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-3 col-lg-3"></label>
								<div class="col-sm-12 col-md-7">	
									<input class="btn btn-primary" type="submit" value="Create Movie ">
								</div>
							</div>
								
							</s:form>

							
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

<script
	src="${pageContext.request.contextPath }/resources/admin/bundles/cleave-js/dist/cleave.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/admin/bundles/cleave-js/dist/addons/cleave-phone.us.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/admin/bundles/jquery-pwstrength/jquery.pwstrength.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/admin/bundles/bootstrap-daterangepicker/daterangepicker.js"></script>
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