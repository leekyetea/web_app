<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<a href="/" class="navbar-brand">Brand</a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${pageContext.request.contextPath }/">Home</a></li>
			<li><a href="${pageContext.request.contextPath }/apply">Apply</a></li>
			<li><a href="${pageContext.request.contextPath }/profile">Profile</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty user }">
					<li><a href="${pageContext.request.contextPath }/login">Login</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath }/logout">Logout</a>
					</li>
				</c:otherwise>
			</c:choose>

		</ul>
	</nav>



