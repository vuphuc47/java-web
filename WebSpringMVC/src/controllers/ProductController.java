package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import models.CategoryRepository;
import models.Product;
import models.ProductRepository;

@Controller
@RequestMapping("/admin")
public class ProductController {
	ProductRepository product = new ProductRepository();
	CategoryRepository category = new CategoryRepository();

	@GetMapping("/product.html")
	public String index(Model m) {
		m.addAttribute("list", product.getProducts());
		return "product/index";
	}

	@GetMapping("/product/add.html")
	public String add(Model m) {
		m.addAttribute("list", category.getCategories());
		m.addAttribute("o", new Product());
		return "product/add";
	}

	@PostMapping("/product/add.html")
	public String add(Product obj, MultipartFile file, HttpServletRequest req) {
		String path = req.getServletContext().getRealPath("/upload/");

		try {
			file.transferTo(new File(path + file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try { InputStream is = file.getInputStream(); FileOutputStream fos = new
		 * FileOutputStream(path + file.getOriginalFilename()); byte[] bytes = new
		 * byte[1024]; int len = is.read(bytes, 0, 1024); while (len > 0) {
		 * fos.write(bytes, 0, len); len = is.read(bytes, 0, 1024); } fos.close();
		 * is.close(); } catch (IOException e) { e.printStackTrace(); }
		 */

		System.out.println(file.getOriginalFilename());

		obj.setImageUrl(file.getOriginalFilename());
		product.add(obj);
		return "redirect:/product.html";
	}

	@GetMapping("/product/delete/{id}.html")
	public String delete(@PathVariable int id) {
		product.delete(id);
		return "redirect:/product.html";
	}

	@GetMapping("/product/edit/{id}.html")
	public String edit(@PathVariable int id, Model m) {
		m.addAttribute("list", category.getCategories());
		m.addAttribute("o", product.getProductById(id));
		return "product/edit";
	}

	@PostMapping("/product/edit/{id}.html")
	public String edit(Product obj, MultipartFile file, HttpServletRequest req) {
		if (file != null && !file.getOriginalFilename().isEmpty()) {
			String path = req.getServletContext().getRealPath("/upload/");
			try {
				file.transferTo(new File(path + file.getOriginalFilename()));
				obj.setImageUrl(file.getOriginalFilename());
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		product.edit(obj);
		return "redirect:/product.html";
	}
}
