package com.edge47.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edge47.entity.DanhMucSanPham;
import com.edge47.entity.GioHang;
import com.edge47.entity.SanPham;
import com.edge47.service.DanhMucService;
import com.edge47.service.SanPhamService;

@Controller
@RequestMapping("/")
@SessionAttributes("email")
public class HomeController {
	
	@Autowired
	SanPhamService sanphamservice;
	
	@Autowired
	DanhMucService danhmucservice;
	
	@GetMapping
	public String home(ModelMap modelMap, HttpSession httpSession) {
		
		List<DanhMucSanPham> laydanhmuc = danhmucservice.laydanhmuc();
		modelMap.addAttribute("danhmuc", laydanhmuc);
		
		List<SanPham> list = sanphamservice.danhsachsanpham(1);
		modelMap.addAttribute("list", list);
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> giohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluong", giohang.size());
		}
		
		return "home/home";
	}
}
