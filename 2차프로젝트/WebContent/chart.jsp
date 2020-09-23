<%@page import="jokp.model.StorageDAO"%>
<%@page import="jokp.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
 
<head>
  <meta charset="utf-8">
  <title>ZingSoft Demo</title>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
  		url : "/2차프로젝트/jsonstorage",
  		type : "get",
  		dataType : "json",
  		success : list,
  		error : function(){ alert("error!!"); }
	});
	
});
</script>
  <script src="https://cdn.zingchart.com/zingchart.min.js"></script>
  <style>
    html,
    body,
    #myChart {
      height: 100%;
      width: 100%;
    }
  </style>
</head>
 
<body>
  <div id='myChart'></div>
  <script>
    ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9", "b55b025e438fa8a98e32482b5f768ff5"];
    var myConfig = {
      "type": "pie",
      "plot": {
        //"detached":true
      },
      "series": [{
          "values": [59],
          "detached": true,
          //"offset-r":25
        },
        {
          "values": [55]
        },
        {
          "values": [30]
        },
        {
          "values": [28]
        },
        {
          "values": [15]
        }
      ]
    };
 
    zingchart.render({
      id: 'myChart',
      data: myConfig,
      height: 400,
      width: 600
    });
  </script>
</body>
 
</html>