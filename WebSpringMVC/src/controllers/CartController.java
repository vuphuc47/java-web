package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Cart;
import models.CartRepository;
import util.Helper;

@Controller
public class CartController {
	CartRepository cart = new CartRepository();

	private static String getToken(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		String token = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cart")) {
				token = cookie.getValue();
			}
		}
		if (token == null) {
			token = Helper.randomString(32);
			Cookie cookie = new Cookie("cart", token);
			cookie.setPath(req.getContextPath());
			cookie.setMaxAge(3600 * 24 * 30);
			resp.addCookie(cookie);
		}
		return token;
	}

	@GetMapping("/cart.html")
	public String index(Model m, HttpServletRequest req, HttpServletResponse resp) {
		m.addAttribute("list", cart.getCarts(getToken(req, resp)));
		return "cart.index";
	}

	@PostMapping("/cart/add.html")
	public String add(Cart obj, HttpServletRequest req, HttpServletResponse resp) {
		obj.setToken(getToken(req, resp));
		cart.add(obj);
		return "redirect:/admin/cart.html";
	}

	@GetMapping("/cart/delete/{id}.html")
	public String delete(@PathVariable int id) {
		cart.delete(id);
		return "redirect:/admin/cart.html";
	}

	@PostMapping("/cart/edit.html")
	public @ResponseBody String edit(int id, int quantity) {
		return String.valueOf(cart.edit(id, quantity));
	}
}
