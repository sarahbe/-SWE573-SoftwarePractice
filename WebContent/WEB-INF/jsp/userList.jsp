<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Home page">
<jsp:attribute name="content">
<style>
.onoffswitch {
    position: relative; width: 90px;
    -webkit-user-select:none; -moz-user-select:none; -ms-user-select: none;
}
.onoffswitch-checkbox {
    display: none;
}
.onoffswitch-label {
    display: block; overflow: hidden; cursor: pointer;
    border: 2px solid #999999; border-radius: 20px;
}
.onoffswitch-inner {
    display: block; width: 200%; margin-left: -100%;
    transition: margin 0.3s ease-in 0s;
}
.onoffswitch-inner:before, .onoffswitch-inner:after {
    display: block; float: left; width: 50%; height: 30px; padding: 0; line-height: 30px;
    font-size: 14px; color: white; font-family: Trebuchet, Arial, sans-serif; font-weight: bold;
    box-sizing: border-box;
}
.onoffswitch-inner:before {
    content: "YES";
    padding-left: 10px;
    background-color: #34A7C1; color: #FFFFFF;
}
.onoffswitch-inner:after {
    content: "NO";
    padding-right: 10px;
    background-color: #EEEEEE; color: #999999;
    text-align: right;
}
.onoffswitch-switch {
    display: block; width: 18px; margin: 6px;
    background: #FFFFFF;
    position: absolute; top: 0; bottom: 0;
    right: 56px;
    border: 2px solid #999999; border-radius: 20px;
    transition: all 0.3s ease-in 0s; 
}
.onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-inner {
    margin-left: 0;
}
.onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-switch {
    right: 0px; 
}
</style>
<script>
function setCheckbox(iduser) { 
	alert(iduser)
}

function post(path, params, method) {
    method = method || "post"; 
    // Set method to post by default if not specified.

    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);

    for(var key in params) {
        if(params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
         }
    }

    document.body.appendChild(form);
    form.submit();
}
</script>
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
        <td class="heading">Member</td>
        <td class="heading">Saler</td>
        <td class="heading">Stocker</td>
              <td class="heading">Admin</td>
   </tr>
   <c:forEach var="user" items="${userList}">
    <tr >
     <td>${user.userId}</td>
     <td>${user.firstName}</td>
     <td>${user.lastName}</td>
     <td>${user.gender}</td>
     <td>${user.email}</td>
     
     <td><a href="edit?id=${user.userId}">Edit</a></td>
   
     <td>
     <div class="onoffswitch">
    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="approve${user.userId}" onclick="post('approve?id=${user.userId}',{active : this.checked });" 
    <c:if test="${user.memberActive == true}" >checked="checked"</c:if>>
    <label class="onoffswitch-label" for="approve${user.userId}">
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div>
</td>
 <td>
     <div class="onoffswitch">
    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="sale${user.userId}" 
     onclick="post('seller?id=${user.userId}',{active : this.checked });" 
    <c:if test="${user.salerActive == true}" >checked="checked"</c:if>>
    <label class="onoffswitch-label" for="sale${user.userId}" >
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div>
</td>
 <td>
     <div class="onoffswitch">
    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox"  id="stock${user.userId}" onclick="post('stocker?id=${user.userId}',{active : this.checked });" 
    <c:if test="${user.stockerActive == true}" >checked="checked"</c:if>>
    <label class="onoffswitch-label" for="stock${user.userId}">
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div>
</td>
 <td>
     <div class="onoffswitch">
    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="admin${user.userId}" onclick="post('admin?id=${user.userId}',{active : this.checked });" 
    <c:if test="${user.adminActive == true}" >checked="checked"</c:if>>
    <label class="onoffswitch-label" for="admin${user.userId}">
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div>
</td>
    </tr>
   </c:forEach>
  </table>
 </center>
</jsp:attribute>
</mt:myTemplate>
