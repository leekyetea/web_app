<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Login Page</title>
</head>
<jsp:include page="link.jsp" flush="false" />
<body>
	<h1>ABC Company</h1>
	<form action='/helloworldwebapp/login' method='post'>
		<div style="color:red">${error}</div>
		ID: <input type='text' name='id' ><br/>
		Password: <input type='password' name='password' ><br/>
		<input type='submit' value='login' />
	</form>
</body>
<script>
	var result = '${param.msg}'
	if (result == 'logout') {
		alert('성공적으로 로그아웃 하셨습니다')
	}
</script>
</html>