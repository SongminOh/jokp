<%@page import="jokp.model.MediaVO"%>
<%@page import="jokp.model.MediaDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("euc-kr");
String media_id = request.getParameter("media_id");

MediaDAO dao = new MediaDAO();
MediaVO vo = dao.mediainfoList(media_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<iframe width="427" height="240" src="<%=vo.getUrl()%>" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
</iframe>
<br><%=vo.getTitle() %>
<br>채널명 : <%=vo.getChannel() %>
<br>게시일자 : <%=vo.getDates() %>
<br>조회수 : <%=vo.getViews() %>
<br>좋아요 : <%=vo.getUp() %> 싫어요 : <%=vo.getDown() %>
<br><input type ="button" value="뒤로" onclick="location.href='/2차프로젝트/영상보관.html'">
<hr>
</body>
</html>