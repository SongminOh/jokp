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
<br>ä�θ� : <%=vo.getChannel() %>
<br>�Խ����� : <%=vo.getDates() %>
<br>��ȸ�� : <%=vo.getViews() %>
<br>���ƿ� : <%=vo.getUp() %> �Ⱦ�� : <%=vo.getDown() %>
<br><input type ="button" value="�ڷ�" onclick="location.href='/2��������Ʈ/���󺸰�.html'">
<hr>
</body>
</html>