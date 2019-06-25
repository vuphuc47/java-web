<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<th>ProductName</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Image</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="o" items="${list}">
			<tr data-id="${o.id}">
				<td>${o.productName}</td>
				<td>${o.price}</td>
				<td>
					<input type="number" min="1" class="qty" value="${o.quantity}">
				</td>
				<td>${o.imageUrl}</td>
				<td>
					<a href="${pageContext.request.contextPath}/cart/delete/${o.id}.html">Delete</a>
				</td>
			</tr>		
		</c:forEach>
	</table>
	<script type="text/javascript">
		$('.qty').change(function(){
			var qty = $(this).val();
			var id = $(this).parent().parent().attr('data-id');
			var obj = {'quantity' :qty, 'id' :id};
			$.post('${pageContext.request.contextPath}/cart/edit.html', obj, function(data) {
				alert(data);
			});
		});
	</script>
</body>
</html>