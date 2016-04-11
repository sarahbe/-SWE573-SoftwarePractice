<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>My FoodCoop - Edit</title>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: center;
}

.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
 <center>
 <b>Edit User Details </b>
 

  <div>
   <form:form method="post" action="update" modelAttribute="user">
    <table>
     <tr>
      <td>First Name :</td>
      <td><form:input path="firstName"
        value="${map.user.firstName}" />
      </td>
     </tr>
     <tr>
      <td>Last Name :</td>
      <td><form:input path="lastName" value="${map.user.lastName}" />
      </td>
     </tr>
     <tr>
      <td>Gender :</td>
      <td><spring:bind path="gender">
        <c:forEach items='${map.genderList}' var='genderName'>
         <c:choose>
          <c:when test="${genderName eq map.user.gender}">
           <input type="radio" name="gender" value="${genderName}"
            checked="checked">${genderName}
          </c:when>
          <c:otherwise>
           <input type="radio" name="gender" value="${genderName}">${genderName}
          </c:otherwise>
         </c:choose>
        </c:forEach>
       </spring:bind>
      </td>
     </tr>
     <tr>
   <td>Email :</td>
      <td><form:input path="email"
        value="${map.user.email}" />
      </td>

     </tr>
          <tr>
   <td>Password :</td>
      <td><form:input path="password"
        value="${map.user.password}" />
      </td>

     </tr>
     <tr>
      <td> </td>
      <td><input type="submit" value="Save" />
      </td>
     </tr>
    </table>
    <form:hidden path="userId" value="${map.user.userId}" />

   </form:form>
  </div>
 </center>
</body>
</html>
