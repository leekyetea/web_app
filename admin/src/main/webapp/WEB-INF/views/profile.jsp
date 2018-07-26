<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<div class="container">
		<h1>Hyundai 직업전문학교</h1>
		<div>
			<h3>
				${user.name } Profile
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
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>

<script>
	if ('${param.msg}' == 'success') {
		alert("지원서 제출 성공");
	}
</script>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
