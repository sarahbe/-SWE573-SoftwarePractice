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
			<img alt="something"
			src="http://images.hepsiburada.net/assets/Mobilya/200/Mobilya_4344442.jpg">
		</div>	
		<div class="row">
			<h4 class="text-center">"${product.producerName}"</h4>
			<h4><small>"${product.origin}"</small></h4>
		</div>	
	</div>
	   </c:forEach>
</div>
</jsp:attribute>
</mt:myTemplate>
