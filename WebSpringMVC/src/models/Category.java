package models;

import java.util.List;

public class Category implements Pair{
	private Integer id;
	private String name;
	private Integer parent;
	private String parentName;
	private List<Pair> children;

	

	public List<Pair> getChildren() {
		return children;
	}

	public void setChildren(List<Pair> children) {
		this.children = children;
	}

	public Category() {
		super();
	}

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(Integer id, String name, Integer parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}

	public Category(Integer id, String name, Integer parent, String parentName) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.parentName = parentName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
