package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Work;
import models.WorkRepository;

@Controller
public class WorkController {
	WorkRepository repository = new WorkRepository();
	@PostMapping("/work/add.html")
	public @ResponseBody String add(int id, String d) {
		
		Date dated;
		int ret = 0;
		try {
			dated = new SimpleDateFormat("dd/MM/yyyy").parse(d);
			Work obj = new Work(id, dated);
			ret = repository.add(obj);
			
		} catch (ParseException e) {
			e.printStackTrace();
			return "0";
		}
		return String.valueOf(ret);
	}
}
