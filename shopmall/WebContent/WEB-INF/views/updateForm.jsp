<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<h1>회원정보수정</h1>

	<c:choose>
		<c:when test="${not empty member }">
			<form action="${pageContext.request.contextPath }/updateMember"
				method="post">
				<div class="error">${error }</div>

				<table>
					<tr>
						<td>이름:</td>
						<td><input type="text" name="name" value="${member.name }">
						</td>
					</tr>
					<tr>
						<td>아이디:</td>
						<td><input type="text" name="id" value="${member.id }" readonly></td>
					</tr>
					<tr>
						<td>생년월일:</td>
						<td><input type="date" name="dob" value="${member.dob }"></td>
					</tr>
					<tr>
						<td>이메일:</td>
						<td><input type="email" name="email" value="${member.email }"></td>
					</tr>
					<tr>
						<td colspan="1"><input type='submit' value='제출'></td>
					</tr>
				</table>

			</form>

		</c:when>
		<c:otherwise>
			<div class="error">주어진 아이디가 잘못된 정보입니다.</div>
		</c:otherwise>
	</c:choose>


</body>
<script>
	
</script>
</html>