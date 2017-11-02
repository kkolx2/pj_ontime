<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${false}">
	<link rel="stylesheet"
		href="../../../../resources/templates/thymeleaf/css/animate.css">
	<link rel="stylesheet"
		href="../../../../resources/templates/thymeleaf/css/bootstrap.css">
</c:if>

<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<div class="panel-heading">
		<h1 class="animated fadeInRight">Bootstrap List Page</h1>
	</div>
	<div class="panel-body pull-right">
		<h3>
			<a href="/bootstrap/register">Register</a>
		</h3>
	</div>
	<div class="panel-body">
		<table class="table table-bordered">
			<tr>
				<th>bno</th>
				<th>title</th>
				<th>writer</th>
			</tr>
			<c:forEach var="bno" begin="100" end="110">
				<tr>
					<td>${bno}</td>
					<td><a href="${bno}">xxx${bno}</a></td>
					<td>yyy01</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<select id="typeSelect">
				<option value="t">Title</option>
				<option value="c">Content</option>
				<option value="w">Writer</option>
			</select> <input id="xxx" type="text">
			<button id="btnSearch">Search</button>
		</div>
	</div>

	<nav>
		<ul class="pagination">
			<li class=""><a href="10">Prev 10</a></li>
			<li class=""><a href="11">11</a></li>
			<li class=""><a href="12">12</a></li>
			<li class=""><a href="13">13</a></li>
			<li class=""><a href="14">14</a></li>
			<li class="active"><a href="15">15</a></li>
			<li class=""><a href="16">16</a></li>
			<li class=""><a href="17">17</a></li>
			<li class=""><a href="18">18</a></li>
			<li class=""><a href="19">19</a></li>
			<li class=""><a href="20">20</a></li>
			<li class=""><a href="21">Next 21</a></li>
		</ul>
	</nav>

	<form id="f1" action="/bootstrap/list" method="get">
		<input type="hidden" name="page" value="${pageVO.page}"> <input
			type="hidden" name="size" value="${pageVO.size}"> <input
			type="hidden" name="type" value="${pageVO.type}"> <input
			type="hidden" name="keyword" value="${pageVO.keyword}">
	</form>
	<!-- Class 단위면 . id 단위면 #으로 찾는다 -->
	<!-- $(".pagination a").click(function(e) { }  pagenation의 a Tag가 클릭될 때 아래 펑션에 정의된 내용을 실행한다.-->
	<!-- e.preventDefault(); -> 원본 태그의 역할을 금지시킴. a link 기능 정지-->
	<!-- var bno = $(this).attr("href"); -> 나 자신(this)의 속성(attr)중에 href 속성의 값을 bno에 저장 -->
	<script type="text/javascript">
		var formObj = $("#f1");
		$(".pagination a").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href");
			alert("page=" + page);
			
			formObj.find("[name='page']").val(page);
			
			formObj.submit();
		});
		
		$("#btnSearch").click(function(e) {
			var type = $('#typeSelect').find(":selected").val();
			var keyword = $('#xxx').val();
			alert("type="+type + " keyword="+ keyword);
			
			formObj.find("[name='type']").val(type);
			formObj.find("[name='keyword']").val(keyword);
			formObj.submit();
		});
	</script>

</body>
</html>