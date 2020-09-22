<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Time"%>
<%@page import="jokp.model.StorageVO"%>
<%@page import="jokp.model.StorageDAO"%>
<%@page import="javax.websocket.Session"%>
<%@page import="jokp.model.MediaVO"%>
<%@page import="jokp.model.MediaDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("euc-kr");
String media_id = request.getParameter("media_id");

MediaDAO dao = new MediaDAO();
MediaVO vo = dao.mediainfoList(media_id);
//store�� �� ���� ����
StorageDAO st_dao = new StorageDAO();
StorageVO st_vo = new StorageVO();
st_vo.setMedia_id(media_id);
//���� �� �ð� ����
LocalDateTime currentDateTime = LocalDateTime.now();
String visit_time = "" + currentDateTime;
st_vo.setVisit_time(visit_time);
st_vo.setPlaytime(null);
st_dao.storageInsert(st_vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  
	  $("#btn1").click(function(){
		  var reple = $("#reple").val();
		  var id = $("#id").val();
		  var media_id = $("#media_id").val();
		  alert(reple);
		  alert(id);
		  alert(media_id);
		  $.ajax({
				 url : "/2��������Ʈ/repleinsert", 
				 type : "post",
				 data : {"reple" : reple, "id" : id, "media_id" : media_id},
				 dataType : "text",
				 success : list,
				 error : function(){ alert("error!1");}
			 });
	  });
	  
});
function list(){
	var media_id = $("media_id").val();
	  $.ajax({
		url : "/2��������Ʈ/jsonreple",
		type : "get",
		data : {"media_id" : media_id},
		dataType : "json",
		success : result,
		error : function(){ alert("error!!2"); }
		 
	 });
	  
}
//�ݹ� �Լ� ����
function result(data){
	var str = "<table border='0'>";
	  
	  $.each(data, function(index,obj){ //object���� ��� ���¹� obj.num
		  str += "<tr>";
		  str += "<td>�ۼ���id</td>";
		  str += "<td>����</td>";
		  str += "</tr><tr>"
		  str += "<td>"+obj.user_id+"</td>";
		  str += "<td>"+obj.content+"</td>";
		  str += "</tr>";	  
	  });
	  str += "</table>"
		$("#replelist").html(str);
}
</script>
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
	<div>
	<input type="hidden" name="id" id="id" value="<%=session.getId()%>">
	<input type="hidden" name="media_id" id="media_id" value="<%=vo.getMedia_id()%>">
			<table>
				<tr>
					<td><input type="text" name="reple" id="reple"></td>
					<td><input type="button" value="�ۼ�" id="btn1"></td>
				</tr>
			</table>
	</div>
	*���⿡ ��� ����Ʈ ���*
	<div name="replelist" id="replelist">
	</div>
</body>
</html>