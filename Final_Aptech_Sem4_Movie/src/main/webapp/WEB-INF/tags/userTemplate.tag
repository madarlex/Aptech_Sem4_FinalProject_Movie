<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="content" fragment="true" %>
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7 no-js" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8 no-js" lang="en-US">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="en" class="no-js">


<head>
<!-- Basic need -->
 <title>${title }</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<link rel="profile" href="#">

<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- Mobile specific meta -->
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone-no">

<!-- CSS files -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/plugins.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/style.css">
	<script src="${pageContext.request.contextPath }/resources/user/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/resources/user/js/jquery.validate.js" ></script>

</head>
<body>
	<!--preloading-->
<%-- 	<div id="preloader">
		<img class="logo" src="${pageContext.request.contextPath }/resources/user/images/logo1.png" alt="" width="119"
			height="58">
		<div id="status">
			<span></span> <span></span>
		</div>
	</div> --%>
	<!--end of preloading-->
	<!--login form popup-->
	
	<!--end of login form popup-->
	<!--signup form popup-->
	
	<!--end of signup form popup-->

	<!-- BEGIN | Header -->
	<header class="ht-header">
		<div class="container">
			<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
					<div class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<div id="nav-icon1">
							<span></span> <span></span> <span></span>
						</div>
					</div>
					<a href="${pageContext.request.contextPath }/home/"><img class="logo" src="${pageContext.request.contextPath }/resources/user/images/cinema_logo.png"
						alt="" width="119" height="58"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden"><a href="#page-top"></a></li>
						<li><a href="${pageContext.request.contextPath }/home">Home</a></li>
						<li><a href="${pageContext.request.contextPath }/movie/list">Movie</a></li>
						<li><a href="${pageContext.request.contextPath }/about/index">About</a></li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">
						<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
							data-toggle="dropdown" data-hover="dropdown"> Account <i
								class="fa fa-angle-down" aria-hidden="true"></i>
						</a>
							<ul class="dropdown-menu level1">
								<li><a href="${pageContext.request.contextPath }/account/history">History</a></li>
								<li><a href="${pageContext.request.contextPath }/account/edit">Edit</a></li>
								
							</ul></li>
						<li>

						    <c:if test="${pageContext.request.userPrincipal.name == null}">
								<a href="${pageContext.request.contextPath }/account/login">LOG IN</a>
						    </c:if>    

						    <c:if test="${pageContext.request.userPrincipal.name != null}">
								<a href="${pageContext.request.contextPath }/account/logout">LOG OUT</a>
						    </c:if>  
							
						</li>

						<li style="background-color: #dd003f;
    color: #ffffff;
    padding: 11px
px
 25px;
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;"><a href="${pageContext.request.contextPath }/account/register">Register</a></li>
    						<li style="background-color: #dd003f;
    color: #ffffff;
    padding: 11px
px
 25px;
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;">
							<c:if test="${not empty pageContext.request.userPrincipal}">
								<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
									<a href="${pageContext.request.contextPath }/account/login">CHECK</a>
							    </c:if>
							 </c:if> 
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>

			<!-- top search form -->
			<div class="top-search">
				<form style="width: 100%" method="get" action="${pageContext.request.contextPath }/movie/search">
					 <input name="keyword" type="text"	placeholder="Search for a movie that you are looking for">
				</form>
			</div>
		</div>
	</header>
	<!-- END | Header -->

	<jsp:invoke fragment="content"></jsp:invoke>

	</div>
	</section>
	<!-- Footer-->
	<!-- footer section-->
	<footer class="ht-footer">
		<div class="container">
			<div class="flex-parent-ft">
				<div class="flex-child-ft item1">
					<a href="${pageContext.request.contextPath }/home/"><img class="logo" src="${pageContext.request.contextPath }/resources/user/images/cinema_logo.png"
						alt="" width="180" height="120"></a>
					<p>
						5th Avenue st, manhattan<br> New York, NY 10001
					</p>
					<p>
						Call us: <a href="#">(+01) 202 342 6789</a>
					</p>
				</div>
				<div class="flex-child-ft item2">
					<h4>Resources</h4>
					<ul>
						<li><a href="#">About</a></li>
						<li><a href="#">Contact Us</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item3">
					<h4>Legal</h4>
					<ul>
						<li><a href="#">Terms of Use</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Security</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item4">
					<h4>Account</h4>
					<ul>
						<li><a href="#">My Account</a></li>
						<li><a href="#">Watchlist</a></li>
						<li><a href="#">Collections</a></li>
						<li><a href="#">User Guide</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item5">
					<h4>Newsletter</h4>
					<p>
						Subscribe to our newsletter system now <br> to get latest
						news from us.
					</p>
					<form action="#">
						<input type="text" placeholder="Enter your email...">
					</form>
					<a href="#" class="btn">Subscribe now <i
						class="ion-ios-arrow-forward"></i></a>
				</div>
			</div>
		</div>
		<div class="ft-copyright">
			<div class="ft-left">
				<p>
					<a target="_blank" href="https://www.templateshub.net">Templates
						Hub</a>
				</p>
			</div>
			<div class="backtotop">
				<p>
					<a href="#" id="back-to-top">Back to top <i
						class="ion-ios-arrow-thin-up"></i></a>
				</p>
			</div>
		</div>
	</footer>
	<!-- end of footer section-->


	<script src="${pageContext.request.contextPath }/resources/user/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath }/resources/user/js/plugins2.js"></script>
	<script src="${pageContext.request.contextPath }/resources/user/js/custom.js"></script>
</body>


</html>