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
<form action = '/2��������Ʈ/timeset' method='post'>
<input type ='hidden' id='user_id' name = 'user_id' value = '${vo.user_id}'> 
<table>
			<tr>
				<td>���̵�</td>
				<td>${vo.user_id}</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${vo.age}</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${vo.job}</td>
			</tr>
			<tr>
				<td>��ȣ�帣</td>
				<td>${vo.preference}</td>
			</tr>
			<tr>
				<td>��ȣ�ð�</td>
				<td><input type='text' name = 'set_time' value ='${vo.set_time}'></td>
			</tr>
			<tr colspan = 2>
				<td><input type = 'submit' value = '����'></td>
			</tr>
		</table>
</form>
</body>
</html>