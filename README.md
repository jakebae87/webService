<h1>개발환경</h1>
<li>JDK: amazon corretto 11</li>
<li>DB: mysql</li>
<li>mybatis</li>
<li>view: JSP</li>


<h3>MySQL 설정</h3>

<b>DB계정 생성</b></br>
create database web_project;</br>
create user web_user@localhost identified by '0816';</br>
grant all privileges on web_project.* to web_user@localhost;</br>

<b>멤버 테이블 생성</b></br>
create table member_table(</br>
	id bigint primary key auto_increment,</br>
    memberEmail varchar(20) unique,</br>
    memberPassword varchar(20),</br>
    memberName varchar(20),</br>
    memberAge int,</br>
    memberMobile varchar(30)</br>
); </br>
