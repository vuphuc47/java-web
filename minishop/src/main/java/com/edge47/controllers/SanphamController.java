package com.edge47.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edge47.entity.DanhMucSanPham;
import com.edge47.entity.SanPham;
import com.edge47.service.DanhMucService;
import com.edge47.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanphamController {
	
	@Autowired
	DanhMucService danhmucservice;
	
	@Autowired
	SanPhamService sanphamservice;
	
	@GetMapping("/{madanhmuc}/{tendanhmuc}")
	public String defaut(@PathVariable int madanhmuc,@PathVariable String tendanhmuc,ModelMap modelMap) {
		List<DanhMucSanPham> laydanhmuc = danhmucservice.laydanhmuc();
		List<SanPham> listsanpham = sanphamservice.laydanhsachsptheoid(madanhmuc);
		
		modelMap.addAttribute("danhmuc", laydanhmuc);
		modelMap.addAttribute("tendanhmuc", tendanhmuc);
		modelMap.addAttribute("list", listsanpham);
		return "sanpham/sanpham";
	}
}
