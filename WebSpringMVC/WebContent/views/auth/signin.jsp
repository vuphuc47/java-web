<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<p>
			<label>UserName</label>
			<input type="text" name="username">
		</p>
		<p>
			<label>PassWord</label>
			<input type="password" name="password">
		</p>
		<p>
			<button>Sign In</button>
		</p>
		<c:if test="${param.error != null}">
			<p class="error">Đăng nhập không thành công</p>
		</c:if>
		
	</form>
</body>
</html>