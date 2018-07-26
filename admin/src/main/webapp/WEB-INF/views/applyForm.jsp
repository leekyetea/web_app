<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

<div class="container">
	<h1>Hyundai 직업전문학교</h1>
	<div>
		<h3>${user.name } 지원서 작성</h3>

		<div style="color:red">
			${error }
		</div>
		<form action="${pageContext.request.contextPath }/apply" method="post">
			<table class="table">
				<tr>
					<td>전공:</td>
					<td><input type="text" name="major"></td>
				</tr>
				<tr>
					<td>지원학기: </td>
					<td>
						<select id="sem" name="semester">
							<option value="spring">봄학기</option>
							<option value="fall">가을학기</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>지원동기</td>
					<td>
						<textarea rows="3" cols="30" autofocus name="applyDesc">						
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<input type='submit' value="제출">
					</td>
				</tr>
			</table>

		</form>
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
