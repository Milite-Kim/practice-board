<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>

	<c:if test="${not empty msg}">
		<script>
			alert("${errorMsg}");
		</script>
	</c:if>

	<form action="/login" method="post">
		ID : <input type="text" name="id" value="input_id" /><br> PW : <input
			type="password" name="pw" /> <input type="submit" value="로그인">
	</form>
</body>
</html>