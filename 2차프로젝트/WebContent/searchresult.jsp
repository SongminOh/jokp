<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>JOKP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<header id="header">
			<div class="inner">

				

				</div>
				<!-- Nav -->
				<nav>
					<ul>
						<li><a href="/jokp/main.html" class="logo"> <span class="symbol">
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
						<li><a class="login"> <input type="button" value="로그인"
							onclick="showPopup();" /> <span class="set"><img
								src="images/set.png" alt="" /></span>
						</a>
						</li>
						<li><a href="#menu">Menu</a></li>
					</ul>
				</nav>

			</div>
		</header>

		<!-- Menu -->
		<nav id="menu">
			<h2>Menu</h2>
			<ul>
				<li><a href="Index.html">Home</a></li>
				<li><a href="Mypage.html">Mypage</a></li>
				<li><a href="History.html">History</a></li>
			</ul>
		</nav>

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<header>
					<h1>검색 결과</h1>
				</header>

				<section class="tiles" id ="tiles">
					<c:forEach var = "vo" items="${list}">
						<article class='style${vo.media_id}'>
							<div class = 'image'>
								<a href='/jokp/재생.jsp?media_id=${vo.media_id}'><img src='${vo.thumbnails}'/></a></div>
								<h2>${vo.title}</h2>
								<p>${vo.hashtag}</p>
						</article>
					</c:forEach>
				</section>

				
			</div>
		</div>


	</div>


	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>