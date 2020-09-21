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
				<td>아이디</td>
				<td>${vo.user_id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${vo.age}</td>
			</tr>
			<tr>
				<td>직업</td>
				<td>${vo.job}</td>
			</tr>
			<tr>
				<td>선호장르</td>
				<td>${vo.preference}</td>
			</tr>
			<tr>
				<td>선호시간</td>
				<td>${vo.set_time}</td>
			</tr>
			
		</table>

</body>
</html>