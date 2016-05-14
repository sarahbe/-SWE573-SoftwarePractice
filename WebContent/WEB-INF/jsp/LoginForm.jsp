<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="Sign in">
	<jsp:attribute name="content">
		<h3>	Welcome : ${pageContext.request.userPrincipal.name}</h3>
	<div id="login-error"> ${error} </div>
	<div>
	<c:url var="loginUrl" value="j_spring_security_check" />
			<form method="post" action="${loginUrl}">
<p>			
				<label for="email">Username</label>
<input id="email" name="email" type="text" />
</p>
<p>
<label for="password">Password</label>
<input id="password" name="password" type="password" />
</p>
				<input type="submit" value="Login" /> 
			</form>
	</div>
</jsp:attribute>
</mt:myTemplate>
