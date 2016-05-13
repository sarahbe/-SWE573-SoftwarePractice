<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Stock page">
<jsp:attribute name="content">
 <a href="unit">Add New Unit</a>
  <table border="1" class="table table-hover table-striped">
   <tr>
    <td class="heading">product Id</td>
    <td class="heading">Product Name</td>
    <td class="heading">Origin</td>
    <td class="heading">Producer Name</td>
    <td class="heading"> Unit</td>
    <td class="heading"> Stock</td>

    

   </tr>
   <c:forEach var="stock" items="${map.stockList}">
    <tr >
     <td>${stock.id}</td>
     <td>${stock.product.productName}</td>
     <td>${stock.product.origin}</td>
     <td>${stock.product.producerName}</td>
      <td> <form:select path="idUnit" cssStyle="width: 150px;">      
       <option value="-1">Select Unit</option>  
       <c:forEach items="${map.unitList}" var="unit">  
        <option value="${unit.id}">${unit.unit}</option>  
       </c:forEach>  
      </form:select>  </td> 
   
   
    </tr>
   </c:forEach>
  </table>
</jsp:attribute>
</mt:myTemplate>
