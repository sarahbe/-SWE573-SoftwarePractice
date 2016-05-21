<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<mt:myTemplate title="exception">
<jsp:attribute name="content">
<center><h1> We are sorry, the website was not able to reach database</h1>
<img src="http://static.boredpanda.com/blog/wp-content/uploads/2016/01/We-made-this-cute-animals-fruits-vegetables-into-Puns-to-replace-your-memes28__700.jpg"/>
</center>

<c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		${errMsg}
	</c:if>
</jsp:attribute>
</mt:myTemplate>
