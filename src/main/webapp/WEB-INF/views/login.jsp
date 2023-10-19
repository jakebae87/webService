<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>login</title>
</head>
<body>
	<form action="/member/login" method="post">
		<input type="text" name="memberEmail" placeholder="이메일"><br>
		<input type="text" name="memberPassword" placeholder="비밀번호"><br>
		<br> <input type="submit" value="로그인">&nbsp;
	</form>
	<button onclick="home()">홈으로</button>
</body>
<script>
    const home = () => {
        location.href = "/";
    }
</script>
</html>