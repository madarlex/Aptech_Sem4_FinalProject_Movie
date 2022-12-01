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
			<h4>Movies</h4>
			<div class="card-header-form">
				<form
					action="${pageContext.request.contextPath }/admin/movie/search"
					method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="keyword" placeholder="Search" value="${keyword }">
						<div class="input-group-btn">
							<button class="btn btn-primary" type="submit">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<a href="${pageContext.request.contextPath }/admin/movie/movies" style="margin-left: 10px;"><button class="btn btn-primary">View All</button></a>
		</div>
		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table table-striped table-md">
					<tr>
						<!-- <th>#</th> -->
						<th>Name</th>
						<th>Description</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Is Showing</th>
						<th>Rate</th>
						<th>Hot Movie</th>
						<th>Trailer</th>
						<th>Action</th>
					</tr>
					<c:forEach var="m" items="${movies }" varStatus="i">
						<tr>
							<%-- <td>${i.count }</td> --%>
							<td align="center">${m.name }</td>
							<td align="center">${m.description }</td>
							<td align="center">
								<!-- <div class="badge badge-success">Active</div> --> <fmt:formatDate
									value="${m.startDate }" pattern="dd/MM/yyyy" />
							</td>
							<td align="center">
								<!-- <div class="badge badge-success">Active</div> --> <fmt:formatDate
									value="${m.endDate }" pattern="dd/MM/yyyy" />
							</td>
							<td align="center"><c:choose>
									<c:when test="${m.nowShowing}">
									        Showing
									        <br />
									</c:when>
									<c:otherwise>
									       Not Showing
									</c:otherwise>
								</c:choose></td>
							<td align="center">${m.rate }</td>
							<td align="center"><c:choose>
									<c:when test="${m.hotMovie}">
									        Hot Movie
									        <br />
									</c:when>
									<c:otherwise>
									       Not
									</c:otherwise>
								</c:choose></td>
							<td align="center"><iframe height="200" width="300"
									src="${m.trailer }"> </iframe></td>
							<td align="center"><a
								href="${pageContext.request.contextPath }/admin/movie/edit/${m.id}"
								class="btn btn-primary"> <svg
										xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-edit">
									<path
											d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path>
									<path
											d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path>
									</svg>
							</a> <a
								href="${pageContext.request.contextPath }/admin/movie/delete/${m.id}"
								class="btn btn-primary"> <svg
										xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										viewBox="0 0 24 24" fill="none" stroke="currentColor"
										stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-delete">
										<path d="M21 4H8l-7 8 7 8h13a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2z"></path>
										<line x1="18" y1="9" x2="12" y2="15"></line>
										<line x1="12" y1="9" x2="18" y2="15"></line>
									</svg>
							</a></td>
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
						href="${pageContext.request.contextPath }/admin/movie/movies/${currentPage - 1}"
						tabindex="-1"><i class="fas fa-chevron-left"></i></a></li>

					<%
					for (i = 0; i < totalpage; i += 1) {
					%>
					<%
					if (i + 1 == currentPage) {
					%>
					<li class="page-item active"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/movie/movies/<%= i+1 %>"><%=i + 1%></a></li>
					<%
					} else {
					%>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/movie/movies/<%= i+1 %>"><%=i + 1%></a></li>
					<%
					}
					%>

					<%
					}
					%>

					<!-- <li class="page-item"><a class="page-link" href="#">3</a></li> -->
					<li class="page-item ${nextCheck }"><a class="page-link"
						href="${pageContext.request.contextPath }/admin/movie/movies/${currentPage +1}"><i
							class="fas fa-chevron-right"></i></a></li>
				</ul>
			</nav>
		</div>
	</div>

</body>
<script
	src="${pageContext.request.contextPath }/resources/admin/js/page/advance-table.js"></script>
</html>