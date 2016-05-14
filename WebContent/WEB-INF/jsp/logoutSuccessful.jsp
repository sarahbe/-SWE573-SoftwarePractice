<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<<<<<<< HEAD:WebContent/WEB-INF/jsp/logoutSuccessful.jsp
<mt:myTemplate title="Log out">
<jsp:attribute name="content">
 <h1>Logout Successful!</h1>
=======
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
>>>>>>> eeba2b76125554668dc01bd80888a777a8d5238e:WebContent/WEB-INF/jsp/stock.jsp
</jsp:attribute>
</mt:myTemplate>
