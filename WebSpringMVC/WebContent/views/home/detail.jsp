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
	<h1>${o.productName}</h1>
	<img class="img" src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
	<p>Price: ${o.price}</p>
	<p>Quantity: ${o.quantity}</p>
	<form method="post" action="${pageContext.request.contextPath}/cart/add.html">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" value="${o.id}" name="productId">
		<input type="number" value="1" min="1" name="quantity">
		<input type="hidden" value="${o.price}" name="price">
		<button>Buy</button>
	</form>
	<div>${o.description}</div>
</body>
</html>