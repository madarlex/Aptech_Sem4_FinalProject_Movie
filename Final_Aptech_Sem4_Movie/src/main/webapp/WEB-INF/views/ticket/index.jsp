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
			<div class="row">
				<div class="col-md-12">
					<div class="p-1"></div>
					<div id="trapezoid">
						<h3 class='screen'>Màn Hình</h3>
					</div>
					<div class="list-seats">
						<div>
							<c:forEach var="seat_A" items="${availableSeats_A }">
								<c:if test="${seat_A.status == 1}">
									<div data-value="${seat_A.id }" class="seat gheDaDuocDat">${seat_A.position }</div>
								</c:if>
								<c:if test="${seat_A.status == 0}">
									<div data-value="${seat_A.id }" class="seat">${seat_A.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_B" items="${availableSeats_B }">
								<c:if test="${seat_B.status == 1}">
									<div data-value="${seat_B.id }" class="seat gheDaDuocDat">${seat_B.position }</div>
								</c:if>
								<c:if test="${seat_B.status == 0}">
									<div data-value="${seat_B.id }" class="seat">${seat_B.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_C" items="${availableSeats_C }">
								<c:if test="${seat_C.status == 1}">
									<div data-value="${seat_C.id }" class="seat gheDaDuocDat">${seat_C.position }</div>
								</c:if>
								<c:if test="${seat_C.status == 0}">
									<div data-value="${seat_C.id }" class="seat">${seat_C.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_D" items="${availableSeats_D }">
								<c:if test="${seat_D.status == 1}">
									<div data-value="${seat_D.id }" class="seat gheDaDuocDat">${seat_D.position }</div>
								</c:if>
								<c:if test="${seat_D.status == 0}">
									<div data-value="${seat_D.id }" class="seat">${seat_D.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_E" items="${availableSeats_E }">
								<c:if test="${seat_E.status == 1}">
									<div data-value="${seat_E.id }" class="seat gheDaDuocDat">${seat_E.position }</div>
								</c:if>
								<c:if test="${seat_E.status == 0}">
									<div data-value="${seat_E.id }" class="seat">${seat_E.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_F" items="${availableSeats_F }">
								<c:if test="${seat_F.status == 1}">
									<div data-value="${seat_F.id }" class="seat gheDaDuocDat">${seat_F.position }</div>
								</c:if>
								<c:if test="${seat_F.status == 0}">
									<div data-value="${seat_F.id }" class="seat">${seat_F.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_G" items="${availableSeats_G }">
								<c:if test="${seat_G.status == 1}">
									<div data-value="${seat_G.id }" class="seat gheDaDuocDat">${seat_G.position }</div>
								</c:if>
								<c:if test="${seat_G.status == 0}">
									<div data-value="${seat_G.id }" class="seat">${seat_G.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_H" items="${availableSeats_H }">
								<c:if test="${seat_H.status == 1}">
									<div data-value="${seat_H.id }" class="seat gheDaDuocDat">${seat_H.position }</div>
								</c:if>
								<c:if test="${seat_H.status == 0}">
									<div data-value="${seat_H.id }" class="seat">${seat_H.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_I" items="${availableSeats_I }">
								<c:if test="${seat_I.status == 1}">
									<div data-value="${seat_I.id }" class="seat gheDaDuocDat">${seat_I.position }</div>
								</c:if>
								<c:if test="${seat_I.status == 0}">
									<div data-value="${seat_I.id }" class="seat">${seat_I.position }</div>
								</c:if>
							</c:forEach>
						</div>
						<div>
							<c:forEach var="seat_J" items="${availableSeats_J }">
								<c:if test="${seat_J.status == 1}">
									<div data-value="${seat_J.id }" class="seat gheDaDuocDat">${seat_J.position }</div>
								</c:if>
								<c:if test="${seat_J.status == 0}">
									<div data-value="${seat_J.id }" class="seat">${seat_J.position }</div>
								</c:if>
							</c:forEach>
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
					<div class="list-info-seats" style="margin-top: 20px">
						<div class="row">
							<div class="info-seat col-md-12" align="center">
								<input class="process-button" type="submit" value="Continue" id="buttonContinue">
								<input class="process-button" type="button" value="Back" id="buttonBack">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/plugins2.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/custom.js"></script>
	<script>
		var arrSeats = [];
		$(document).ready(function() {			
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
		
		$(document).ready(function(){
			const xhr = new XMLHttpRequest();
			$("#buttonContinue").click(function(){
				$.ajax({
					type: 'GET',
					data: {bookingSeats : arrSeats},
					url: '${pageContext.request.contextPath}/ticket/continueBookingTicket',
					xhr: function() {
						console.log(xhr);
						return xhr;
					},
					success: function() {
						console.log(xhr.responseURL);
						window.location.replace(xhr.responseURL);
					}
				});
			});
			});
	</script>
</body>
</html>