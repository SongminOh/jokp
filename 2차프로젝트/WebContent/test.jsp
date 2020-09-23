<%@page import="jokp.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action = '/jokp/userinfo' method='get'>
<input type ='hidden' name = 'user_id' value = '${user_id}'> 
${user_id}님이 로그인하셨습니다.
<input type = 'submit' value = '시간설정하기'>
</form>
</body>
</html>