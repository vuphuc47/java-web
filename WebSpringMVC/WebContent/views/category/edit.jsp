<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<f:form modelAttribute="o" method="post">
		<p>
			<label>Name</label>
			<f:input path="name" />
		</p>
		<p>
			<lable>Parent</lable>
			<f:select path="parent">
				<option value="">--Select Parent--</option>
				<f:options itemValue="id" itemLabel="name" items="${list}" />
			</f:select>
		</p>
		<p>
			<button>Save</button>
		</p>
	</f:form>

	<form method="post">
		<input type="hidden" name="id" value="${o.id}">
		<p>
			<label>Name</label> <input type="text" name="name" value="${o.name}">
		</p>
		<p>
			<button>Lưu</button>
		</p>
	</form>
</body>
</html>