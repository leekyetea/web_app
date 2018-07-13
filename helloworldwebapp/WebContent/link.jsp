<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
</head>
<body>
	<c:choose>
		<c:when test="${not empty cookie.id.value }" >
			<a href="/helloworldwebapp/logout">Logout</a> |
		</c:when>
		<c:otherwise>
			<a href="/helloworldwebapp/index.jsp">Login</a> |
		</c:otherwise>
	</c:choose>

	<a href="/helloworldwebapp/profile">Profile</a>
</body>
</html>