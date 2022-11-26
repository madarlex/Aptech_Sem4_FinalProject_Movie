<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
	<aside id="sidebar-wrapper">
		<div class="sidebar-brand">
			<a href="${pageContext.request.contextPath }/admin/home/index"> <img
				alt="image"
				src="${pageContext.request.contextPath }/resources/admin/img/logo.png"
				class="header-logo" /> <span class="logo-name">Otika</span>
			</a>
		</div>
		<ul class="sidebar-menu">
			<!-- Movie -->
			<li class="menu-header">Movie</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i data-feather="film"></i><span>Movie</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/movie/index">Add</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/movie/movies">Movies</a></li>
				</ul></li>

			<!-- Movie Time line -->
			<li class="menu-header">Schedule</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="clock"></i><span>Schedule</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/schedule/index">Add</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/schedule/schedules">Schedules</a></li>
				</ul></li>

			<!-- Ticket Booking -->
			<li class="menu-header">Ticket Booking</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i data-feather="tag"></i><span>Booking</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/booking/add">Add</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/booking/bookings">Bookings</a></li>
				</ul></li>

			<!-- Hall -->
			<li class="menu-header">Hall</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="monitor"></i><span>Hall</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/hall/add">Add</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/hall/halls">Halls</a></li>
				</ul></li>

			<!-- Accounts -->
			<li class="menu-header">Account</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i data-feather="user"></i><span>Account</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/account/add">Add</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/account/accounts">Accounts</a></li>
				</ul></li>

			<!-- Feedback -->
			<li class="menu-header">Feedback</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="clock"></i><span>Feedback</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/feedback/index">Feedbacks</a></li>
				</ul></li>

			<!-- Price -->
			<li class="menu-header">Price</li>
			<li class="dropdown"><a href="#"
				class="menu-toggle nav-link has-dropdown"><i
					data-feather="clock"></i><span>Price</span></a>
				<ul class="dropdown-menu">
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/price/add">Add</a></li>
					<li><a class="nav-link"
						href="${pageContext.request.contextPath }/admin/price/prices">Prices</a></li>
				</ul></li>

		</ul>
	</aside>

</body>
