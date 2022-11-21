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

<script>
	function checkPass(){
		var pas1 = document.getElementById("password");
		var pas2 = document.getElementById("password2");
		var btn = document.getElementById("btnRegis");
		if(pas1.value === pas2.value){
			btn.removeAttribute("disabled")
		}else{
			alert('Confirm password incorrect')	
			btn.setAttribute("disabled","")
		}
	}
	
</script>
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
							<s:form modelAttribute="account" action="${pageContext.request.contextPath }/admin/account/add" method="POST">
								<!-- <div class="row">
								fullname
									<div class="form-group col-6">
										<label for="frist_name">First Name</label> <input
											id="frist_name" type="text" class="form-control"
											name="frist_name" autofocus>
									</div>
									<div class="form-group col-6">
										<label for="last_name">Last Name</label> <input id="last_name"
											type="text" class="form-control" name="last_name">
									</div>
								</div> -->
								<!-- fullname -->
								<div class="form-group">
									<label for="email">Full Name</label> 
									<s:input type="text" class="form-control" path="fullName"/>
									<div class="invalid-feedback"></div>
								</div>
								<!-- username -->
								<div class="form-group">
									<label for="email">User Name</label>
									 <s:input type="text" class="form-control" path="username"/>
									<div class="invalid-feedback"></div>
								</div>
								
								<!-- email -->
								<div class="form-group">
									<label for="email">Email</label> 
									<s:input type="text" class="form-control" path="email"/>
									<div class="invalid-feedback"></div>
								</div>
								
								<!-- phone -->
								<div class="form-group">
									<label for="email">Phone</label>
									 <s:input type="text" class="form-control" path="phone"/>
									<div class="invalid-feedback"></div>
								</div>
								
								<!-- password -->
								<div class="row">
									<div class="form-group col-6">
										<label for="password" class="d-block">Password</label> 
										<s:input  id="password" type="password" class="form-control pwstrength"
											data-indicator="pwindicator" path="password" />
										<div id="pwindicator" class="pwindicator">
											<div class="bar"></div>
											<div class="label"></div>
										</div>
									</div>
									<div class="form-group col-6">
										<label for="password2" class="d-block">Password
											Confirmation</label> <input  id="password2" type="password"
											class="form-control" name="password-confirm" onfocusout="checkPass()">
									</div>
								</div>
								
								<div class="form-group">
									<label for="email">Role</label>
										<%--  <c:forEach var="t" items="${types }">
											 <div class="form-check">
												<input class="form-check-input" type="radio" name="type" value="${t.id }">
												<label class="form-check-label">
						                          ${t.name }
						                        </label>
					                        </div>
										</c:forEach> --%>
										<c:forEach var="t" items="${types }">
											<br><input type="radio" name="type" value="${t.id }"> ${t.name }<br>
										</c:forEach>
									<div class="invalid-feedback"></div>
								</div>
								
								<div class="form-group">
									<button id="btnRegis" type="submit" class="btn btn-primary btn-lg btn-block">
										Register</button>
								</div>
							</s:form>
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