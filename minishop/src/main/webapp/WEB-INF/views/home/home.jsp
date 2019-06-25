<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<jsp:include page="../header/header.jsp" />

</head>
<body>

<!-- --------------HEADER----------------- -->
	<div id="header" class="container-fluid">
		<nav class="navbar navbar-default none-nav">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/minishop/">YameShop</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-center">
						<!-- <li class="active"><a href="#">HOME<span class="sr-only">(current)</span></a></li> -->
						<li class="active animal"><a href="#">HOME<span class="sr-only">(current)</span></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">PRODUCT <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<c:forEach var="o" items="${danhmuc }">
									<li role="separator" class="divider"></li>
									<li><a href="sanpham/${o.getMadanhmuc() }/${o.getTendanhmuc() }">${o.getTendanhmuc() }</a></li>
								</c:forEach>
							</ul></li>
						<li class="animal"><a href="#">SERVICE</a></li>
						<li class="animal"><a href="#">CONTACT</a></li>
					</ul>
					<!-- <form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form> -->
					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${email != null }">
								<li><a href="login.html">${email }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="login.html">Login</a></li>
							</c:otherwise>
						</c:choose>
						
						<li><a href="giohang"><img alt="cart" src='<c:url value="/resources/images/cart.ico"/>'><span class="circle-giohang" style="color: red;">${soluong }</span></a></li>
						<!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li> -->
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="even-header container wow swing">
			<span>Ngày 17/06/2019 - 20/06/2019</span><br/>
			<span style="">Mua 1 tặng 1</span><br/>
			<button>Xem ngay</button>
		</div>
	</div>

	<div id="info" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow fadeInLeft" data-wow-duration="2s">
				<img class="icon-info" alt="icon-chatluong" src='<c:url value="/resources/images/tm2.png" />'><br/>
				<span style="font-size: 32px; font-weight: 500">CHẤT LƯỢNG</span><br/>
				<span>Chúng tôi cam kết mang đến cho các bạn sản phẩm tốt nhất</span>
			</div>
			<div class="col-sm-4 col-md-4 wow fadeInDown" data-wow-duration="2s" data-wow-delay="2s">
				<img class="icon-info" alt="icon-chatluong" src='<c:url value="/resources/images/tm1.png" />'><br/>
				<span style="font-size: 32px; font-weight: 500">GIAO HÀNG</span><br/>
				<span>Cam kết giao hàng tận nơi trong ngày, nhằm mang đến trải nghiệm tốt nhất cho khách hàng</span>
			</div>
			<div class="col-sm-4 col-md-4 wow fadeInRight" data-wow-duration="2s" data-wow-delay="4s">
				<img class="icon-info" alt="icon-chatluong" src='<c:url value="/resources/images/tm3.png" />'><br/>
				<span style="font-size: 32px; font-weight: 500">HỖ TRỢ MUA HÀNG</span><br/>
				<span>Tư vấn tận tình, hỗ trợ đổi trả hàng</span>
			</div>
		</div>
	</div>
	
	<!-- ---------------PRODUCT------------ -->
	
	<div id="title-product" class="container">
		<span>SẢN PHẨM HOT</span>
		
		<div class="row">
			
			<c:forEach var="o" items="${list}">
				<div class="col-md-3 col-sm-6 wow zoomIn">
					<a href="chitiet/${o.getMasanpham()}">
						<div class="product">
							<img alt="icon-product" src='<c:url value="/resources/sanphamimg/${o.getHinhsanpham()}"/>'><br/>
							<span>${o.getTensanpham()}</span><br/>
							<span class="price">${o.getGiatien()} VND</span>
						</div>
					</a>
				</div>
			</c:forEach>
			<!-- <div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
	
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6 wow zoomIn">
				<div class="product">
					<img alt="icon-product" src='<c:url value="/resources/images/product.png"/>'><br/>
					<span>Áo sơ mi</span><br/>
					<span class="price">150.000 VND</span>
				</div>
			</div> -->
		</div>
	</div>

	<!-- --------------FOOTER--------------------- -->
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-sm-4 wow swing">
				<p><span class="titler-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>
				
			<div class="col-md-4 col-sm-4 wow swing">
				<p><span class="titler-footer">LIÊN HỆ</span></p>
				<span>43 Nguyễn Trỗi, phường 12, quận 5 TP. HỒ CHÍ MINH</span><br/>
				<span>vuphucegg47@gmail.com</span><br/>
				<span>0971467996</span>
			</div>
			
			<div class="col-md-4 col-sm-4 wow swing">
				<p><span class="titler-footer">GÓP Ý</span></p>
				<form action="">
					<input type="email" placeholder="Your Email">
					<textarea rows="5" cols="50" placeholder="Content"></textarea>
					<input type="submit" value="OK">
					</form>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../header/footer.jsp" />
</html>