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
	
	
<div class="hero common-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Search Result</h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span>Search Result</li>
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
				<div class="topbar-filter fw">
				</div>
				<div class="flex-wrap-movielist mv-grid-fw">
					<c:forEach var="movie" items="${movies }"  varStatus="i">
						<div class="movie-item-style-2 movie-item-style-1">
							<img src="${pageContext.request.contextPath }${movie.picture}" alt="">
							<div class="hvr-inner">
	            				<a  href="${pageContext.request.contextPath }/movie/detail/${movie.id}"> Read more <i class="ion-android-arrow-dropright"></i> </a>
	            			</div>
							<div class="mv-item-infor">
								<h6><a href="${pageContext.request.contextPath }/movie/detail/${movie.id}">${movie.shortName }</a></h6>
								<p class="rate"><i class="ion-android-star"></i><span>${movie.rate }</span> /10</p>
							</div>
						</div>			
					</c:forEach>
				</div>		
			</div>
		</div>
	</div>
</div>
	
	</jsp:attribute>
</mt:userTemplate>
</body>
</html>