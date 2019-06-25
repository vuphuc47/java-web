$(document).ready(function(){
	$("#SignIn").click(function(){
		$(this).addClass("actived");
		$("#SignUp").removeClass("actived");
		$(".container-SignIn").show();
		$(".container-SignUp").hide();
	});
	
	$("#SignUp").click(function(){
		$(this).addClass("actived");
		$("#Sig nIn").removeClass("actived");
		$(".container-SignIn").hide();
		$(".container-SignUp").show();
	});
	
	$("#btnsubmit").click(function(){
		var ten = $("#emaildn").val();
		var pw = $("#matkhaudn").val();
		$.ajax({
			url:"/minishop/api/xulydangnhap",
			type:"GET",
			data:{
				email: ten,
				matkhau: pw
			},
			success: function(value){
				if(value == "true"){
					$("#kq").append("đăng nhập thành công!")
				}else{
					$("#kq").append("đăng nhập thất bại!")
				}
			}
		})
	});
	
	$(".btn-giohang").click(function(){
		var machitiet = $(this).attr("data-machitiet")
		var tenmau = $(this).closest("tr").find(".mau").text();
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		
		var size = $(this).closest("tr").find(".size").text();
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		
		var tensp = $("#tensp").text();
		var masp = $("#tensp").attr("data-masp");
		var giatien = $("#giatien").attr("data-price");
		
		var soluong = $(this).closest("tr").find(".soluong").text();
		
		$.ajax({
			url:"/minishop/api/themgiohang",
			type:"GET",
			data:{
				masize:masize,
				masp:masp,
				mamau:mamau,
				tensp:tensp,
				giatien:giatien,
				tenmau:tenmau,
				tensize:size,
				soluong:soluong,
				machitiet: machitiet
			},
			success: function(value){
				
			}
		}).done(function(){
			$.ajax({
				url:"/minishop/api/giohang",
				type:"GET",
				success: function(value){
					$(".circle-giohang").html("<span>"+value+"</span>");
				}
			})
		});
	});
	
	gantongtiengiohang();
	
	function gantongtiengiohang(isEvenChange){
		var tongtiensp = 0;
		$(".giatien").each(function(){
			var giatien = $(this).attr("data-value");
			var soluong = $(this).closest("tr").find(".soluong-sanpham").val();
			
			var tongtien = parseInt(giatien) * soluong;
			var format = parseFloat(tongtien).toFixed(0).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
			$(this).html(format);
			if(isEvenChange){
				$(this).html(format);
			}
			
			tongtiensp = tongtiensp + tongtien;
			var formattongtien = tongtiensp.toFixed(0).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
			$("#tongtien").html(formattongtien+"")
		})
	}
	
	$(".soluong-sanpham").change(function(){
		var soluong = $(this).val();
		var giatien = $(this).closest("tr").find(".giatien").attr("data-value");
		
		var tongtien = soluong * parseInt(giatien);
		var format = tongtien.toFixed(0).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
		$(this).closest("tr").find(".giatien").html(format);
		gantongtiengiohang(true);
		
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");
		var tensp = $(this).closest("tr").find(".tensp").text();
		$.ajax({
			url:"/minishop/api/themgiohang",
			type:"GET",
			data:{
				masize:masize,
				masp:masp,
				mamau:mamau,
				tensp:tensp,
				soluong:soluong
			},
			success: function(value){
				
			}
		})
	});
	
	$(".xoa-giohang").click(function(){
		var self = $(this);
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensp").attr("data-masp");
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		$.ajax({
			url:"/minishop/api/xoagiohang",
			type:"GET",
			data:{
				masize: masize,
				masp: masp,
				mamau: mamau
			}, success: function(value){
				self.closest("tr").remove();
				gantongtiengiohang();
			}
		})
	})
})