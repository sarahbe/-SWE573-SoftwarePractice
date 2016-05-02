<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Unit page">
<jsp:attribute name="content">
<form:form method="POST" action="insertUnit" modelAttribute="unit">  
      <table>  
       <tr>  
           <td><form:label path="unit">Unit:</form:label></td>  
           <td><form:input path="unit" /></td>  
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
