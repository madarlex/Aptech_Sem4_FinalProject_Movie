<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
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
<<<<<<< HEAD

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
=======
<body>
<mt:userTemplate title="welcome">
	<jsp:attribute name="content">		
	
	<style>
		.account{
		font-family: 'Dosis', sans-serif;
    font-size: 14px;
    color: #222222;
    font-weight: bold;
    margin-top: 10px;
    height: 42px;
    border: 1px solid #e1e1e1;
		}
		.btn-account{
			font-family: 'Dosis', sans-serif;
    font-size: 14px;
    color: #ffffff;
    font-weight: bold;
    text-transform: uppercase;
    border: none;
    background-color: #dd003f;
    height: 42px;
    width: 100%;
    cursor: pointer;
		}
	</style>
	
		</style>
			<script>
			$(document).ready(function() {
				$("#editForm").validate({
					rules: {
						password: {
							minlength: 6,
							maxlength: 32
						},
						fullName: "required",
						phone: "required"
					},
					messages: {
						Password: {
							required: "Please Input Data For Password",
							minlength: "At Least 6 Characters",
							maxlength: "32 Characters At Most"
						},
						Fullname: "Please Input Data For Fullname",
						Phone: "Please Input Data For Phone",
					}
				});
			});
		</script>
		<style>
			.error{
				color:red;
			}
		</style>
	
<div class="hero common-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Edit Account</h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span>Edit Account</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="page-single">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<section class="vh-100">
				  <div class="container-fluid h-custom">
				    <div class="row d-flex justify-content-center align-items-center h-100">
				      <div class="col-md-9 col-lg-6 col-xl-5">
				        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
				          class="img-fluid" alt="Sample image">
				      </div>
				      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
				        <s:form method="post" modelAttribute="account" action="${pageContext.request.contextPath}/account/edit" id="editForm">
				          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
				          	</br></br></br></br>
				          </div>
				          <p class="text-success">${msg }</p>
				          <div class="form-outline mb-4">
				              <s:input path="fullName" class="form-control form-control-lg account" id="fullName" placeholder="Enter your fullname..."  />
				          </div>
				          <div class="form-outline mb-4">
				              <s:input  readonly="true" path="username" class="form-control form-control-lg account" id="username" placeholder="Enter your username..."  />
				          </div>
				          <div class="form-outline mb-3">
				              <s:password path="password" class="form-control form-control-lg account" id="password"  placeholder="Enter your password..." />
				          </div>
							<div class="form-outline mb-4">
				              <s:input  readonly="true" path="email" class="form-control form-control-lg account" id="email" placeholder="Enter your email..."  />
				          </div>
				          <div class="form-outline mb-4">
				              <s:input path="phone" class="form-control form-control-lg account" id="phone" placeholder="Enter your phone..."  />
				          </div>
				          <s:hidden path="id"/>
				          </br>				
				          <div class="text-center text-lg-start mt-4 pt-2">
				            <button type="submit" class="btn btn-primary btn-lg btn-account"
				              style="padding-left: 2.5rem; padding-right: 2.5rem;">Edit</button>
				            <p class="small fw-bold mt-2 pt-1 mb-0">You have an account? <a href="#!"
				                class="link-danger">Login</a></p>
				          </div>
				        </s:form>
				      </div>
				    </div>
				  </div>
				  <div
				    class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
				  </div>
				</section>
			</div>
		</div>
	</div>
</div>
	
	</jsp:attribute>
</mt:userTemplate>
>>>>>>> e14c949 (user template)
</body>
</html>