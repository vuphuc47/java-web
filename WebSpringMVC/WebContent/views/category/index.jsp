<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<form method="post"
		action="${pageContext.request.contextPath}/admin/category/delete.html">
		<a href="${pageContext.request.contextPath}/admin/category/add.html">ADD</a>
		<table class="table table-bordered">
			<tr>
				<td>
					<button>Delete all</button>
				</td>
				<th>Id</th>
				<th>Name</th>
				<th>Parent</th>
				<th>Edit</th>
			</tr>
			<c:forEach var="o" items="${list}">
				<tr>
					<td><input type="checkbox" name="arr" value="${o.id}">
					</td>
					<td>${o.id}</td>
					<td>${o.name}</td>
					<td>${o.parentName}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/category/delete/${o.id}.html">
							<img src="${pageContext.request.contextPath}/images/delete.png">
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/category/edit/${o.id}.html">
							<img src="${pageContext.request.contextPath}/images/edit.png">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>