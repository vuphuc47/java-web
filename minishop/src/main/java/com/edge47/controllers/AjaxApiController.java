package com.edge47.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edge47.entity.GioHang;
import com.edge47.service.EmployeesService;

@Controller
@RequestMapping("api/")
@SessionAttributes({ "email", "giohang" })
public class AjaxApiController {

	@Autowired
	EmployeesService employeesService;

	/*-------------------------------------------
	---------------Login----------------------
	------------------------------------------*/
	@GetMapping("xulydangnhap")
	@ResponseBody
	public String xulydangnhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelMap) {
		boolean kiemtra = employeesService.kiemtradangnhap(email, matkhau);
		modelMap.addAttribute("email", email);
		return kiemtra + "";
	}
	
	/*--------------------------------------------
	------------------Cart----------------------
	------------------------------------------=*/

	@GetMapping("themgiohang")
	@ResponseBody
	public void themgiohang(@RequestParam int masize, @RequestParam int masp, @RequestParam int mamau,
			@RequestParam String tensp, @RequestParam String giatien, @RequestParam String tenmau,
			@RequestParam String tensize, @RequestParam int soluong,@RequestParam int machitiet, HttpSession httpSession) {
		if (null == httpSession.getAttribute("giohang")) {
			List<GioHang> giohangs = new ArrayList<GioHang>();
			GioHang giohang = new GioHang();
			giohang.setGiatien(giatien);
			giohang.setMamau(mamau);
			giohang.setMasize(masize);
			giohang.setMasp(masp);
			giohang.setSoluong(1);
			giohang.setTenmau(tenmau);
			giohang.setTensize(tensize);
			giohang.setTensp(tensp);
			giohang.setMachitiet(machitiet);

			giohangs.add(giohang);
			httpSession.setAttribute("giohang", giohangs);

			List<GioHang> list = (List<GioHang>) httpSession.getAttribute("giohang");
			System.out.println(list.size() + " - " + giohangs.size());
		} else {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemtrasanphamdatontaitronggiohang(listgiohang, masp, mamau, masize);
			if (vitri == -1) {
				GioHang giohang = new GioHang();
				giohang.setGiatien(giatien);
				giohang.setMamau(mamau);
				giohang.setMasize(masize);
				giohang.setMasp(masp);
				giohang.setSoluong(1);
				giohang.setTenmau(tenmau);
				giohang.setTensize(tensize);
				giohang.setTensp(tensp);
				giohang.setMachitiet(machitiet);

				listgiohang.add(giohang);
			}else{
				
					int soluongmoi = listgiohang.get(vitri).getSoluong() +1;
					listgiohang.get(vitri).setSoluong(soluongmoi);
				
			}
		}
		
		List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
		for (GioHang gioHang : listgiohang) {
			System.out.println(gioHang.getMasp() + " - " + gioHang.getMasize() + " - " + gioHang.getTenmau() + " - "
					+ gioHang.getSoluong());
		}
	}

	private int kiemtrasanphamdatontaitronggiohang(List<GioHang> listgiohang, int masp, int mamau, int masize) {
		for (int i = 0; i < listgiohang.size(); i++) {
			if (listgiohang.get(i).getMasp() == masp && listgiohang.get(i).getMasize() == masize
					&& listgiohang.get(i).getMamau() == mamau) {
				return i;
			}
		}
		return -1;
	}
	
	/*--------------------------------------------
	-----------------cart-icon------------------
	-------------------------------------------
	*/
	
	@GetMapping("giohang")
	@ResponseBody
	public String giohang(HttpSession httpSession) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			return listgiohang.size() + "";
		}
		return "";
	}
	
	/*-----------------------------------------------
	--------------------update-cart---------------
	----------------------------------------------*/
	
	@GetMapping("capnhapsoluong")
	@ResponseBody
	public void capnhapsoluong(HttpSession httpSession,@RequestParam int masize, @RequestParam int masp, @RequestParam int mamau,
			@RequestParam String tensp,@RequestParam int soluong ) {
		if (null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemtrasanphamdatontaitronggiohang(listgiohang, masp, mamau, masize);
			listgiohang.get(vitri).setSoluong(soluong);
		}
	}
	
	/*------------------------------------------------
	----------------------delete-cart----------------
	-------------------------------------------------*/
	
	@GetMapping("xoagiohang")
	@ResponseBody
	public void xoagiohang(HttpSession httpSession, @RequestParam int masize, @RequestParam int masp, @RequestParam int mamau) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemtrasanphamdatontaitronggiohang(listgiohang, masp, mamau, masize);
			listgiohang.remove(vitri);
		}
		List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohang");
		for (GioHang gioHang : listgiohang) {
			System.out.println(gioHang.getMasp() + " - " + gioHang.getMasize() + " - " + gioHang.getTenmau() + " - "
					+ gioHang.getSoluong());
		}
	}
}
