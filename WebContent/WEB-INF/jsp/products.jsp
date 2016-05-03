<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Products">
	<jsp:attribute name="content">
 
 <td colspan="2"><a href="newProduct">Add New Product</a></td>
<div class="row">
	   <c:forEach var="product" items="${map.productList}">
	<div class="col-md-4">
		<div class="row">
		 <a href="viewProduct?id=${product.id}"
							style="display: block; height: 100%">
			<img alt="${product.productName}" width="200px" height="220px"
							src="${product.image}">
			</a>
		</div>	
		<div class="row">
			<h4>${product.productName}</h4>
			<h4><small>${product.producerName} -  ${product.origin}</small></h4>
		</div>	
	</div>
	   </c:forEach>
</div>
</jsp:attribute>
</mt:myTemplate>
