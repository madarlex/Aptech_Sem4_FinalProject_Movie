<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Basic need -->
<title>Open Pediatrics</title>
<meta charset="UTF-8">

<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- Mobile specific meta -->
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone-no">

<!-- CSS files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/plugins.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/booking.css">


</head>

<body>
	<div class="hero common-hero">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="hero-ct">
						<h1>Booking</h1>
						<ul class="breadcumb">
							<li class="active"><a href="#">Home</a></li>
							<li><span class="ion-ios-arrow-right"></span> Booking</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="page-single movie_list">
		<div class="container">
			<div class="form-holder">
				<div class="form-content">
					<div class="form-items">
						<h3>Payment</h3>
						<form method="post" action="${postUrl }">
							<input type="hidden" name="return" value="${returnUrl }" /> <input
								type="hidden" name="cmd" value="_xclick" /> <input
								type="hidden" name="business" value="${business }" /> <input
								type="hidden" name="item_name" value="Ticket" /> <input
								type="hidden" name="quantity" value="${seatNumber }" /> <input
								type="hidden" name="amount" value="${ticketPrice }" />
							<div>
								<div>
									<div class="tab" data-value="${ticketPrice }">
										<span>Ticket Price: </span>${ticketPrice } $
									</div>

									<div class="tab" data-value="${seatNumber }">
										<span>Total Booking Seats: </span>${seatNumber }</div>
									<div  class="tab" data-value="${paymentAmount }">
										<span>Total Amount: </span>${paymentAmount } $
									</div>
								</div>
								<div class="row" style="text-align: center;">
									<input class="process-button" type="submit" value="Submit" />
									<input class="process-button" type="button" value="Back"
										id="buttonBack">
								</div>
							</div>
						</form>
					</div>
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
</body>
</html>

