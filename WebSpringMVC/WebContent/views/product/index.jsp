<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<a href="${pageContext.request.contextPath}/product/add.html">Add</a>
	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Category</th>
			<th>Image</th>
			<th>Description</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		<c:forEach var="o" items="${list}">
			<tr>
				<td>${o.categoryId}</td>
				<td>${o.productName}</td>
				<td>${o.price}</td>
				<td>${o.quantity}</td>
				<td>${o.categoryName}</td>
				<td><img width="150"
					src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
				</td>
				<td>${o.description}</td>
				<td><a
					href="${pageContext.request.contextPath}/product/delete/${o.id}.html"><img
						src="${pageContext.request.contextPath}/images/delete.png"></a></td>
				<td><a
					href="${pageContext.request.contextPath}/product/edit/${o.id}.html"><img
						src="${pageContext.request.contextPath}/images/edit.png"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>