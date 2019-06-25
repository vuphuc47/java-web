<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><t:insertAttribute name="title" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="row">
		<div class="container">
			<div class="brand">
				<a href="${pageContext.request.contextPath}">Mini Shop</a>
			</div>
			<div class="nav-right">
				<ul>
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal != null}">
							<li><a>WelCome:
									${pageContext.request.userPrincipal.name}</a></li>
							<li>
								<form method="post"
									action="${pageContext.request.contextPath}/auth/signout.html">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}">
									<button>Sign Out</button>
								</form>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/admin/category.html">Category</a>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/admin/product.html">Product</a>
							</li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/auth/signup.html">Sign
									Up</a></li>
							<li><a
								href="${pageContext.request.contextPath}/auth/signin.html">Sign
									In</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<div class=row>
		<t:insertAttribute name="content" />
	</div>
</body>
</html>