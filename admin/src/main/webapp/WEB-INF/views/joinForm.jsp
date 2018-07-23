<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

<div class="container">
	<h1>Hyundai 직업전문학교</h1>
	<div>
		<h3>회원 가입 </h3>

		<div style="color:red">
			${error }
		</div>
		<form action="${pageContext.request.contextPath }/join" method="post">
			<table class="table">
				<tr>
					<td>ID:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인:</td>
					<td><input type="password" name="pw_confirm"></td>
				</tr>
				<tr>
					<td>생년월일:</td>
					<td><input type="date" name="dob"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>국적:</td>
					<td><select id="coutry" name="country">
							<option value="Korea">한국</option>
							<option value="USA">미국</option>
							<option value="UK">영국</option>
							<option value="Misc">기타</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="제출">
					</td>
				</tr>
			</table>

		</form>
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
