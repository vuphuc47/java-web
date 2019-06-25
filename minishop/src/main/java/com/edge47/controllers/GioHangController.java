package com.edge47.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edge47.entity.ChiTietHoaDon;
import com.edge47.entity.GioHang;
import com.edge47.entity.HoaDon;
import com.edge47.entity.IdChiTietHoaDon;
import com.edge47.service.ChiTietHoaDonService;
import com.edge47.service.HoaDonService;

@Controller
@RequestMapping("/giohang")
public class GioHangController {

	@Autowired
	HoaDonService hoadonservice;
	
	@Autowired
	ChiTietHoaDonService chitiethoadonservice;

	@GetMapping
	public String giohang(HttpSession httpSession, ModelMap modelMap) {

		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> giohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluong", giohang.size());
			modelMap.addAttribute("giohang", giohang);
		}
		return "giohang/giohang";
	}

	@PostMapping
	public String themhoadon(HttpSession httpSession, @RequestParam String tenkhachhang, @RequestParam String sdt,
			@RequestParam String diachigiaohang, @RequestParam String hinhthucgiaohang, @RequestParam String ghichu) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> giohang = (List<GioHang>) httpSession.getAttribute("giohang");
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenkhachhang);
			hoaDon.setSdt(sdt);
			hoaDon.setDiachigiaohang(diachigiaohang);
			hoaDon.setHinhthucgiaohang(hinhthucgiaohang);
			hoaDon.setGhichu(ghichu);
			
			int idhoadon = hoadonservice.themhoadon(hoaDon);
			if(idhoadon > 0) {
				Set<ChiTietHoaDon> chiTietHoaDons = new HashSet<ChiTietHoaDon>();
				for (GioHang gioHang2 : giohang) {
				IdChiTietHoaDon idChiTietHoaDon = new IdChiTietHoaDon();
				idChiTietHoaDon.setMachitietsanpham(gioHang2.getMachitiet());
				idChiTietHoaDon.setMahoadon(hoaDon.getMahoadon());
				
				ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
				chiTietHoaDon.setChiTietHoaDon(idChiTietHoaDon);
				chiTietHoaDon.setGiatien(gioHang2.getGiatien().toString());
				chiTietHoaDon.setSoluong(gioHang2.getSoluong());
					
				chitiethoadonservice.themchitiethoadon(chiTietHoaDon);
				}
			}
		}
		return "giohang/giohang";
	}
}
