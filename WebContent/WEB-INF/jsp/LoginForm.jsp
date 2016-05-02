<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Sign in">
<jsp:attribute name="content">
	<div>
		<table>
			<form:form action="login" commandName="userForm">
				<table>
					<tr>
						<td>Email</td>
						<td>
						<form:input path="email" /> 
						<form:errors path="email"></form:errors>
						</td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><form:password path="password" />
						 <form:errors path="password"></form:errors></td>
					</tr>
					<tr>
						<td></td>
						<td align="center"><input type="submit" value="Login" /></td>
						<td></td>
					</tr>
				</table>
			</form:form>
		</table>
	</div>
</jsp:attribute>
</mt:myTemplate>
