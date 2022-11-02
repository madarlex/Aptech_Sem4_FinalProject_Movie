<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
		<script>
			$(document).ready(function() {
				$("#loginForm").validate({
					rules: {
						username: "required",
						password: {
							required: true,
							minlength: 6,
							maxlength: 32
						},
					},
					messages: {
						Username: "Please Input Data For Username",
						Password: {
							required: "Please Input Data For Password",
							minlength: "At Least 6 Characters",
							maxlength: "32 Characters At Most"
						},
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
					<h1>Login</h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span> Login</li>
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
				        <form method="post"  action="${pageContext.request.contextPath }/account/processLogin" id="loginForm">
				          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
				          </div>
				          </br></br></br></br>
				          <div class="form-outline mb-4">
				            <input name="username" type="text" id="username" class="form-control form-control-lg account"
				              placeholder="Enter username" />
				          </div>
							</br>
				          <div class="form-outline mb-3">
				            <input name="password" type="password" id="password" class="form-control form-control-lg account"
				              placeholder="Enter password" />
				          </div>
							</br>
				          <div class="d-flex justify-content-between align-items-center">
				            <div class="form-check mb-0">
				              <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
				              <label class="form-check-label" for="form2Example3">
				                Remember me
				              </label>
				            </div>
				            <a href="${pageContext.request.contextPath }/account/resetPassword" class="text-body">Forgot password?</a>
				          </div>
				
				          <div class="text-center text-lg-start mt-4 pt-2">
				            <button type="submit" class="btn btn-primary btn-lg btn-account"
				              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
				            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="#!"
				                class="link-danger">Register</a></p>
				          </div>
				
				        </form>
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
</body>
</html>