<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://timesheetservlet.com/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th rowspan="2">Họ Tên</th>
				<th rowspan="2">Giới Tính</th>
				<th rowspan="2">Ngày Sinh</th>
				<th rowspan="2">Nơi Sinh</th>
				<th rowspan="2">Bộ Môn</th>
				<c:forEach var="date" items="${dates}">
					<td>${date}</td>
				</c:forEach>
			</tr>
			<tr>
				<th>Thứ 2</th>
				<th>Thứ 3</th>
				<th>Thứ 4</th>
				<th>Thứ 5</th>
				<th>Thứ 6</th>
				<th>Thứ 7</th>
				<th>Chủ Nhật</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="o" items="${list}">
				<tr data-id="${o.id}">
					<td>${o.lastName}${o.firstName}</td>
					<td>${gender[o.gender]}</td>
					<td>${o.dateOfBirth}</td>
					<td>${o.placeOfBirth}</td>
					<td>${o.subject}</td>
					<c:forEach var="i" begin="0" end="6">
						<td><f:Select cssClass="chk" value="${dates[i]}"
								checked="${o.timeSheet[i]}" /></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript">
		var a = document.getElementsByClassName("chk");
		for (var i = a.length - 1; i >= 0; i--) {
			a[i].onclick = function() {
				//alert(this.value);
				var d = this.value;
				var id = this.parentNode.parentNode.getAttribute('data-id');
				alert(id);
				var xhr = new XMLHttpRequest();
				xhr
						.open('POST',
								'${pageContext.request.contextPath}/attendance/add.html');
				xhr.setRequestHeader('Content-Type',
						'application/x-www-form-urlencoded');
				xhr.send('id=' + id + '&d=' + d);
				xhr.onLoad = function() {
					alert(xhr.response);
				}
			}
		}
	</script>
</body>
</html>