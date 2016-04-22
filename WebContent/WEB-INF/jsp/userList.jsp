<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Home page">
<jsp:attribute name="content">


 <center>
 <b>User
   List </b>
  <table border="1" class="table table-hover table-striped">
   <tr>
    <td class="heading">User Id</td>
    <td class="heading">First Name</td>
    <td class="heading">Last Name</td>
    <td class="heading">Gender</td>
    <td class="heading">Email</td>
    <td class="heading">Edit</td>
    <td class="heading">Delete</td>
        <td class="heading">Approve</td>
   </tr>
   <c:forEach var="user" items="${userList}">
    <tr >
     <td>${user.userId}</td>
     <td>${user.firstName}</td>
     <td>${user.lastName}</td>
     <td>${user.gender}</td>
     <td>${user.email}</td>
     <td><a href="edit?id=${user.userId}">Edit</a></td>
     <td><a href="delete?id=${user.userId}">Delete</a></td>
     <td><a href="approve?id=${user.userId}">Approve</a></td>
    </tr>
   </c:forEach>
  </table>

 </center>
</jsp:attribute>
</mt:myTemplate>
