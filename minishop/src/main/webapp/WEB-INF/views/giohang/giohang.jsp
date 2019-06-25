<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div id="header2" class="container-fluid">
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
						<li class="active animal"><a href="#">HOME<span
								class="sr-only">(current)</span></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">One more separated link</a></li>
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
						<li><a href="login.html">Login</a></li>
						<li><a href="#"><img alt="cart"
								src='<c:url value="/resources/images/cart.ico"/>'><span
								class="circle-giohang" style="color: red;">${soluong }</span></a></li>
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
	</div>

	<!--//////////////////BODY//////////////////////  -->
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-6">
				<table class="table">
					<thead>
						<tr>
							<td><h5>Tên sản phẩm</h5></td>
							<td><h5>Màu sản phẩm</h5></td>
							<td><h5>Size</h5></td>
							<td><h5>Số Lượng</h5></td>
							<td><h5>Giá</h5></td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="o" items="${giohang }">
							<tr data-machitiet="${o.getMachitiet() }">
								<td class="tensp" data-masp="${o.getMasp() }">${o.getTensp() }</td>
								<td class="mau" data-mamau="${o.getMamau() }">${o.getTenmau() }</td>
								<td class="size" data-masize="${o.getMasize() }">${o.getTensize() }</td>
								<td class="soluong"><input class="soluong-sanpham" type="number" min="1" value="${o.getSoluong() }"></td>
								<td class="giatien" data-value="${o.getGiatien() }">${o.getGiatien() }</td>
								<td class="xoa-giohang btn btn-danger">xóa</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h4 >Tổng tiền: <span id="tongtien" style="color: red"></span> </h4>
			</div>

			<div class="col-md-6 col-sm-12">
				<h3>Tông tin người mua</h3>

				<div class="form-group">
					<form action="" method="post">
						<label for="tenkhachhang">Tên người mua nhận</label> 
						<input name="tenkhachhang"  class="form-control" id="tenkhachhang"> 
						
						<label for="sdt">Điện thoại liên lạc</label> 
						<input name="sdt" class="form-control" id="sdt">
						
						<div class="radio">
							<label><input type="radio" name="hinhthucgiaohang" value="Giao hàng tận nơi" checked>Giao hàng tận nơi</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="hinhthucgiaohang" value="Nhận hàng tại cửa hàng">Nhận hàng tại cửa hàng</label>
						</div>
						
						<label for="diachigiaohang">Địa chỉ nhận hàng</label>
						<input name="diachigiaohang" class="form-control" id="diachigiaohang">
						
						<label for="ghichu">Ghi chú:</label>
						<textarea name="ghichu" class="form-control" rows="5" id="ghichu"></textarea><br/>
						
						<input type="submit" class="btn btn-primary" value="Đặt hàng">
					</form>
				</div>
			</div>
		</div>
	</div>





	<!-- --------------FOOTER--------------------- -->
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-sm-4 wow swing">
				<p>
					<span class="titler-footer">THÔNG TIN SHOP</span>
				</p>
				<span>Yame là một thương hiệu thời trang uy tín, luôn đảm bảo
					chất lượng sản phẩm tốt nhất cho khách hàng</span>
			</div>

			<div class="col-md-4 col-sm-4 wow swing">
				<p>
					<span class="titler-footer">LIÊN HỆ</span>
				</p>
				<span>43 Nguyễn Trỗi, phường 12, quận 5 TP. HỒ CHÍ MINH</span><br />
				<span>vuphucegg47@gmail.com</span><br /> <span>0971467996</span>
			</div>

			<div class="col-md-4 col-sm-4 wow swing">
				<p>
					<span class="titler-footer">GÓP Ý</span>
				</p>
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
