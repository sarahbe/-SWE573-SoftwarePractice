<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Producers">
<jsp:attribute name="content">
<form:form method="get" modelAttribute="producer">

<table>
<tr>
<td>
<table>
<tr>
<td>
	<img alt="${producer.producerName}" width="200px" height="220px"
									src="${map.producer.image}">

</td>

</tr>
</table>
</td>

<td>
<table>
<tr>
								<td>
<h4>Producer   </h4>
								</td>
								<td>
<c:out value="${map.producer.producerName}" />
</td>
							</tr>
							<tr>
								<td>
<h4>Origin   </h4>
								</td>
								
								
								<td>
<c:out value="${map.producer.origin}" />
</td>
							</tr>
<tr>
								<td>
<h4>Description   </h4>
								</td>
								
								
								<td>
<c:out value="${map.producer.description}" />
</td>
							</tr>
						</table>
					</td>
</tr>
</table>
</form:form>

</jsp:attribute>
</mt:myTemplate>
