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
${user_id}���� �α����ϼ̽��ϴ�.
<input type = 'submit' value = '�ð������ϱ�'>
</form>
</body>
</html>