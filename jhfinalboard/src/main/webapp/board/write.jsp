<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
</head>
<body>
	<jsp:include page="/common/header.jsp" />
	<hr>
	<form action="/board/write">
	
	|제목 : <input type="text" name="title" />
	<br>
	본문 : <textarea name="content" rows="10" cols="150"></textarea>
	
	</form>
</body>
</html>