package com.edge47.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edge47.entity.SanPham;
import com.edge47.service.SanPhamService;

@Controller
@RequestMapping("/themsp")
public class ThemSPController {
	
	@Autowired
	SanPhamService sanphamservice;
	
	@GetMapping
	public String defaut(ModelMap modelMap) {
		List<SanPham> listsanpham = sanphamservice.danhsachsanpham(0);
		List<SanPham> allsanpham = sanphamservice.danhsachsanpham(-1);
		double tongpage = Math.ceil((double) allsanpham.size()/12);
		modelMap.addAttribute("listsp", listsanpham);
		modelMap.addAttribute("allsanpham", allsanpham);
		modelMap.addAttribute("tongpage", tongpage);
		return "themsanpham/themsp";
	}
}
