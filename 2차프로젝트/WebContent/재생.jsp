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
//store에 본 영상 저장
StorageDAO st_dao = new StorageDAO();
StorageVO st_vo = new StorageVO();
st_vo.setMedia_id(media_id);
//영상 본 시간 저장
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
				 url : "/2차프로젝트/repleinsert", 
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
		url : "/2차프로젝트/jsonreple",
		type : "get",
		data : {"media_id" : media_id},
		dataType : "json",
		success : result,
		error : function(){ alert("error!!2"); }
		 
	 });
	  
}
//콜백 함수 선언
function result(data){
	var str = "<table border='0'>";
	  
	  $.each(data, function(index,obj){ //object에서 요소 빼는법 obj.num
		  str += "<tr>";
		  str += "<td>작성자id</td>";
		  str += "<td>내용</td>";
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
<br>채널명 : <%=vo.getChannel() %>
<br>게시일자 : <%=vo.getDates() %>
<br>조회수 : <%=vo.getViews() %>
<br>좋아요 : <%=vo.getUp() %> 싫어요 : <%=vo.getDown() %>
<br><input type ="button" value="뒤로" onclick="location.href='/2차프로젝트/영상보관.html'">
<hr>
	<div>
	<input type="hidden" name="id" id="id" value="<%=session.getId()%>">
	<input type="hidden" name="media_id" id="media_id" value="<%=vo.getMedia_id()%>">
			<table>
				<tr>
					<td><input type="text" name="reple" id="reple"></td>
					<td><input type="button" value="작성" id="btn1"></td>
				</tr>
			</table>
	</div>
	*여기에 댓글 리스트 출력*
	<div name="replelist" id="replelist">
	</div>
</body>
</html>