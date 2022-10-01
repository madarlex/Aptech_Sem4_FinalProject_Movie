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
			<h4>Accounts</h4>
		</div>
		<div class="card-body p-0">
			<div class="table-responsive">
				<table class="table table-striped table-md">
					<tr>
						<!-- <th>#</th> -->
						<th>User Name</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Action</th>
					</tr>
					<c:forEach var="a" items="${accounts }" varStatus="i" >
						<tr>
							<%-- <td>${i.count }</td> --%>
							<td>${a.username }</td>
							<td>${a.fullName }</td>
							<td>
								${a.email }
							</td>
							<td>
								${a.phone }
							</td>
							<td>
								<a href="#" class="btn btn-primary">Detail</a>
								<a href="${pageContext.request.contextPath }/admin/account/edit/${a.id}" class="btn btn-primary">Edit</a>
								<a href="${pageContext.request.contextPath }/admin/account/delete/${a.id}" class="btn btn-primary">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<jsp:useBean id="totalpage" type="java.lang.Integer" scope="session" />
		<jsp:useBean id="currentPage" type="java.lang.Integer" scope="session" />
		<%! int i; %>
		<div class="card-footer text-right">
			<nav class="d-inline-block">
				<ul class="pagination mb-0">
					<li class="page-item ${preCheck }"><a class="page-link" href="${pageContext.request.contextPath }/admin/account/accounts/${currentPage - 1}"
						tabindex="-1"><i class="fas fa-chevron-left"></i></a></li>

					<%	for(i = 0; i<totalpage;i+=1) { %>
						<% if(i+1 == currentPage) { %>
							<li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath }/admin/account/accounts/<%= i+1 %>"><%= i+1 %></a></li>
						<%}else { %>
							<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath }/admin/account/accounts/<%= i+1 %>"><%= i+1 %></a></li>
						<%} %>
						
					<% } %>
					
					<!-- <li class="page-item"><a class="page-link" href="#">3</a></li> -->
					<li class="page-item ${nextCheck }"><a class="page-link" href="${pageContext.request.contextPath }/admin/account/accounts/${currentPage +1}"><i
							class="fas fa-chevron-right"></i></a></li>
				</ul>
			</nav>
		</div>
	</div>
	
	</div>
</body>
<script src="${pageContext.request.contextPath }/resources/admin/js/page/advance-table.js"></script>
</html>