<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>



	<div class="container">
		<h1>Welcome </h1>
		<h2>ID: ${param.id }</h2>
		<h3>PW: ${sessionScope.pw }</h3>
	</div>

<%
session.setAttribute("pw", null);

%>


