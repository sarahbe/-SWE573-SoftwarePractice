<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Register">
<jsp:attribute name="content">
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
	text-align: left;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
<script type="text/javascript"> 

function validateRegistration(form) { 
	var ok = true;

	ok = validateString(this.firstName, 'Please enter you first name','errorFirstName');
	ok = validateString(this.lastName, 'Please enter you last name','errorLastName');
	ok = validateEmail(this.email, 'Please enter valid boun email address');
	ok = validateString(this.password, 'Please enter password','errorPassword');
	return ok;
}

function validateEmail(email, msg) {  
	var re_mail = /^([a-zA-Z0-9_.-])+@boun.edu.tr+$/;  
	if (!re_mail.test(email.value)) {  
	document.getElementById('errorEmail').innerHTML= msg;
	email.focus();  
	email.select();  
	return false;  
	}  
	return true;  
	}
	
function validateString(field, msg, error) {  
	if (!field.value) {  
	 document.getElementById(error).innerHTML=msg;
	field.focus();  
	field.select();  
	return false;  
	}  
	return true;  
	}
</script> 
<center>
		<b>New User </b>
		<div>
			<form:form method="post" name="registrationForm" id="registrationForm" onsubmit="return validateRegistration(this)" action="insert" modelAttribute="user">
				<table>
					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName" id="firstName" /> 
						<td><label id="errorFirstName"></label></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName" id="lastName"/></td>
						<td><label id="errorLastName"></label></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:radiobuttons path="gender" id="gender"
								items="${map.genderList}" /></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><form:input path="email" id="email" name="email"/></td>
						<td><label id="errorEmail"></label></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><form:password path="password" id="password" /></td>
						<td><label id="errorPassword"></label></td>
					</tr>
					<tr>
						<td>Birthdate (only year)</td>
						<td><form:input path="birthYear" /></td>
					</tr>
					<tr>
						<td> </td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>

</jsp:attribute>
</mt:myTemplate>
