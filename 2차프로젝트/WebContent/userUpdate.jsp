<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<Head>
<title>JOKP</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.slidecontainer {
	width: 100%;
}

.slider {
	-webkit-appearance: none;
	width: 100%;
	height: 25px;
	background: #d3d3d3;
	outline: none;
	opacity: 0.7;
	-webkit-transition: .2s;
	transition: opacity .2s;
}

.slider:hover {
	opacity: 1;
}

.slider::-webkit-slider-thumb {
	-webkit-appearance: none;
	appearance: none;
	width: 25px;
	height: 25px;
	background: #4CAF50;
	cursor: pointer;
}

.slider::-moz-range-thumb {
	width: 25px;
	height: 25px;
	background: #4CAF50;
	cursor: pointer;
}
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}



.container {
	padding: 16px;
}



@media screen and (max-width: 300px) {
	.cancelbtn {
		width: 100%;
	}
}
</style>
</Head>
<header>
<a href="/jokp/main.html" class="logo"> <span class="symbol">
<img src="images/logo.png" alt="" /></span></a>

</header>
<body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
		var slider = document.getElementById("set_time");
		var output = document.getElementById("demo");
		output.innerHTML = slider.value;

		slider.oninput = function() {
			output.innerHTML = this.value;
		}
</script>
<h1>1. ${user_id}님의 선호 카테고리를 선택해주세요</h1>
	<form action="/jokp/userset">
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="checkbox" name="preference" value="영화"> 영화
		<br><input type="checkbox" name="preference" value="만화"> 만화
		<br><input type="checkbox" name="preference" value="교육"> 교육
		<br><input type="checkbox" name="preference" value="음악"> 음악
		<br><input type="checkbox" name="preference" value="음식"> 음식
		<br><input type="checkbox" name="preference" value="시사/뉴스"> 시사/뉴스
		<br><input type="checkbox" name="preference" value="동물"> 동물
<h1>2.영상 시청시간을 설정 해주세요</h1>

	<div class="slidecontainer">
		<input type="range" min="1" max="20" value="1" class="slider"
			id="set_time" name="set_time">
		<p>
			시간(분): <span id="demo"></span>
		</p>
	</div>
	
	<script>
		var slider = document.getElementById("set_time");
		var output = document.getElementById("demo");
		output.innerHTML = slider.value;

		slider.oninput = function() {
			output.innerHTML = this.value;
		}
	</script>

	<div class="container">
		<button type="submit">확인</button>
	</form>
		<button type="button" class="cancelbtn" onclick="location.href='/jokp/mainpage.jsp'">취소</button>
	</div>


</body>
</html>