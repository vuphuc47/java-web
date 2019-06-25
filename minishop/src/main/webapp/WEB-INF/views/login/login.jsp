<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap"
	rel="stylesheet">
<jsp:include page="../header/header.jsp" />
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div class="header-login">
					<span id="welcome">Welcome</span><br /> <span id="text-hint">Hãy
						tạo nên phong cách cùng Minishop!</span>
				</div>
				<div class="header-bot-left">
					<p>
						<img class="icon" alt="icon-ovel" src="resources/images/oval.png"><span>Luôn
							cập nhập xu hướng mới nhất</span>
					</p>
					<p>
						<img class="icon" alt="icon-ovel" src="resources/images/oval.png"><span>Giảm
							hơn 50% tất cả các mặt hàng cho khác VIP</span>
					</p>
					<p>
						<img class="icon" alt="icon-ovel" src="resources/images/oval.png"><span>Tận
							tình tư vấn tạo nên phong cách của bạn</span>
					</p>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span id="SignIn" class="actived">Login</span> / <span id="SignUp">Registration</span>
				</div>

				<div id="container-login-right" class="container-SignIn">
					<div>
						<input id="emaildn" name="email" class="icon-email" type="email"
							placeholder="Your Email"><br /><p></p>
						<input id="matkhaudn" name="matkhau"
							class="icon-password" type="password" placeholder="Your password"><br /><p></p>
						<input id="btnsubmit" class="buttom" type="submit" value="Login"><p></p>
						<span id="kq"></span>
						<span>${email}</span>
					</div>
				</div>

				<div id="container-login-right" class="container-SignUp" style="display: none;">
					<form action="" method="post">
						<input id="email" name="email" class="icon-email" type="email"
							placeholder="Your Email"><br /><p></p>
						<input id="matkhau"
							name="matkhau" class="icon-password" type="password"
							placeholder="Your password"><br /><p></p>
						<input
							id="nhaplaimatkhau" name="nhaplaimatkhau" class="icon-password"
							type="password" placeholder="Your password Again"><br />
						<input id="btndangki" class="buttom" type="submit" value="SignUp">
						
					</form>
				</div>
 
				<div id="icon-login">
					<a href="#"><img class="icon-fb" alt="icon-ovel"
						src="resources/images/facebook.png"></a> <a href="#"><img
						class="icon-gg" alt="icon-ovel"
						src="resources/images/google-plus.png"></a>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="../header/footer.jsp" />
</body>
</html>