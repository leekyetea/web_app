<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Welcome!!!</title>
</head>
<jsp:include page="/link.jsp" flush="false" />
<body>
	<h2>ABC Company</h2>
	<h3>Hello ${user }</h3>
	<a href="/helloworldwebapp/profile" >Profile</a>
</body>
</html>