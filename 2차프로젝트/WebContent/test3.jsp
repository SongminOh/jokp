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
				 url : "/2��������Ʈ/preferenceset", 
				 type : "post",
				 data : {"pre" : pre, "id" : id},
				 dataType : "text",
				 success : result,
				 error : function(){ alert("error!");}
			 });
		  
	  });
	  
  });
  
//�ݹ� �Լ� ����
	function result(data){
		var str = "";
		str += data+"�� ��ȣ ī�װ��� �����߽��ϴ�.";
			$("#show").html(str);
	}
</script>	 
</head>
<body>


<form action = '/2��������Ʈ/preferenceset' method='get'>
<input type ='hidden' name = 'user_id' value = '${user_id}'> 
 ${user_id}���� ��ȣ ī�װ��� �������ּ���.
<input type="button" value = "����" id="btn1">

<div id="input" style = "visibility : hidden;">
<input type = 'text' name = 'pre' id = 'pre'/>
<input type ='hidden' name = 'id' id = 'id' value = '${user_id}'> 
<input type = "button" value = "����" id="btn2"/>
<p id="show"></p>
</div>


</form>


</body>
</html>