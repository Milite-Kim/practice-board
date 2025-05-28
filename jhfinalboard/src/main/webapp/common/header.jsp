<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 로그인 정보</title>
</head>
<body>
	<div id="header">
		<c:choose>
			<c:when test="${not empty sessionScope.loginID}">
				<span>
				${sessionScope.loginID} 님 환영합니다!
				</span>
				&nbsp;|&nbsp;
				<a href="/logout">로그아웃</a>
			</c:when>
			<c:otherwise>
			<a href="/login.jsp">로그인</a>
			&nbsp;|&nbsp;
			<a href="/register.jsp">회원가입</a>
			</c:otherwise>
		</c:choose>
		
		<hr style="margin-top: 10px;">
		
		<nav>
		<a href="/board/list?category=all">전체글보기</a>
		<a href="/board/list?category=free">자유게시판</a>
		<a href="/board/list?category=QnA">질문게시판</a>
		<a href="/board/list?category=notion">공지사항</a>
		</nav>
	</div>
</body>
</html>