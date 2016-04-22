<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>