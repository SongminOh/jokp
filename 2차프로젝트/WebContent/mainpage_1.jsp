<%@page import="jokp.model.UsersVO"%>
<%@page import="jokp.model.MediaVO"%>
<%@page import="jokp.model.MediaDAO"%>
<%@page import="jokp.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

UserDAO dao = new UserDAO();
UsersVO vo = dao.userinfoList("dptmf35");
%>

<!DOCTYPE HTML>
<html>
<head>
<title>JOKP</title>
<link rel="stylesheet" type="text/css"
	href="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
  		url : "/jokp/jsonuserpreference",
  		type : "get",
  		dataType : "json",
  		success : result,
  		error : function(){ alert("error!!"); }
	});
	
	$.ajax({
  		url : "/jokp/jsonuserpreference2",
  		type : "get",
  		dataType : "json",
  		success : result2,
  		error : function(){ alert("error!!"); }
	});
	
	$.ajax({
  		url : "/jokp/jsonuserpreference3",
  		type : "get",
  		dataType : "json",
  		success : result3,
  		error : function(){ alert("error!!"); }
	});
	
});

function result(data){
	  var str = "";
	  $.each(data, function(main,obj){ //object에서 요소 빼는법 obj.num
		  str += "<article class='style"+obj.media_id+"'>";
		  str += "<div class='image'>";
		  str += "<a href='/jokp/재생.jsp?media_id="+obj.media_id+"'><img src='"+obj.thumbnails+"'/></a></div>";
		  str += "<h2>"+ obj.title +"</h2>"
		  str += "<p>"+ obj.hashtag + "</p></article>";
	  });
		  $("#tiles").html(str);
}

function result2(data){
	  var str = "";
	  $.each(data, function(main,obj){ //object에서 요소 빼는법 obj.num
		  str += "<article class='style"+obj.media_id+"'>";
		  str += "<div class='image'>";
		  str += "<a href='/jokp/재생.jsp?media_id="+obj.media_id+"'><img src='"+obj.thumbnails+"'/></a></div>";
		  str += "<h2>"+ obj.title +"</h2>"
		  str += "<p>"+ obj.hashtag + "</p></article>";
	  });
		  $("#tiles2").html(str);
}

function result3(data){
	  var str = "";
	  $.each(data, function(main,obj){ //object에서 요소 빼는법 obj.num
		  str += "<article class='style"+obj.media_id+"'>";
		  str += "<div class='image'>";
		  str += "<a href='/jokp/재생.jsp?media_id="+obj.media_id+"'><img src='"+obj.thumbnails+"'/></a></div>";
		  str += "<h2>"+ obj.title +"</h2>"
		  str += "<p>"+ obj.running_time + "</p></article>";
	  });
		  $("#tiles3").html(str);
}

</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<style>
.image {
	position: relative;
}

.image button {
	position: absolute;
	z-main: 10;
	top: 50%;
	transform: translateY(-50%);
	width: 71px;
	height: 71px;
	border-radius: 100%;
	background: rgba(0, 0, 0, .5);
	border: none;
}

.image button:before {
	font-family: 'xeicon';
	color: #fff;
	font-size: 45px;
}

.xi-angle-left button.slick-prev {
	left: 50px;
	font-size: 0;
	color: transparent;
}

.xi-angle-left button.slick-prev:before {
	content: "\e93b";
	font-family: 'xeicon';
}

.xi-angle-right button.slick-next {
	right: 50px;
	font-size: 0;
	color: transparent;
}

.xi-angle-right button.slick-next:before {
	content: "\e93e";
	font-family: 'xeicon';
}

.con1 {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.items2 {
	display: flex;
	justify-content: space-between;
}
</style>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>




</head>
<body class="is-preload">
	<div id="show">
	</div>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->

		<header id="header">
			<div class="inner">

				

				</div>
				<!-- Nav -->
				<nav>
					<ul>
						<li><a href="main.html" class="logo"> <span class="symbol">
								<img src="images/logo.png" alt="" />
						</span>
						</a><li>
						<li>
							<form action="/jokp/mediasearch">
						<div>
							<input class="search_keyword" name="search_keyword" id="search_keyword" type="text" title="검색어 입력"
								maxlength="50" class="input_text" tabmain="1" accesskey="s"
								style="ime-mode: active;" autocomplete="off" placeholder="검색어 입력">
						</div>
						</li>
						<li>
						<div>
							<button class="search_btn" type="submit" title="검색" tabmain="3"
								class="btn_submit" style="">
								<span class="blind">검색</span> <span class="ico_search_submit"></span>
							</button>
						</div>
							</form>
						</li>
						<li><a class="login"> <input type="button" value="로그아웃"
							onclick="" /> <span class="set"></span>
						 <img src="images/set.png" onclick="showPopup2();" /> <span class="set"> 
							</span></a>
						</li>
						</li>
						<li><a href="#menu">Menu </a></li>
					</ul>
				</nav>

			</div>
		</header>


		<!-- Menu -->
		<nav id="menu">
			<h2>Menu</h2>
			<ul>
				<li><a href="main.html">Home</a></li>
				<li><a href="/jokp/mainpage_2.jsp">Mypage</a></li>
				<li><a href="/jokp/myhistorychart.jsp">History</a></li>


			</ul>
		</nav>



		<!-- Main -->

		<div id="main">
			<div class="inner">

				<header>
				<c:set var="vo" value="<%=vo %>"/> 
					<h1>${user_id}님의 선호 카테고리(${vo.preference}) 영상 추천</h1>
				</header>

				<section class="tiles" id="tiles">
					<!-- <i class="xi-angle-left"></i> -->
					
				</section>

				<header>
					<h1>나와 유사 직업/나이(${vo.job }/${vo.age })인 사람이 많이 보는 영상</h1>
				</header>

				<section class="tiles" id="tiles2">

				</section>

				<section class="tiles" id="tiles">
					<!-- <i class="xi-angle-left"></i> -->
					
				</section>

				<header>
					<h1>이어볼 영상 조합 : ${vo.set_time}분 영상 재생 리스트 </h1>
				</header>

				<section class="tiles" id="tiles3">

				</section>
			
			</div>
		</div>


	</div>

	<!-- Scripts -->
	<script type="text/javascript"
		src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript"
		src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script type="text/javascript">
		$('tiles').click({
			slide : 'section',
			slidesToShow : 5,
			slidesToScroll : 1,
			autoplay : false,
			autoplaySpeed : 2000,
		});
	</script>
	<script language="javascript">
		function showPopup2() {
			location.href = '/jokp/userUpdate.jsp'
		}
	</script>

</body>
</html>