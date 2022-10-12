<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<section class="section">
		<div class="section-body">
			<div class="row">
				<div class="col-12">
					<div class="card card-primary">
						<div class="card-header">
							<h4>Register</h4>
						</div>
						<div class="card-body">
							<form method="POST">
								<div class="row">
								
								<!-- fullname -->
									<div class="form-group col-6">
										<label for="frist_name">First Name</label> <input
											id="frist_name" type="text" class="form-control"
											name="frist_name" autofocus>
									</div>
									<div class="form-group col-6">
										<label for="last_name">Last Name</label> <input id="last_name"
											type="text" class="form-control" name="last_name">
									</div>
								</div>
								
								<!-- username -->
								<div class="form-group">
									<label for="email">User Name</label> <input id="email" type="text"
										class="form-control" name="email">
									<div class="invalid-feedback"></div>
								</div>
								
								<!-- email -->
								<div class="form-group">
									<label for="email">Email</label> <input id="email" type="email"
										class="form-control" name="email">
									<div class="invalid-feedback"></div>
								</div>
								
								<!-- phone -->
								<div class="form-group">
									<label for="email">Phone</label> <input id="email" type="text"
										class="form-control" name="email">
									<div class="invalid-feedback"></div>
								</div>
								
								<!-- password -->
								<div class="row">
									<div class="form-group col-6">
										<label for="password" class="d-block">Password</label> <input
											id="password" type="password" class="form-control pwstrength"
											data-indicator="pwindicator" name="password">
										<div id="pwindicator" class="pwindicator">
											<div class="bar"></div>
											<div class="label"></div>
										</div>
									</div>
									<div class="form-group col-6">
										<label for="password2" class="d-block">Password
											Confirmation</label> <input id="password2" type="password"
											class="form-control" name="password-confirm">
									</div>
								</div>
								<div class="form-group">
									<div class="custom-control custom-checkbox">
										<input type="checkbox" name="agree"
											class="custom-control-input" id="agree"> <label
											class="custom-control-label" for="agree">I agree with
											the terms and conditions</label>
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-lg btn-block">
										Register</button>
								</div>
							</form>
						</div>
						<div class="mb-4 text-muted text-center">
							Already Registered? <a href="auth-login.html">Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<script
	src="${pageContext.request.contextPath }/resources/admin/js/page/auth-register.js"></script>
</html>