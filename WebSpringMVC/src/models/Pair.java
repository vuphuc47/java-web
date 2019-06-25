package models;

import java.util.List;

public interface Pair {
	public Integer getId();

	public String getName();

	public void setChildren(List<Pair> children);

	public List<Pair> getChildren();
}
