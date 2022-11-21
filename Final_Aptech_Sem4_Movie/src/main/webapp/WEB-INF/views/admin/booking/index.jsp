<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.*, java.util.Date, java.util.Enumeration"%>
<%@page import="java.util.Calendar"%>
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
				padding: 20px;
}

td:first-child {
				padding-left: 0px
}

th {
				padding: 20px;
				text-align: center;
}

th:first-child {
				padding-left: 0px
}

button {
				width: 130px;
				height: 60px
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript">
	function addViaAjax() {

		var date = $("#showDate").val();
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "${home}schedule/search/" + date,
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

	function toggle(clicked_id) {
		$("#" + clicked_id).addClass("active");
		console.log("clicked: " + clicked_id);
	}
</script>
</head>



<body>
	<!-- Main Content -->
	<c:url var="home" value="/" scope="request" />
	<section class="section">

		<div class="section-body">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header">
							<h4>Add Movie Showtime</h4>
						</div>
						<div class="card-body">
							<!-- choose movie -->


							<div class="form-group row mb-4">
								<label
									class="col-form-label text-md-right col-12 col-md-2 col-lg-2">Movie</label>
								<div class="col-sm-12 col-md-9">
									<form method="post"
										action="${pageContext.request.contextPath }/admin/booking/movies">
										<select class="form-control select2" name="movieId">
											<c:forEach var="movie" items="${movies }">
												<option value="${movie.id }"
													${choosenMovie != null ? (choosenMovie == movie.id ? "selected" : "") : "" }>${movie.name }</option>
											</c:forEach>
										</select> <input type="date" class="form-control"
											style="margin-top: 10px" name="date" value="${showDate }" />
										<input type="submit" class="btn btn-primary"
											style="margin-top: 10px" value="Find">
									</form>
								</div>
							</div>

							<c:if test="${showtimes != null }">
								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-2 col-lg-2">Show
										Time</label>
									<div class="col-sm-12 col-md-9">
										<table>
											<tbody>
												<tr>
													<c:forEach items="${showtimes }" var="showtime">
														<td>
															<form
																action="${pageContext.request.contextPath }/admin/booking/seats"
																method="post">
																<input type="hidden" name="movieId"
																	value="${choosenMovie }"> <input type="hidden"
																	name="date" value="${showDate }">
																<button
																	class="btn btn-outline-primary showtime ${choosenShowtime != null ? (choosenShowtime.id == showtime.id ? 'active' : '') : '' }"
																	type="submit" style="height: 50px; width: 120px"
																	data-value="${showtime }" name="showtime"
																	value="${showtime.id }">
																	<fmt:formatDate value="${showtime.showTime }"
																		pattern="HH:mm" />
																</button>
															</form>
														</td>
													</c:forEach>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</c:if>
							<form method="post"
								action="${pageContext.request.contextPath }/admin/booking/booking">
								<input type="hidden" name="choosenShowtimeId"
									value="${choosenShowtime.id }" />
								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-2 col-lg-2">Seat</label>
									<div class="col-sm-12 col-md-9">
										<select class="form-control select2" name="seatId" multiple="">
											<c:forEach var="seat" items="${availableSeats }">
												<option value="${seat.id }">${seat.position}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-2 col-lg-2">Account</label>
									<div class="col-sm-12 col-md-9">
										<select class="form-control select2" name="accountId">
											<c:forEach var="account" items="${accounts }">
												<option value="${account.id }">${account.username }</option>
											</c:forEach>
										</select>
									</div>
								</div>



								<!-- submit button -->
								<div class="form-group row mb-4">
									<label
										class="col-form-label text-md-right col-12 col-md-2 col-lg-2"></label>
									<div class="col-sm-12 col-md-9"
										style="display: flex; align-items: center">
										<input class="btn btn-primary" id="submit" style="margin: 0"
											type="submit" value="Create">
									</div>
								</div>
							</form>
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