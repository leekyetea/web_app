<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

	<div class="container">
		<h1>Hyundai 직업전문학교</h1>

		<c:choose>
			<c:when test="${empty user }">
				<h3>환영합니다, 손님
				</h3>
			</c:when>
			<c:otherwise> 
				<h3>${user.name }님, 환영합니다</h3>
			</c:otherwise>
		</c:choose>
		
		<ul>
			<li>지원자는 로그인 후, 지원서 작성</li>
			<li>지원 정보 확인은 프로파일</li>
		</ul>
		
	</div>

<jsp:include page="/WEB-INF/views/footer.jsp" flush="false" />
