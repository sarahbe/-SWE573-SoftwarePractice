<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="New Product">
	<jsp:attribute name="content">
<div>
 <form:form method="POST" action="insertProduct" enctype="multipart/form-data"  modelAttribute="product" >  
      <table>  
       <tr>  
           <td><form:label path="productName">Product Name:</form:label></td>  
           <td><form:input path="productName" /></td>  
       </tr>  
       <tr>  
           <td><form:label path="idCategory">Category Name:</form:label></td>  
           <td> <form:select path="idCategory"
								cssStyle="width: 150px;">      
       <option value="-1">Select Category</option>  
       <c:forEach items="${map.categories}" var="category">  
        <option value="${category.id}">${category.category}</option>  
       </c:forEach>  
      </form:select>  </td>  <td colspan="2"><a href="category">Add New Category</a></td>
       </tr>  
       <tr>  
           <td><form:label path="description">Description</form:label></td>  
           <td><form:input path="description" /></td>  
       </tr>   
          <tr>  
           <td><form:label path="idProducer">Producer Name:</form:label></td>  
           <td> <form:select path="idProducer"
								cssStyle="width: 150px;">      
       <option value="-1">Select Producer</option>  
       <c:forEach items="${map.producers}" var="producer">  
        <option value="${producer.id}">${producer.producerName}</option>  
       </c:forEach>  
      </form:select>  </td> 
       </tr>  
       <tr>  
           <td><form:label path="origin">Origin:</form:label></td>  
           <td><form:input path="origin" /></td>  
       </tr> 
       <tr>
       <td>
         <input type="file" name="file"/> 
       </td>
       </tr>
	   <tr>  
           <td>&nbsp;</td>  
           <td><input type="submit" value="SAVE" /></td>  
       </tr>  
   </table>   
  </form:form>  
  </div>
</jsp:attribute>
</mt:myTemplate>
