<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>index</title>
<style type="text/css">
a {
	background-color: gray;
	padding: 15px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}
</style>
</head>
<body>
	<h2>hello spring framework 회원 프로젝트 입니다.</h2>

	<c:if test="${empty sessionScope.loginEmail}">
		<a href="/member/save">회원가입</a>
		<a href="/member/login">로그인</a>
	</c:if>
	<c:if test="${not empty sessionScope.loginEmail}">
		<a href="/member/update">내정보 수정하기</a>
		<a href="/member/">회원목록 조회</a>
		<a href="/member/logout">로그아웃</a>
	</c:if>
</body>
</html>