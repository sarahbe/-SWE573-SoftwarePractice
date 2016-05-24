<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Products">
	<jsp:attribute name="content">
<form:form method="get" modelAttribute="product">

<table>
	<tr>
		<td>
			<table>
				<tr>
					<td>
					<img alt="${product.producerName}" width="200px" height="220px"
									src="${map.product.image}">
					</td>
				</tr>
			</table>
		</td>
		<td>
			<table>
				<tr>
					<td>
					<h4>&nbsp;&nbsp;Producer  &nbsp;&nbsp; </h4>
					</td>
					<td>
						<c:out value="${map.product.producerName}" />
					</td>
				</tr>
				<tr>
					<td>
					<h4>&nbsp;&nbsp;Origin &nbsp;&nbsp;  </h4>
					</td>
					<td>
					<c:out value="${map.product.origin}" />
					</td>
				</tr>
				<tr>
					<td>
					<h4>&nbsp;&nbsp;Description  &nbsp;&nbsp; </h4>
				</td>
				<td>
				<c:out value="${map.product.description}" />
				</td>
			</tr>
			<tr>
				<td>
				<h4>&nbsp;&nbsp;Price &nbsp;&nbsp;  </h4>
				</td>
				<td>
				<c:out value="${map.product.price}" /> TL
				</td>
			</tr>
			</table>
		</td>
	</tr>
</table>

<h3> Comments and rating to be added in version 2 </h3>
</form:form>

</jsp:attribute>
</mt:myTemplate>
