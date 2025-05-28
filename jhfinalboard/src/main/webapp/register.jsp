<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>

	<c:if test="${not empty errorMsg }">
		<script>
			alert("${errorMsg}");
		</script>
	</c:if>

	<form action="/register" method="post">
		ID : <input type="text" name="input_id" value="${input_id}" /><br>
		PW : <input type="password" name="input_pw" /><br> PW 재입력 : <input
			type="password" name="check_pw" /><br> <input type="submit"
			value="회원가입" />
	</form>
</body>
</html>