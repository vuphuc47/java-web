<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<f:form modelAttribute="o" method="post" enctype="multipart/form-data">
		<p>
			<label>name</label>
			<f:input path="productName" />
		</p>
		<p>
			<label>Category</label>
			<f:select path="categoryId" itemValue="id" itemLabel="name"
				items="${list}" />
		</p>
		<p>
			<label>Price</label>
			<f:input path="price" />
		<p>
			<label>Quantity</label>
			<f:input path="quantity" />
		</p>
		<p>
			<label>Image</label> <input type="file" name="file">
		</p>
		<p>
			<label>Description</label>
			<f:textarea rows="10" cols="80" path="description" />
		</p>
		<p>
			<button>Save</button>
		</p>
	</f:form>

	<a>--------------------------------------------------------------------------------------</a>
	<form method="post" enctype="multipart/form-data">
		<p>
			<label>name</label> <input type="text" name="productName"
				value="${o.productName}">
		</p>
		<p>
			<label>Category</label> <select name="categoryId">
				<c:forEach var="p" items="${list}">
					<c:choose>
						<c:when test="${o.categoryId == p.id}">
							<option selected="selected" value="${p.id}">${p.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${p.id}">${p.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>Price</label> <input type="number" name="price"
				value="${o.price}">
		</p>
		<p>
			<label>Quantity</label> <input type="number" name="quantity"
				value="${o.quantity}">
		</p>
		<p>
			<label>Image</label> <input type="file" name="file">
		</p>
		<p>
			<label>Description</label>
			<textarea rows="10" cols="80">${o.description}</textarea>
		</p>
		<p>
			<button>Save</button>
		</p>
	</form>
</body>
</html>