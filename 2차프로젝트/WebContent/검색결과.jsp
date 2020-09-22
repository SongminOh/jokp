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
	<table border="1px">
		<tr>
			<td>영상제목</td>
			<td>썸네일</td>
		</tr>
		<c:forEach var = "vo" items="${list}">
		<tr>
			<td>${vo.title}</td>
			<td><img src="${vo.thumbnails}"></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>