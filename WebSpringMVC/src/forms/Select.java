package forms;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import models.Category;
import models.Pair;

public class Select extends SimpleTagSupport {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	private List<Pair> items;

	public void setItems(List<Pair> items) {
		this.items = items;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jw = getJspContext().getOut();
		jw.write(String.format("<select name=\"%s\">", name));
		for (Pair item : items) {
			jw.write(String.format("<option value=\"%d\">%s</option>", item.getId(), item.getName()));
		}
		jw.write("</select>");
	}
}
