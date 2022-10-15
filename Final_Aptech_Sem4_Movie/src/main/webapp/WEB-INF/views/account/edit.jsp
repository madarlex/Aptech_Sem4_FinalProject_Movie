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
	<s:form method="post" modelAttribute="selectedSeat"
		action="${pageContext.request.contextPath }/ticket/book">
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
				<div class="row">
					<div class="col-md-12">
						<div class="p-1"></div>
						<div id="trapezoid">
							<h3 class='screen'>Màn Hình</h3>
						</div>
						<div class="list-seats">
							<div>
								<c:forEach var="seat_A" items="${availableSeats_A }">
									<div data-value="1" class="seat">A1</div>
									<div data-value="2" class="seat">A2</div>
									<div data-value="3" class="seat">A3</div>
									<div data-value="4" class="seat">A4</div>
									<div data-value="5" class="seat">A5</div>
									<div data-value="6" class="seat">A6</div>
									<div data-value="7" class="seat gheVip">A7</div>
									<div data-value="8" class="seat gheVip">A8</div>
									<div data-value="9" class="seat gheVip">A9</div>
									<div data-value="10" class="seat">A10</div>
									<div data-value="11" class="seat">A11</div>
									<div data-value="12" class="seat gheDaDuocDat">A12</div>
									<div data-value="13" class="seat">A13</div>
									<div data-value="14" class="seat gheDaDuocDat">A14</div>
									<div data-value="15" class="seat">A15</div>
									<div data-value="16" class="seat">A16</div>
									<div data-value="17" class="seat">A17</div>
									<div data-value="18" class="seat">A18</div>
								</c:forEach>
							</div>
							<div>
								<div data-value="19" class="seat">B1</div>
								<div data-value="20" class="seat">B2</div>
							</div>
							<div>
								<div data-value="19" class="seat">C3</div>
							</div>
						</div>
						<div class="list-info-seats">
							<div class="parent-line">
								<div class="line"></div>
							</div>
							<div class="row">
								<div class="col-md-3 info-seat">
									<p class="seat-label">GHẾ CHƯA ĐẶT</p>
									<div class="seat-info gheChuaDat">Seat</div>
								</div>
								<div class="col-md-3 info-seat">
									<p class="seat-label ">GHẾ ĐĂNG ĐẶT</p>
									<div class="seat-info gheDangDat">Seat</div>
								</div>
								<div class="col-md-3 info-seat">
									<p class="seat-label ">GHẾ VIP</p>
									<div class="seat-info gheVip">Seat</div>
								</div>
								<div class="col-md-3 info-seat">
									<p class="seat-label ">GHẾ ĐÃ ĐƯỢC ĐẶT</p>
									<div class="seat-info gheDaDuocDat">Seat</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



	</s:form>
	<script src="js/jquery.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/plugins2.js"></script>
	<script src="js/custom.js"></script>
	<script>
		$(document).ready(function() {
			var arrSeats = [];
			$('.seat').not('.gheDaDuocDat').click(function() {
				$(this).toggleClass("gheDangDat")
				var dataValueSeat = parseInt($(this).attr("data-value"));
				var index = arrSeats.indexOf(dataValueSeat);
				if (index != -1) {
					arrSeats.splice(index, 1);
				} else {
					arrSeats.push(dataValueSeat);
				}
				console.log(arrSeats)
			});
		});
	</script>
</body>
</html>