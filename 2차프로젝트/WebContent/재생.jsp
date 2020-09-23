<%@page import="jokp.model.UserDAO"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.sql.Time"%>
<%@page import="jokp.model.StorageVO"%>
<%@page import="jokp.model.StorageDAO"%>
<%@page import="javax.websocket.Session"%>
<%@page import="jokp.model.MediaVO"%>
<%@page import="jokp.model.MediaDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
request.setCharacterEncoding("euc-kr");
String media_id = request.getParameter("media_id");

MediaDAO dao = new MediaDAO();
MediaVO vo = dao.mediainfoList(media_id);

//영상 본 시간 저장
LocalDateTime currentDateTime = LocalDateTime.now();
String visit_time = "" + currentDateTime;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		
	
	  $("#likebtn").click(function(){
		  var user_id =  $("#user_id").val();
		  var media_id =  $("#media_id").val();
		  var visit_time =  $("#visit_time").val();
		  var playtime =  $("#playtime").val();
		  var like =  1;
		  $.ajax({
				 url : "/2차프로젝트/storageinsert", 
				 type : "post",
				 data : {"user_id" : user_id, "media_id" : media_id, "visit_time" : visit_time, "playtime" : playtime, "like" : like},
				 dataType : "text",
				 success : alert("좋아요 : 영상이 저장되었습니다."),
				 error : function(){ alert("error!1");}
			 });
		
	  });
	  
	$("#hatebtn").click(function(){
		var user_id =  $("#user_id").val();
		  var media_id =  $("#media_id").val();
		  var visit_time =  $("#visit_time").val();
		  var playtime =  $("#playtime").val();
		  var like = 0;
		$.ajax({
			 url : "/2차프로젝트/storageinsert", 
			 type : "post",
			 data : {"user_id" : user_id, "media_id" : media_id, "visit_time" : visit_time, "playtime" : playtime, "like" : like},
			 dataType : "text",
			 success : alert("싫어요 : 영상이 저장되었습니다."),
			 error : function(){ alert("error!1");}
		 });  
	  });
	  
	  $("#btn").click(function(){
		  var reple = $("#reple").val();
		  var id = $("#user_id").val();
		  var media_id = $("#media_id").val();
		  alert(reple, id, media_id)
		  $.ajax({
				 url : "/2차프로젝트/repleinsert", 
				 type : "post",
				 data : {"media_id" : media_id, "user_id" : user_id, "reple" : reple },
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


<br><c:set var="vo" value="<%=vo %>"/> 
<iframe width="427" height="240" src="${vo.url}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
</iframe>
<br>${vo.title }
<br>채널명 : ${vo.channel } 
<br>게시일자 : ${vo.dates }
<br>조회수 : ${vo.views }
<br>좋아요 : ${vo.up } 싫어요 : ${vo.down }
<br><input type ="button" value="뒤로" onclick="location.href='/2차프로젝트/영상보관.html'">
<hr>
<input type="button" id="likebtn" value="좋아요">
<input type="button" id="hatebtn" value="싫어요">
	<div>

		<input type="hidden" name="user_id" id="user_id" value="<%=session.getId()%>">
		<input type="hidden" name="media_id" id="media_id" value="${vo.media_id}">
		<input type="hidden" name="visit_time" id="visit_time" value="<%=visit_time%>">
		<input type="hidden" name="playtime" id="playtime" value="0:0">

	
			<table>
				<tr>
					<td><input type="text" name="reple" id="reple"></td>
					<td><input type="button" value="작성" id="btn"></td>
				</tr>
			</table>
	</div>
	<a href="/2차프로젝트/repletest.jsp?media_id=${vo.media_id}">*여기에 댓글 리스트 출력*</a>
	<div name="replelist" id="replelist">
	</div>
</body>
</html>