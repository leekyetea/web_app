<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<div class="container">
		<h1>Hyundai 직업전문학교</h1>
		<div>
			<h3>
				${user.name }
			</h3>
			<table class="table">
				<tr>
					<th>생년월일</th>
					<th>이메일</th>
					<th>국적</th>
				</tr>
				<tr>
					<td>${user.dob }</td>
					<td>${user.email }</td>
					<td>${user.country }</td>
				</tr>
			</table>
			<h3>
				지원현황
			</h3>
			<table class="table">
				<tr>
					<th>Major</th>
					<th>Semeter</th>
					<th>Description</th>
				</tr>
				<c:forEach items="${applys }" var="application">
					<tr>
					
						<td>${application.major }</td>
						<td>${application.semester } </td>
						<td>${application.applyDesc } </td>
						<td>
							<button>Delete</button>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>

<script>
	if ('${param.msg}' == 'success') {
		alert("지원서 제출 성공");
	}
	
	if ('${del_msg}' == 'success') {
		alert("지원서 삭제 성공");
	} else if ('${del_msg}' == 'failure'){
		alert("지원서를 삭제하는데 문제가 발생하였습니다");
	}
</script>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
