<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" %>
<%@attribute name="content" required="true" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/js.js"></script>
</head>
<body>
	<div class="nav">
		<div class="container">
			<div class="brand">
				<a href="${pageContext.request.contextPath}">Timesheets</a>
			</div>
			<div class="nav-right">
			<ul>
				<li>
					<a href="${pageContext.request.contextPath}/auth/signup.html">Sign In</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/auth/signin.html">Sign Up</a>
				</li>
			</ul>
			</div>
			</div>
		<div class="clr"></div>
	</div>
	<div class="container">
		<div class="main">
			<jsp:invoke fragment="content" />
		</div>
	</div>
	<div class="footer">
		<div class="container">
			Copyright @ 2019
		</div>
	</div>
</body>
</html>