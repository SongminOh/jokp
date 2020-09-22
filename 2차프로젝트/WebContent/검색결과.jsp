<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
<form id="frm" action="/2차프로젝트/mediasearch">
<input type="text" id="search" name="search" placeholder="검색어 입력"/>
<input type="submit" id="btn1" value="검색" />
</form>
	<table border="0px">
		<c:forEach var = "vo" items="${list}">
		<tr>
			<td><a href='/2차프로젝트/재생.jsp?media_id=${vo.media_id}'><img src="${vo.thumbnails}"></a></td>
		</tr>
		<tr>
			<td><a href='/2차프로젝트/재생.jsp?media_id=${vo.media_id}'>${vo.title}</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>