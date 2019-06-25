package models;

import java.util.Date;

public class Cart {
	private Integer id;
	private String token;
	private int productId;
	private String productName;
	private String imageUrl;
	private int quantity;
	private int price;
	private Date dated;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(String token, int productId, int quantity, int price) {
		super();
		this.token = token;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public Cart(Integer id, String token, int productId, String productName, String imageUrl, int quantity, int price,
			Date dated) {
		super();
		this.id = id;
		this.token = token;
		this.productId = productId;
		this.productName = productName;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.price = price;
		this.dated = dated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}
}
