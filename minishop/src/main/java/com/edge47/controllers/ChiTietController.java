package com.edge47.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edge47.entity.DanhMucSanPham;
import com.edge47.entity.GioHang;
import com.edge47.entity.SanPham;
import com.edge47.service.DanhMucService;
import com.edge47.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")
public class ChiTietController {
	
	@Autowired
	SanPhamService sanphamservice;
	
	@Autowired
	DanhMucService danhmucservice;

	@GetMapping("/{masanpham}")
	public String chitiet(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
		SanPham sanPham = sanphamservice.chitietsanpham(masanpham);
		List<DanhMucSanPham> laydanhmuc = danhmucservice.laydanhmuc();
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> giohang = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluong", giohang.size());
		}
		
		modelMap.addAttribute("chitietsanpham", sanPham);
		modelMap.addAttribute("danhmuc", laydanhmuc);
		return "chitiet/chitiet";
	}
	
}
