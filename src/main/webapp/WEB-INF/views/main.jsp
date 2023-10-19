<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    <h2>${sessionScope.loginEmail} 님 환영합니다.</h2>
    <button onclick="update()">내정보 수정하기</button>
    <button onclick="logout()">로그아웃</button><br><br>
    <button onclick="list()">회원목록</button>
    <button onclick="home()">홈으로</button>

</body>
<script>
    const update = () => {
        location.href = "/member/update";
    }
    const logout = () => {
        location.href = "/member/logout";
    }
    const list = () => {
        location.href = "/member/";
    }

    const home = () => {
        location.href = "/";
    }
</script>
</html>