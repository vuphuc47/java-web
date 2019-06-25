package models;

import java.util.List;

public class Product implements Pair {
	private Integer id;
	private int categoryId;
	private String categoryName;
	private String productName;
	private int price;
	private int quantity;
	private String imageUrl;
	private String description;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, int categoryId, String productName, int price, int quantity, String imageUrl,
			String description) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public Product(Integer id, int categoryId, String categoryName, String productName, int price, int quantity,
			String imageUrl, String description) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setChildren(List<Pair> children) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pair> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

}
