<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="New Product">
	<jsp:attribute name="content">
<div>
 <form:form method="POST" action="insert">  
      <table>  
       <tr>  
           <td><form:label path="productName">Product Name:</form:label></td>  
           <td><form:input path="productName" /></td>  
       </tr>  
       <tr>  
           <td><form:label path="categoryName">Category Name:</form:label></td>  
           <td><form:input path="categoryName" /></td>  
       </tr>  
       <tr>  
           <td><form:label path="description">Description</form:label></td>  
           <td><form:input path="description" /></td>  
       </tr>  
       <tr>  
           <td><form:label path="producer">Producer:</form:label></td>  
           <td><form:input path="producer" /></td>  
       </tr>  
       <tr>  
           <td><form:label path="origin">Origin:</form:label></td>  
           <td><form:input path="origin" /></td>  
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
