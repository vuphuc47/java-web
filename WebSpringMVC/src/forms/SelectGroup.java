package forms;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import models.Pair;

public class SelectGroup extends SimpleTagSupport {
	private String name;
	private List<Pair> items;

	public void setName(String name) {
		this.name = name;
	}

	public void setItems(List<Pair> items) {
		this.items = items;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jw = getJspContext().getOut();
		jw.write(String.format("<select name=\"%s\">", name));

		for (Pair item : items) {
			jw.write(String.format("<optgroup label=\"%s\">", item.getName()));
			if (item.getChildren() != null) {
				for (Pair pair : item.getChildren()) {
					jw.write(String.format("<option value=\"%d\">%s</option>", pair.getId(), pair.getName()));
				}
			}
			jw.write("</optgroup>");
		}
		
		jw.write("</select>");
	}
}
