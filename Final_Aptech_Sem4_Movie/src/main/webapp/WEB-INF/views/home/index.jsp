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
	
	
	<div class="slider movie-items">
		<div class="container">
			<div class="row">
				<div class="social-link">
					<p>Follow us: </p>
					<a href="#"><i class="ion-social-facebook"></i></a>
					<a href="#"><i class="ion-social-twitter"></i></a>
					<a href="#"><i class="ion-social-googleplus"></i></a>
					<a href="#"><i class="ion-social-youtube"></i></a>
				</div>
				<div class="slick-multiItemSlider">
					<c:forEach var="movie" items="${movies }"  varStatus="i">
							<div class="movie-item">
							<div class="mv-img">
								<a href="${pageContext.request.contextPath }/movie/detail/${movie.id}"><img  src="${pageContext.request.contextPath }${movie.picture }" alt="" width="285" height="437"></a>
							</div>
							<div class="title-in">
								<h6><a href="${pageContext.request.contextPath }/movie/detail/${movie.id}">${movie.name}</a></h6>
								<p><i class="ion-android-star"></i><span>${movie.rate }</span> /10</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="movie-items">
		<div class="container">
			<div class="row ipad-width">
				<div class="col-md-12">
					<div class="title-hd">
						<h2>in theater</h2>
					</div>
					<div class="tabs">
						<ul class="tab-links">
							<li class="active"><a href="#tab1">#Hot</a></li>
							<li><a href="#tab2"> #Coming soon</a></li>
							<li><a href="#tab3"> #Top rated </a></li>
						</ul>
						<div class="tab-content">
							<div id="tab1" class="tab active">
								<div class="row">
									<div class="slick-multiItem">
									<c:forEach var="movie" items="${hotMovies }"  varStatus="i">
										<div class="slide-it">
											<div class="movie-item">
												<div class="mv-img">
													<img  src="${pageContext.request.contextPath }${movie.picture}" alt="" width="185"
														height="284">
												</div>
												<div class="hvr-inner">
													<a href="${pageContext.request.contextPath }/movie/detail/${movie.id}"> Read more <i
															class="ion-android-arrow-dropright"></i> </a>
												</div>
												<div class="title-in">
													<h6><a href="${pageContext.request.contextPath }/movie/detail/${movie.id}">${movie.name }</a></h6>
													<p><i class="ion-android-star"></i><span>${movie.rate }</span> /10</p>
												</div>
											</div>
										</div>
									</c:forEach>
									</div>
								</div>
							</div>
							<div id="tab2" class="tab">
								<div class="row">
									<div class="slick-multiItem">
										<c:forEach var="movie" items="${commingSoonMovies }"  varStatus="i">
										<div class="slide-it">
											<div class="movie-item">
												<div class="mv-img">
													<img  src="${pageContext.request.contextPath }${movie.picture}" alt="" width="185"
														height="284">
												</div>
												<div class="hvr-inner">
													<a href="${pageContext.request.contextPath }/movie/detail/${movie.id}"> Read more <i
															class="ion-android-arrow-dropright"></i> </a>
												</div>
												<div class="title-in">
													<h6><a href="${pageContext.request.contextPath }/movie/detail/${movie.id}">${movie.name }</a></h6>
													<p><i class="ion-android-star"></i><span>${movie.rate }</span> /10</p>
												</div>
											</div>
										</div>
									</c:forEach>
									</div>
								</div>
							</div>
							<div id="tab3" class="tab">
								<div class="row">
									<div class="slick-multiItem">
									<c:forEach var="movie" items="${movieOrderByRate }"  varStatus="i">
										<div class="slide-it">
											<div class="movie-item">
												<div class="mv-img">
													<img  src="${pageContext.request.contextPath }${movie.picture}" alt="" width="185"
														height="284">
												</div>
												<div class="hvr-inner">
													<a href="${pageContext.request.contextPath }/movie/detail/${movie.id}"> Read more <i
															class="ion-android-arrow-dropright"></i> </a>
												</div>
												<div class="title-in">
													<h6><a href="${pageContext.request.contextPath }/movie/detail/${movie.id}">${movie.name }</a></h6>
													<p><i class="ion-android-star"></i><span>${movie.rate }</span> /10</p>
												</div>
											</div>
										</div>
									</c:forEach>
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
</div>
		</div>
	</div>

	<div class="trailers">
		<div class="container">
			<div class="row ipad-width">
				<div class="col-md-12">
					<div class="title-hd">
						<h2>trailers</h2>
					</div>
					<div class="videos">
						<div class="slider-for-2 video-ft">
						<c:forEach var="movie" items="${hotMovies }"  varStatus="i">
							<div>
								<iframe class="item-video" src="#"
									data-src="${movie.trailer }"></iframe>
							</div>
									</c:forEach>



						</div>
						<div class="slider-nav-2 thumb-ft">
						<c:forEach var="movie" items="${hotMovies }"  varStatus="i">
						<div class="item">
								<div class="trailer-img">
									<img  src="${pageContext.request.contextPath }${movie.picture}" alt="photo by Barn Images" width="4096"
										height="2737">
								</div>
								<div class="trailer-infor">
									<h4 class="desc">${movie.name}</h4>
									<p>${movie.length }p</p>
								</div>
							</div>
						</c:forEach>

							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- latest new v1 section-->
	<div class="latestnew">
		<div class="container">
			<div class="row ipad-width">
				<div class="col-md-12">
					<div class="title-hd">
						<h2>Latest news</h2>
					</div>
					<div class="tabs">
						<ul class="tab-links-3">
							<li class="active"><a href="#tab31">#Movies </a></li>
							<li><a href="#tab32"> #TV Shows </a></li>
							<li><a href="#tab33"> # Celebs</a></li>
						</ul>
						<div class="tab-content">
							<div id="tab31" class="tab active">
								<div class="row">
									<div class="blog-item-style-1">
										<img  src="${pageContext.request.contextPath }/resources/user/images/uploads/blog-it1.jpg" alt="" width="170" height="250">
										<div class="blog-it-infor">
											<h3><a href="#">Brie Larson to play first female white house candidate
													Victoria Woodull in Amazon film</a></h3>
											<span class="time">13 hours ago</span>
											<p>Exclusive: <span>Amazon Studios </span>has acquired Victoria Woodhull,
												with Oscar winning Room star <span>Brie Larson</span> polsed to produce,
												and play the first female candidate for the presidency of the United
												States. Amazon bought it in a pitch package deal. <span> Ben
													Kopit</span>, who wrote the Warner Bros film <span>Libertine</span>
												that has...</p>
										</div>
									</div>
								</div>
							</div>
							<div id="tab32" class="tab">
								<div class="row">
									<div class="blog-item-style-1">
										<img  src="${pageContext.request.contextPath }/resources/user/images/uploads/blog-it2.jpg" alt="" width="170" height="250">
										<div class="blog-it-infor">
											<h3><a href="#">Tab 2</a></h3>
											<span class="time">13 hours ago</span>
											<p>Exclusive: <span>Amazon Studios </span>has acquired Victoria Woodhull,
												with Oscar winning Room star <span>Brie Larson</span> polsed to produce,
												and play the first female candidate for the presidency of the United
												States. Amazon bought it in a pitch package deal. <span> Ben
													Kopit</span>, who wrote the Warner Bros film <span>Libertine</span>
												that has...</p>
										</div>
									</div>
								</div>
							</div>
							<div id="tab33" class="tab">
								<div class="row">
									<div class="blog-item-style-1">
										<img  src="${pageContext.request.contextPath }/resources/user/images/uploads/blog-it1.jpg" alt="" width="170" height="250">
										<div class="blog-it-infor">
											<h3><a href="#">Tab 3</a></h3>
											<span class="time">13 hours ago</span>
											<p>Exclusive: <span>Amazon Studios </span>has acquired Victoria Woodhull,
												with Oscar winning Room star <span>Brie Larson</span> polsed to produce,
												and play the first female candidate for the presidency of the United
												States. Amazon bought it in a pitch package deal. <span> Ben
													Kopit</span>, who wrote the Warner Bros film <span>Libertine</span>
												that has...</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="morenew">
						<div class="title-hd">
							<h3>More news on Blockbuster</h3>
							<a href="#" class="viewall">See all Movies news<i class="ion-ios-arrow-right"></i></a>
						</div>
						<div class="more-items">
							<div class="left">
								<div class="more-it">
									<h6><a href="#">Michael Shannon Frontrunner to play Cable in “Deadpool 2”</a></h6>
									<span class="time">13 hours ago</span>
								</div>
								<div class="more-it">
									<h6><a href="#">French cannibal horror “Raw” inspires L.A. theater to hand out “Barf
											Bags”</a></h6>

									<span class="time">13 hours ago</span>
								</div>
							</div>
							<div class="right">
								<div class="more-it">
									<h6><a href="#">Laura Dern in talks to join Justin Kelly’s biopic “JT Leroy”</a>
									</h6>
									<span class="time">13 hours ago</span>
								</div>
								<div class="more-it">
									<h6><a href="#">China punishes more than 300 cinemas for box office cheating</a>
									</h6>
									<span class="time">13 hours ago</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
		</div>
	</div>
	<!--end of latest new v1 section-->
	
	</jsp:attribute>
</mt:userTemplate>
</body>
</html>