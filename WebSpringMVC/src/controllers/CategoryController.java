package controllers;

import javax.annotation.Generated;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.Category;
import models.CategoryRepository;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	CategoryRepository repository = new CategoryRepository();

	@PostMapping("/category/delete.html")
	public String delete(String[] arr) {
		repository.delete(arr);
		return "redirect:/admin/category.html";
	}

	@GetMapping("/category.html")
	public String index(Model m) {
		m.addAttribute("list", repository.getCategories());
		return "category.index";
	}

	@GetMapping("/category/add.html")
	public String add(Model m) {
		m.addAttribute("group", repository.getGroup());
		m.addAttribute("list", repository.getCategories());
		m.addAttribute("o", new Category());
		return "category.add";
	}

	@PostMapping("/category/add.html")
	public String add(Category obj) {
		repository.add(obj);
		return "redirect:/admin/category.html";
	}

	@GetMapping("/category/delete/{id}.html")
	public String delete(@PathVariable int id) {
		repository.delete(id);
		return "redirect:/admin/category.html";
	}

	@GetMapping("/category/edit/{id}.html")
	public String edit(@PathVariable int id, Model m) {
		m.addAttribute("o", repository.getCategoryById(id));
		m.addAttribute("list", repository.getCategories());
		return "category.edit";
	}

	@PostMapping("/category/edit/{id}.html")
	public String edit(Category obj) {
		repository.edit(obj);
		return "redirect:/admin/category.html";
	}
}
