<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
	  
	  $("#btn1").click(function(){
		  $("#input").css("visibility","visible"); 
	  });
	  
	  $("#btn2").click(function(){
		  var pre = $("#pre").val();
		  var id = $("#id").val();
		  //alert(pre);
		  
		  $.ajax({
				 url : "/2차프로젝트/preferenceset", 
				 type : "post",
				 data : {"pre" : pre, "id" : id},
				 dataType : "text",
				 success : result,
				 error : function(){ alert("error!");}
			 });
		  
	  });
	  
  });
  
//콜백 함수 선언
	function result(data){
		var str = "";
		str += data+"을 선호 카테고리로 지정했습니다.";
			$("#show").html(str);
	}
</script>	 
</head>
<body>


<form action = '/2차프로젝트/preferenceset' method='get'>
<input type ='hidden' name = 'user_id' value = '${user_id}'> 
 ${user_id}님의 선호 카테고리를 설정해주세요.
<input type="button" value = "설정" id="btn1">

<div id="input" style = "visibility : hidden;">
<input type = 'text' name = 'pre' id = 'pre'/>
<input type ='hidden' name = 'id' id = 'id' value = '${user_id}'> 
<input type = "button" value = "제출" id="btn2"/>
<p id="show"></p>
</div>


</form>


</body>
</html>