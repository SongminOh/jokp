<%@page import="jokp.model.UsersVO"%>
<%@page import="jokp.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

UserDAO dao = new UserDAO();
UsersVO vo = dao.userinfoList("dptmf35");
%>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<title>JOKP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>

<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<header id="header">
			<div class="inner"></div>
			<!-- Nav -->
			<nav>
				<ul>
					<li><a href="/jokp/mainpage_1.jsp" class="logo"> <span
							class="symbol"> <img src="images/logo.png" alt="" />
						</span>
					</a>
					<li>
					<li>
						<div>
							<input class="query" name="query" type="text" title="검색어 입력"
								maxlength="50" class="input_text" tabindex="1" accesskey="s"
								style="ime-mode: active;" autocomplete="off"
								onclick="document.getElementById('fbm').value=1;" value="">
						</div>
					</li>
					<li>
						<div>
							<button class="search_btn" type="submit" title="검색" tabindex="3"
								class="btn_submit" onclick="location.href='search.html'"
								style="">
								<span class="blind">검색</span> <span class="ico_search_submit"></span>
							</button>
						</div>
					</li>
					<li><a class="login"> <input type="button" value="로그인"
							onclick="showPopup();" /> <span class="set"><img
								src="images/set.png" alt="" /></span>
					</a></li>
					<li><a href="#menu">Menu</a></li>
				</ul>
			</nav>
	</div>
	</header>
<c:set var="vo" value="<%=vo %>"/> 
		<h1 align='center'>▶▶ ${vo.name }님의 History 분석◀◀</h1>
	<table class="tg">

		<h1>● 최근 시청 영상</h1>
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			google.charts.load("current", {
				packages : [ "corechart" ]
			});
			google.charts.setOnLoadCallback(drawChart);
			function drawChart() {
				var data = google.visualization.arrayToDataTable([
						[ 'Task', 'Hours per Day' ], [ 'Work', 11 ],
						[ 'Eat', 2 ], [ 'Commute', 2 ], [ 'Watch TV', 2 ],
						[ 'Sleep', 7 ] ]);

				var options = {
					title : 'My Daily Activities',
					is3D : true,
				};

				var chart = new google.visualization.PieChart(document
						.getElementById('piechart_3d'));
				chart.draw(data, options);
			}
		</script>
		</tbody>
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			// Load Charts and the corechart package.
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});

			// Draw the pie chart for Sarah's pizza when Charts is loaded.
			google.charts.setOnLoadCallback(drawSarahChart);

			// Draw the pie chart for the Anthony's pizza when Charts is loaded.
			google.charts.setOnLoadCallback(drawAnthonyChart);

			// Callback that draws the pie chart for Sarah's pizza.
			function drawSarahChart() {

				// Create the data table for Sarah's pizza.
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Topping');
				data.addColumn('number', 'Slices');
				data.addRows([ [ '동물', 10 ], [ '교육', 2 ],
					[ '요리', 14 ], [ '음악', 1 ] ]);
				// Set options for Sarah's pie chart.
				var options = {
					title : '대분류',
					width : 500,
					height : 500
				};

				// Instantiate and draw the chart for Sarah's pizza.
				var chart = new google.visualization.PieChart(document
						.getElementById('Sarah_chart_div'));
				chart.draw(data, options);
			}

			// Callback that draws the pie chart for Anthony's pizza.
			function drawAnthonyChart() {

				// Create the data table for Anthony's pizza.
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Topping');
				data.addColumn('number', 'Slices');
				data.addRows([ [ '고양이', 7 ], ['강아지', 3], [ '간단요리', 8 ],
					[ '길거리', 6 ], [ '일본어', 1 ], ['영어',1]]);

				// Set options for Anthony's pie chart.
				var options = {
					title : '소분류',
					width : 500,
					height : 500
				};

				// Instantiate and draw the chart for Anthony's pizza.
				var chart = new google.visualization.PieChart(document
						.getElementById('Anthony_chart_div'));
				chart.draw(data, options);
			}
		</script>





		<!--Table and divs that hold the pie charts-->
		<table class="columns" style="width: 30%">
			<tr>
				<td width=500><div id="Sarah_chart_div"
						style="border: 1px solid #ccc"></div></td>
				<td width=500><div id="Anthony_chart_div"
						style="border: 1px solid #ccc"></div></td>
			</tr>
		</table>


		<h1>● 좋아요 한 영상</h1>
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			// Load Charts and the corechart package.
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});

			// Draw the pie chart for Sarah's pizza when Charts is loaded.
			google.charts.setOnLoadCallback(drawSarahChart);

			// Draw the pie chart for the Anthony's pizza when Charts is loaded.
			google.charts.setOnLoadCallback(drawAnthonyChart);

			// Callback that draws the pie chart for Sarah's pizza.
			function drawSarahChart() {

				// Create the data table for Sarah's pizza.
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Topping');
				data.addColumn('number', 'Slices');
				data
						.addRows([ [ '어학', 1 ], [ '음식', 4 ],
								[ '동물', 3 ] ]);

				// Set options for Sarah's pie chart.
				var options = {
					title : '대분류',
					width : 500,
					height : 500
				};

				// Instantiate and draw the chart for Sarah's pizza.
				var chart = new google.visualization.PieChart(document
						.getElementById('Sarah_chart_div2'));
				chart.draw(data, options);
			}

			// Callback that draws the pie chart for Anthony's pizza.
			function drawAnthonyChart() {

				// Create the data table for Anthony's pizza.
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Topping');
				data.addColumn('number', 'Slices');
				data
						.addRows([ [ '고양이', 3 ], [ '간단요리', 2 ],
								[ '길거리', 2 ], [ '일본어', 1 ] ]);

				// Set options for Anthony's pie chart.
				var options = {
					title : '소분류',
					width : 500,
					height : 500
				};

				// Instantiate and draw the chart for Anthony's pizza.
				var chart = new google.visualization.PieChart(document
						.getElementById('Anthony_chart_div2'));
				chart.draw(data, options);
			}
		</script>

		<!--Table and divs that hold the pie charts-->
		<table class="columns" style="width: 30%">
			<tr>
				<td width=500><div id="Sarah_chart_div2"
						style="border: 1px solid #ccc"></div></td>
				<td width=500><div id="Anthony_chart_div2"
						style="border: 1px solid #ccc"></div></td>
			</tr>
		</table>

		<nav id="menu">
			<h2>Menu</h2>
			<ul>
				<li><a href="Index.html">Home</a></li>
				<li><a href="Mypage.html">Mypage</a></li>
				<li><a href="History.html">History</a></li>
			</ul>
		</nav>
		<!-- Main -->



		<div class="inner"></div>
		<!-- Scripts -->
		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/browser.min.js"></script>
		<script src="assets/js/breakpoints.min.js"></script>
		<script src="assets/js/util.js"></script>
		<script src="assets/js/main.js"></script>
</body>
</html>


