<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<meta charset="UTF-8">
<title>save</title>
<script type="text/javascript">
            window.onload = function () {
                let httpRequest;
                document.getElementById("memberEmail").addEventListener('blur', () => {
                    let inputEmail = document.getElementById("memberEmail").value;
                    console.log(inputEmail);
                    let resultMessage = document.getElementById("checkEmailResult");
                    
                    let reqJson = new Object();
                    reqJson.email = inputEmail;

                    httpRequest = new XMLHttpRequest();
                    httpRequest.onreadystatechange = () => {
                        if (httpRequest.readyState === XMLHttpRequest.DONE) {
                            if (httpRequest.status === 200) {
                                if (httpRequest.responseText == "true") {
                                    resultMessage.style.color = "green";
                                	console.log(httpRequest.responseText);
                                    resultMessage.innerHTML = "사용가능한 이메일입니다.";
                                } else {
                                    resultMessage.style.color = "red";
                                    console.log(httpRequest.responseText);
                                    resultMessage.innerHTML = inputEmail+"는 중복되는 이메일입니다.";
                                }
                            } else {
                                alert('에러 발생~!!!');
                            }
                        }
                    }
                    httpRequest.open('POST', '/member/checkEmail', true);
                    httpRequest.responseType = 'text';
                    httpRequest.setRequestHeader('Content-Type', 'application/json');
                    httpRequest.send(JSON.stringify(reqJson));
                });
            }
        </script>
</head>

<body>
	<form action="/member/save" method="post">
		<input type="text" id="memberEmail" name="memberEmail"
			placeholder="이메일"><br>
		<p id="checkEmailResult"></p>
		<input type="text" name="memberPassword" placeholder="비밀번호"><br>
		<input type="text" name="memberName" placeholder="이름"><br>
		<input type="text" name="memberAge" placeholder="나이"><br>
		<input type="text" name="memberMobile" placeholder="전화번호"><br>
		<input type="submit" value="회원가입">

	</form>

</body>

</html>