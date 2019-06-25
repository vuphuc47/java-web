package controllers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import models.Category;
import models.CategoryRepository;
import models.Pair;
import models.ProductRepository;

@Controller
public class HomeController {
	CategoryRepository repository = new CategoryRepository();
	ProductRepository proRepository = new ProductRepository();

	@GetMapping("/")
	public String index(Model m) {
		List<Pair> pairs = repository.getGroup();
		/*for (Pair p : pairs) {
			System.out.println(p.getName());
			if (p.getChildren() != null) {
				for (Pair c : p.getChildren()) {
					System.out.println(c.getName());
				}
			}
		}*/
		m.addAttribute("list", pairs);

		m.addAttribute("group", repository.getGroup());
		m.addAttribute("product", proRepository.getProducts());
		return "home.index";
	}

	@GetMapping("/home/browse/{id}.html")
	public String home(@PathVariable int id, Model m) {
		List<Pair> pairs = repository.getGroup();
		m.addAttribute("list", pairs);
		m.addAttribute("list", proRepository.getProductsByCategory(id));
		m.addAttribute("group", repository.getGroup());
		return "home.browse";
	}
	
	@GetMapping("/home/detail/{id}.html")
	public String detail(@PathVariable int id, Model m) {
		m.addAttribute("o", proRepository.getProductById(id));
		return "home.detail";
	}
}
