<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("euc-kr");
String media_id = request.getParameter("media_id");
%>
<c:set var="media_id" value="<%=media_id%>"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#btn").click(function(){
		  var media_id =  $("#media_id").val();
		  var user_id =  $("#user_id").val();
		  var reple =  $("#reple").val();
		  $.ajax({
				 url : "/jokp/repleinsert", 
				 type : "post",
				 data : {"user_id" : user_id, "media_id" : media_id, "reple" : reple},
				 dataType : "text",
				 success : list,
				 error : function(){ alert("error!1");}
			 });
		
	  });
	
	
	
});

function list(){
	var media = $("#media_id").val();
	$.ajax({
  		url : "/jokp/jsonreple",
  		type : "post",
  		data : {"media_id" : media_id},
  		dataType : "json",
  		processData: false,
  		contentType: false,
  		success : result,
  		error : function(){ alert("error!!"); }
	});
	
}


function result(data){
	  var str = "<table border='0'>";
	  	str += "<tr>";
	  	str += "<td>작성자</td>"
	  	str += "<td>내용</td>"
	  	str += "</tr>";
	  $.each(data, function(index,obj){ //object에서 요소 빼는법 obj.num
		  str += "<tr>";
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
${media_id }
					<input type="hidden" name="media_id" id="media_id" value="${media_id}">
					<input type="hidden" name="user_id" id="user_id" value="dptmf35">
<div>
			<table>
				<tr>
					<td><input type="text" name="reple" id="reple"></td>
					<td><input type="button" value="작성" id="btn"></td>
				</tr>
			</table>
</div>

	*여기에 댓글 리스트 출력*
	<div name="replelist" id="replelist">
	</div>
</body>
</html>