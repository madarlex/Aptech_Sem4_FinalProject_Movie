<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib %>
<%@ attribute name="content" fragment="true"%>

<table align="center" width="800">
	<tr>
		<td colspan="2">
			<h3>Welcome ${pageContext.request.userPrincipal.name }</h3> <a
			href="${pageContext.request.contextPath }/account/logout">Logout</a>
		</td>
	</tr>
</table>
