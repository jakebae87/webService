<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="/member/update" method="post" name="updateForm">
        id: <input type="text" name="id" value="${member.id}"readonly><br>
        email: <input type="text" name="memberEmail" value="${member.memberEmail}"readonly><br>
        password: <input type="text" name="memberPassword" id="memberPassword"><br>
        name: <input type="text" name="memberName" value="${member.memberName}" readonly><br>
        age: <input type="text" name="memberAge" value="${member.memberAge}"><br>
        mobile: <input type="text" name="memberMobile" value="${member.memberMobile}"><br>
        <input type="button" value="수정" onclick="update()">
        
        <!-- input type의 submit 혹은 button 태그로 작성하면, 클릭 시 바로 form action 주소로 이동한다.  -->

    </form>
</body>
<script>
    const update = () => {
        const passwordDB = '${member.memberPassword}';
        const password = document.getElementById("memberPassword").value;
        if (passwordDB == password) {
            document.updateForm.submit(); 
            /*document(현대 문서에서).updateForm(이 name 값을 갖는 태그를).submit(제출해라)  */
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>