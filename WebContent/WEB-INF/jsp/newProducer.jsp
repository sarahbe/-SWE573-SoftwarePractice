<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="New Producer">
	<jsp:attribute name="content">
<div>
 <form:form method="POST" action="insertProducer" modelAttribute="producer" enctype="multipart/form-data" >  
      <table>  
       <tr>  
           <td><form:label path="producerName">Producer Name:</form:label></td>  
           <td><form:input path="producerName" /></td>  
       </tr>  
     
       <tr>  
           <td><form:label path="description">Description</form:label></td>  
           <td><form:input path="description" /></td>  
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
