<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Category">
<jsp:attribute name="content">

 <form:form method="POST" action="insertCategory" modelAttribute="category">  
      <table>  
       <tr>  
           <td><form:label path="category">Category Name:</form:label></td>  
           <td><form:input path="category" /></td>  
       </tr>  
         
       <tr>  
       <tr>  
        <td>&nbsp;</td>  
         <td><input type="submit" value="SAVE"/></td>  
         </tr>  
   </table>   
  </form:form>  
</jsp:attribute>
</mt:myTemplate>
