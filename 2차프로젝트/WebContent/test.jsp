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
				<td>${vo.set_time}</td>
			</tr>
			
		</table>

</body>
</html>