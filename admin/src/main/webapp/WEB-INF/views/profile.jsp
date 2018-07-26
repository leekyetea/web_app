<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<div class="container">
		<h1>Hyundai 직업전문학교</h1>
		<div>
			<h3>
				${user.name } Profile
				
			</h3>
			
		</div>
	</div>

<script>
	if ('${param.msg}' == 'success') {
		alert("지원서 제출 성공");
	}
</script>
<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
