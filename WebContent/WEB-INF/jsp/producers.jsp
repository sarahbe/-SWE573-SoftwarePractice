<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Producers">
<jsp:attribute name="content">
 <c:if test="${pageContext.request.userPrincipal.name != null}">
<a href="newProducer">Add New Producer</a>
</c:if>
<div class="row">
	   <c:forEach var="producer" items="${map.producerList}">
	<div class="col-md-4">
		<div class="row">
		 <a href="viewProducer?id=${producer.id}"
							style="display: block; height: 100%">
			<img alt="${producer.producerName}" width="200px" height="220px"
							src="${producer.image}">
			</a>
		</div>	
		<div class="row">
			<h4>${producer.producerName}</h4>
		</div>	
	</div>
	   </c:forEach>
</div>
</jsp:attribute>
</mt:myTemplate>
