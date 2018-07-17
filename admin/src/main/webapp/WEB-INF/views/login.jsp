<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

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
			<li class="active"><a href="###">Home</a></li>
			<li><a href="###">Apply</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="${pageContext.request.contextPath }/login">Login</a>
			</li>
		</ul>
	</nav>

	<div class="container">
		<h1>Hyundai 직업전문학교</h1>
		<form action='${pageContext.request.contextPath }/login' method='post'>
			<input type="hidden" name="orgReqPath" value="${orgReqPath }" />
			<div style="color: red">${error}</div>
			ID: <input type='text' name='id'><br /> Password: <input
				type='password' name='pw'><br /> <input type='submit'
				value='login' />
		</form>
	</div>

	<footer class="footer">
		<div>서울현대 직업전문학교 ...</div>
	</footer>
</body>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>
