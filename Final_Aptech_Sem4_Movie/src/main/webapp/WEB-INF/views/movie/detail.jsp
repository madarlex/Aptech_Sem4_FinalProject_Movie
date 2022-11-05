<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>

<body>
	<mt:userTemplate title="welcome">
		<jsp:attribute name="content">		
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/user/css/star_rating.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="hero mv-single-hero">
	<div class="container">
	</div>
</div>
<div class="page-single movie-single movie_single"
				style="padding-bottom: 15px;">
	<div class="container">
		<div class="row ipad-width2">
			<div class="col-md-4 col-sm-12 col-xs-12">
				<div class="movie-img sticky-sb">
					<img src="${pageContext.request.contextPath }${movie.picture }"
									alt="">
					<div class="movie-btn">	
						<div class="btn-transform transform-vertical red">
							<div>
											<a href="" class="item item-1 redbtn"> <i
												class="ion-play"></i> Watch Trailer</a>
										</div>
							<div>
											<a href="${movie.trailer }"
												class="item item-2 redbtn fancybox-media hvr-grow"><i
												class="ion-play"></i></a>
										</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8 col-sm-12 col-xs-12">
				<div class="movie-single-ct main-content">
					<h1 class="bd-hd">${movie.name }</h1>
					<div class="movie-rate">
						<div class="rate">
							<i class="ion-android-star"></i>
							<p>
											<span>${movie.rate}</span> /10<br>
							</p>
						</div>
						
					</div>
					<div class="movie-tabs">
						<div class="tabs">
								<div class="overview-title">Overview</div>
								<p>${movie.description }</p>                      
						    <div class="tab-content">
						        <div id="overview" class="tab active">
						            <div class="row">
						            	<div class="col-md-8 col-sm-12 col-xs-12">
						            		
						            		<div class="title-hd-sm">
												<h4>Timelines</h4>
											</div>
											<style>
.movie-time {
	display: block;
	font-size: 16px;
	color: #97a5be;
	width: 100px;
	line-height: 43px;
	text-align: center;
	background: #10171e;
	border: 2px solid #121c26;
	margin-right: 12px;
	margin-bottom: 15px;
	text-decoration: none;
}

.li-movie-time {
	display: inline-block;
}

.li-movie-time:hover a {
	color: green;
	cursor: pointer;
}
</style>
											<div class="timeline">
												<ul style="display: block;">
													<c:forEach var="showtimemovie" items="${showtimemovies }">
														<li class="li-movie-time"><a class="movie-time"
																		href="${pageContext.request.contextPath }/ticket/index?movieShowTimeId=${showtimemovie.id}">${showtimemovie.hall.name }<br>${showtimemovie.showDate }<br>${showtimemovie.showTime }</a></li>
													</c:forEach>
												</ul>
											</div>
						
						            	</div>
						            	<div class="col-md-4 col-xs-12 col-sm-12">
						            		<div class="sb-it">
						            			<h6>Status</h6>
						            			<p>
																<c:if test="${movie.nowShowing == true}">
											         <p>Showing
																	<p>
											      
																</c:if>
											     <c:if test="${movie.nowShowing == false}">
											         <p>Stop
																	<p>
											      
																</c:if>
											     </p>
						            		</div>
						            		<div class="sb-it">
						            			<h6>Release Date:</h6>
						            			<p>${movie.startDate }</p>
						            		</div>
						            		<div class="sb-it">
						            			<h6>Run Time:</h6>
						            			<p>${movie.length } min</p>
						            		</div>
						            		<div class="sb-it">
						            			<h6>Keywords:</h6>
						            			<p class="tags">
						            				<span class="time"><a href="#">${movie.shortName }</a></span>
						            			</p>
						            		</div>
						            		<div class="ads">
												<img src="images/uploads/ads1.png" alt="">
											</div>
						            	</div>
						            </div>
						        </div>


						    </div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
</div>
<div>
<div class="page-single">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="blog-detail-ct">
							<!-- comment items -->
					<div class="comments">
						<h4>${movieFeedbackSize} Comments</h4>
						<c:forEach var="movieFeedback" items="${movieFeedbacks }">
							<div class="cmt-item flex-it">
								<img src="images/uploads/author.png" alt="">
								<div class="author-infor">
									<div class="flex-it2">
										<h6>
											<a href="#">${movieFeedback.account.username }&nbsp;&nbsp;&nbsp;</a>
										</h6>
										<h6 class="time">
											&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;${movieFeedback.commentDate }&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
										</h6>
										<br/> 
										<h6>
											<i class="ion-android-star color_star_comment"></i>
											<span class="color_star_comment">${movieFeedback.rating } /5 </span> 
										</h6>
									</div>
									<p>${movieFeedback.content }</p>
								</div>
							</div>
						</c:forEach>
					<div class="comment-form">

						<s:form method="post"  action="${pageContext.request.contextPath }/feedback/save" modelAttribute="feedback">
							<div class="row">
								<div class="col-md-8">
								<h4 >Leave a comment</h4>
								</div>
								<div class="stars col-md-4">

									<s:radiobutton path="starRating" class="star star-1" id="star-1" value="5"/>
									<s:label path="starRating" class="star star-1" for="star-1"/>

									<s:radiobutton path="starRating" class="star star-2" id="star-2" value="4"/>
									<s:label path="starRating" class="star star-2" for="star-2"/>

									<s:radiobutton path="starRating" class="star star-3" id="star-3" value="3"/>
									<s:label path="starRating" class="star star-3" for="star-3"/>
									<s:radiobutton path="starRating" class="star star-4" id="star-4" value="2"/>
									<s:label path="starRating" class="star star-4" for="star-4"/>
									<s:radiobutton path="starRating" class="star star-5" id="star-5" value="1"/>
									<s:label path="starRating" class="star star-5" for="star-5"/>

								</div>
							</div>
							<div class="row">

								<div class="col-md-12">
									<s:textarea path="content" placeholder="Message"/>
																<s:hidden path="movieId" value="${movie.id }" />
								</div>
							</div>

							<input class="submit" type="submit" placeholder="submit">
						</s:form>
					</div>
					<!-- comment form -->
				
		</div>

	</div>
	</div>
	</div>
</div>
	</jsp:attribute>
	</mt:userTemplate>
</body>
