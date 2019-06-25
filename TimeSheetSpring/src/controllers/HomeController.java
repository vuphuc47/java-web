package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import models.EmployeeRepository;
import models.Work;

@Controller
public class HomeController {
	EmployeeRepository repository = new EmployeeRepository();
	@RequestMapping("/")
	public String index(Model m) {
		Date start = null;
		Date end = null;
		String[] dates = new String[7];
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		start =  calendar.getTime();
		
		for (int i = 0; i < 7; i++) {
			end = calendar.getTime();
			dates[i] = df.format(end);
			calendar.add(Calendar.DAY_OF_WEEK, 1);
		}
		
		m.addAttribute("dates", dates);
		m.addAttribute("gender", new String[] {"Male", "Female"});
		m.addAttribute("list", repository.getEmployees(start, end));
		
		return "home/index";
	}
	
	
}
