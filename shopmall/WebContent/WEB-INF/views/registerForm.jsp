<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.error {
		font-color: red	
	}
</style>
</head>
<body>
	<h1>회원등록</h1>
	
	<form action="${pageContext.request.contextPath }/register" name="registerForm" method="post">
		<div class="error">${error }</div>
		
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
					<input type="text" name="id" onkeydown="idChanged()"> 
					<button type="button" onclick="idCheck()">중복체크</button>
					<div id="checkResult"></div>
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
					<button type='button' onclick="submitForm()" >제출</button>
				</td>
			</tr>
		</table>
		
	</form>
</body>
<script>
	var idCheckDone = false;
	var request;
	
	function idChanged() {
		idCheckDone = false;
	}
	
	function submitForm() {
		if (idCheckDone == true) {
			document.registerForm.submit();
		} else {
			alert("아이디 중복체크를 하세요");
		}
	}
	
	// Ajax로 id 중복체크 요청
	function idCheck() {
		
		request = new XMLHttpRequest();
		var id = document.registerForm.id.value;
		//console.log(id);
		var url = "${pageContext.request.contextPath}/idcheck?id="+id;
		//console.log(url);
		
		try {
			request.onreadystatechange = getResult;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	
	function getResult() {
		if (request.readyState == 4) {
			var result = request.responseText;
			
			if (result == 'ok') {
				idCheckDone = true;
				document.getElementById('checkResult').innerHTML="OK";
				console.log("ok was returned");
			} else {
				document.getElementById('checkResult').innerHTML="NOT OK";
				console.log("no was returned");
			}
		}
	}
</script>
</html>