<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${msg }
<body>

	<div class="card">
		<div class="card-header">
			<h4>Schedules</h4>
			<div class="card-header-form">
				<div class="row">
					<form
						action="${pageContext.request.contextPath }/admin/schedule/searchmovie"
						method="post">
						<div class="input-group">
							<input type="text" class="form-control" name="keyword"
								placeholder="Search" value="${keyword }">
							<div class="input-group-btn">
								<button class="btn btn-primary" type="submit">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
					</form>
					<form
						action="${pageContext.request.contextPath }/admin/schedule/searchdate"
						method="post" style="margin-left: 10px;">
						<div class="input-group">
							<input type="date" class="form-control daterange-cus" name="date"
								value="${date }">
							<div class="input-group-btn">
								<button class="btn btn-primary" type="submit">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</div>
					</form>
					<a href="${pageContext.request.contextPath }/admin/schedule/schedules"
						style="margin-left: 10px;"><button class="btn btn-primary">View
							All</button></a>
				</div>
			</div>

		</div>
		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table table-striped table-md">
					<tr>
						<!-- <th>#</th> -->
						<th>Movie</th>
						<th>Hall</th>
						<th>Show Date</th>
						<th>Show Time</th>
						<th>End Time</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					<c:forEach var="s" items="${schedules}" varStatus="i">
						<tr>
							<%-- <td>${i.count }</td> --%>
							<td>${s.movie.name }</td>
							<td>${s.hall.name }</td>
							<td>
								<!-- <div class="badge badge-success">Active</div> --> <fmt:formatDate
									value="${s.showDate }" pattern="dd/MM/yyyy" />
							</td>
							<td>
								<!-- <div class="badge badge-success">Active</div> --> <fmt:formatDate
									value="${s.showTime }" pattern="HH:mm" />
							</td>
							<td>
								<!-- <div class="badge badge-success">Active</div> --> <fmt:formatDate
									value="${s.endTime }" pattern="HH:mm" />
							</td>
							<td>${s.status == true ? "Activated" : "Inactive" }</td>
							<td><a
								href="${pageContext.request.contextPath }/admin/schedule/edit/${s.id}"
								class="btn btn-primary">Edit</a> <a
								href="${pageContext.request.contextPath }/admin/schedule/delete/${s.id}"
								class="btn btn-primary">Delete</a></td>
						</tr>
					</c:forEach>


				</table>
			</div>
		</div>
		<jsp:useBean id="totalpage" type="java.lang.Integer" scope="session" />
		<jsp:useBean id="currentPage" type="java.lang.Integer" scope="session" />
		<%!int i;%>
		<div class="card-footer text-right">
			<nav class="d-inline-block">
				<ul class="pagination mb-0">
					<li class="page-item ${preCheck }"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/schedule/schedules/${currentPage - 1}"
						tabindex="-1"><i class="fas fa-chevron-left"></i></a></li>

					<%
					for (i = 0; i < totalpage; i += 1) {
					%>
					<%
					if (i + 1 == currentPage) {
					%>
					<li class="page-item active"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/schedule/schedules/<%= i+1 %>"><%=i + 1%></a></li>
					<%
					} else {
					%>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/schedule/schedules/<%= i+1 %>"><%=i + 1%></a></li>
					<%
					}
					%>

					<%
					}
					%>

					<!-- <li class="page-item"><a class="page-link" href="#">3</a></li> -->
					<li class="page-item ${nextCheck }"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/schedule/schedules/${currentPage +1}"><i
							class="fas fa-chevron-right"></i></a></li>
				</ul>
			</nav>
		</div>
	</div>

</body>
<script
	src="${pageContext.request.contextPath }/resources/admin/js/page/advance-table.js"></script>
</html>