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
	
<div class="hero user-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>List History Movie</h1>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="page-single userfav_list">
	<div class="container">
		<div class="row ipad-width2">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="topbar-filter user">
					
				</div>
				<div class="flex-wrap-movielist user-fav-list">
					<div class="row">
					<c:forEach var="ticket" items="${tickets }"  varStatus="i">
						<div class="col-md-4" style="display: flex; margin-bottom: 30px">
						<img src="${pageContext.request.contextPath }${ticket.getMovieshowtime().getMovie().picture }" alt="">
						  <div class="mv-item-infor" style="margin-left: 15px">
								<h4><a style="color: #ffffff;font-family: 'Dosis', sans-serif; font-size: 24px" href="#">${ticket.getMovieshowtime().getMovie().name }</a></h4>
								<p style="margin-top: 5px" class="rate"><i style="color: #f5b50a;
    font-size: 22px;
    margin-right: 5px;
}" class="ion-android-star"></i><span>${ticket.getMovieshowtime().getMovie().rate }</span> /10</p>
								<p class="run-time"> Run Time: ${ticket.getMovieshowtime().getMovie().length }p    <span>Release: ${ticket.getMovieshowtime().getMovie().startDate }</span></p>
								<p>Seat: ${ticket.getSeat().position }</p>
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