<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원등록</h1>
	
	<form action="${pageContext.request.contextPath }/register" method="post">
		${error }
		<table>
			<tr>
				<td>
					이름: 
				</td>
				<td>
					<input type="text" name="name"> 
				</td>
			</tr>
			<tr>
				<td>
					아이디: 
				</td>
				<td>
					<input type="text" name="id"> 
				</td>
			</tr>
			<tr>
				<td>
					생년월일: 
				</td>
				<td>
					<input type="date" name="dob"> 
				</td>
			</tr>
			<tr>
				<td>
					이메일: 
				</td>
				<td>
					<input type="email" name="email"> 
				</td>
			</tr>
			<tr>
				<td colspan="1">
					<input type='submit' value='제출' >
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>