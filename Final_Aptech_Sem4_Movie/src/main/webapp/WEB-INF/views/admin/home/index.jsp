<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<!-- index.html  21 Nov 2019 03:44:50 GMT -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie</title>
<!-- General CSS Files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/app.min.css">
<!-- Template CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/components.css">
<!-- Custom style CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/admin/css/custom.css">
<link rel='shortcut icon' type='image/x-icon'
	href='${pageContext.request.contextPath }/resources/admin/img/favicon.ico' />
<style type="text/css">
td {
				padding: 20px;
}

td:first-child {
				padding-left: 0px;
}

th {
				padding: 20px;
				text-align: center;
}

th:first-child {
				padding-left: 0px;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
window.onload = function() {
	var dps = [ [] ];
	var chart = new CanvasJS.Chart("chartContainer", {
		theme : "light1", // "light1", "dark1", "dark2"
		animationEnabled : true,
		title : {
			text : "Total of booking by movie"
		},
		axisY : {
			title : "Total of booking",
			includeZero : true,
			valueFormatString: "#",
			interval: 1
		},
		data : [ {
			type : "bar",
			indexLabel : "{y}",
			dataPoints : dps[0]
		} ]
	});

	var xValue;
	var yValue;

	<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
	<c:forEach items="${dataPoints}" var="dataPoint">
	yValue = parseFloat("${dataPoint.y}");
	label = "${dataPoint.label}";
	dps[parseInt("${loop.index}")].push({
		label : label,
		y : yValue
	});
	</c:forEach>
	</c:forEach>

	

	chart.render();

	
	var dps = [ [] ];
	var chart1 = new CanvasJS.Chart("chartContainer1", {
		theme : "light1", // "light1", "dark1", "dark2"
		animationEnabled : true,
		title : {
			text : "Total of revenue by date"
		},
		axisY : {
			title : "Total of revenue",
			includeZero : true,
			valueFormatString: "#",
			prefix: "$",
		},
		data : [ {
			type : "column",
			indexLabel : "{y}",
			dataPoints : dps[0],
			yValueFormatString: "$#",
		} ]
	});

	var xValue;
	var yValue;

	<c:forEach items="${columnDataPointsList}" var="dataPoints" varStatus="loop">
	<c:forEach items="${dataPoints}" var="dataPoint">
	yValue = parseFloat("${dataPoint.y}");
	label = "${dataPoint.label}";
	dps[parseInt("${loop.index}")].push({
		label : label,
		y : yValue
	});
	</c:forEach>
	</c:forEach>
	chart1.render();

	var dps = [ [] ];
	var chart3 = new CanvasJS.Chart("chartContainer3", {
		theme : "light1", // "light1", "dark1", "dark2"
		animationEnabled : true,
		title : {
			text : "Total of revenue by movie"
		},
		axisY : {
			title : "Total of revenue",
			includeZero : true,
			valueFormatString: "#",
			prefix: "$",
		},
		data : [ {
			type : "line",
			indexLabel : "{y}",
			dataPoints : dps[0],
			yValueFormatString: "$#",
		} ]
	});

	var xValue;
	var yValue;

	<c:forEach items="${lineDataPointsList}" var="dataPoints" varStatus="loop">
	<c:forEach items="${dataPoints}" var="dataPoint">
	yValue = parseFloat("${dataPoint.y}");
	label = "${dataPoint.label}";
	dps[parseInt("${loop.index}")].push({
		label : label,
		y : yValue
	});
	</c:forEach>
	</c:forEach>
	chart3.render();

};

	
	
</script>
</head>

<body>
	<div class="row ">
		<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="card-statistic-4">
					<div class="align-items-center justify-content-between">
						<div class="row ">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pr-0 pt-3">
								<div class="card-content">
									<h5 class="font-15">New Booking</h5>
									<h2 class="mb-0 font-26">${countTicket }</h2>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pl-0">
								<div class="banner-img">
									<img
										src="${pageContext.request.contextPath }/resources/admin/img/banner/1.png"
										alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="card-statistic-4">
					<div class="align-items-center justify-content-between">
						<div class="row ">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pr-0 pt-3">
								<div class="card-content">
									<h5 class="font-15">Customers</h5>
									<h2 class="mb-0 font-26">${countAccount }</h2>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pl-0">
								<div class="banner-img">
									<img
										src="${pageContext.request.contextPath }/resources/admin/img/banner/2.png"
										alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="card-statistic-4">
					<div class="align-items-center justify-content-between">
						<div class="row ">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pr-0 pt-3">
								<div class="card-content">
									<h5 class="font-15">Now showing</h5>
									<h2 class="mb-0 font-26">${countMovie }</h2>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pl-0">
								<div class="banner-img">
									<img
										src="${pageContext.request.contextPath }/resources/admin/img/banner/3.png"
										alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xl-3 col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="card">
				<div class="card-statistic-4">
					<div class="align-items-center justify-content-between">
						<div class="row ">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pr-0 pt-3">
								<div class="card-content">
									<h5 class="font-15">Revenue</h5>
									<h2 class="mb-0 font-26">$${totalRevenue }</h2>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 pl-0">
								<div class="banner-img">
									<img
										src="${pageContext.request.contextPath }/resources/admin/img/banner/4.png"
										alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- chart 1 -->
	<div class="row">
		<div class="col-12 col-sm-12 col-lg-12">
			<div class="card ">
				<div class="card-header">
					<h4>Available Seats</h4>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-lg-12">
							<c:forEach items="${movieSchedules }" var="movieSchedule">
								<div class="section-title mt-0">
									<p>${movieSchedule.movie.name }</p>
								</div>
								<div class="form-group">
									<table>
										<tbody>
											<tr>
												<c:forEach items="${movieSchedule.movieshowtimes }"
													var="showtime">

													<td>
														<form
															action="${pageContext.request.contextPath }/admin/booking/getSeats"
															method="post">
															<input type="hidden"
																value="${showtime.movieshowtime.id }" name="showtimeId" />
															<button class="showtime btn btn-primary"
																name="showtime" data-toggle="modal"
																data-target="#exampleModal"
																style="width: 160px; height: 80px">
																<fmt:formatDate
																	value="${showtime.movieshowtime.showTime }"
																	pattern="HH:mm" />
																<fmt:formatDate
																	value="${showtime.movieshowtime.showDate }"
																	pattern="yyyy-MM-dd" />
																<br /> ${showtime.availableSeats } / 160
															</button>
														</form>
													</td>

												</c:forEach>
											</tr>
										</tbody>
									</table>
								</div>
							</c:forEach>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-12 col-sm-12 col-lg-12">
			<div class="card ">
				<div class="card-header">
					<h4>Analyze booking</h4>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-lg-12">
							<div id="chartContainer" style="height: 370px; width: 100%;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12 col-sm-12 col-lg-12">
			<div class="card ">
				<div class="card-header">
					<h4>Analyze Revenue By Date</h4>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-lg-12">
							<div id="chartContainer1" style="height: 370px; width: 100%;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-12 col-sm-12 col-lg-12">
			<div class="card ">
				<div class="card-header">
					<h4>Analyze Revenue By Movie</h4>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-lg-12">
							<div id="chartContainer3" style="height: 370px; width: 100%;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- chart test -->
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/admin/bundles/apexcharts/apexcharts.min.js"></script>
</body>