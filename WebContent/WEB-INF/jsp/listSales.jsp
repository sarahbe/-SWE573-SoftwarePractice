<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Sales List">
	<jsp:attribute name="content">
 <table border="1" class="table table-hover table-striped">
   <tr>
    <td class="heading">Sale Id</td>
    <td class="heading">Date</td>
    <td class="heading">Total</td>
    <td class="heading">Seller</td>
    <td class="heading">product</td>
    <td class="heading">quantity</td>
    <td class="heading">unit</td>
</tr>
<c:forEach var="sale" items="${saleList}">
    <tr>
     <td>${sale.id}</td>
     <td>${sale.saleDate}</td>
     <td>${sale.total}</td>
     <td>${sale.idSeller}</td>
     <td>${sale.saleDetail[id].idProduct}</td>
     <td>${sale.saleDetail[id].quantity}</td>
     <td>${sale.saleDetail[id].idUnit}</td>
     </tr>
     </c:forEach>
</table>

</jsp:attribute>
</mt:myTemplate>
