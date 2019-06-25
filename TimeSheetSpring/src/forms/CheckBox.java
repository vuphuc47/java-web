package forms;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CheckBox extends SimpleTagSupport {
	private String cssClass;
	private boolean checked;
	private String name;
	private Object value;
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jw = getJspContext().getOut();
		List<String> list = new LinkedList<String>();
		if(cssClass != null) {
			list.add("class=" + cssClass);
		}
		if(checked) {
			list.add("checked=\"checked\"");
		}
		if(name != null) {
			list.add("name=" + name);
		}
		if(value != null) {
			list.add("value=" + value);
		}
		String str = String.join(" ", list);
		jw.write(String.format("<input type=\"checkbox\" %s >", str));
	}
}
