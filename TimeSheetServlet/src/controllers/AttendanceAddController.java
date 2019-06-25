package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Attendance;
import models.AttendanceRepository;
import models.Student;

@WebServlet("/attendance/add.html")
public class AttendanceAddController extends BaseController {
	AttendanceRepository repository = new AttendanceRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date d = df.parse(req.getParameter("d"));

			Attendance obj = new Attendance(id, d);
			int ret = repository.addAttendance(obj);

			pw.write(String.valueOf(ret));
		} catch (ParseException e) {
			e.printStackTrace();
			pw.write("0");
		}

	}
}
