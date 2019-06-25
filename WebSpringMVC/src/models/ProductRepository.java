package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

public class ProductRepository extends BaseRepository {
	private static Product fetch(ResultSet rs) throws SQLException {
		return new Product(rs.getInt("ProductId"), rs.getInt("CategoryId"), rs.getString("CategoryName"),
				rs.getString("ProductName"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getString("ImageUrl"),
				rs.getString("Description"));
	}
	
	public List<Product> getProductsByCategory(int id) {
		return jdbc.query("SELECT * FROM product INNER JOIN category ON product.ProductId = category.CategoryId WHERE product.CategoryId = ?",
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int index) throws SQLException {
						return fetch(rs);
					}
				}, id);
	}
	

	public List<Product> getProducts() {
		return jdbc.query("SELECT * FROM product INNER JOIN category ON product.ProductId = category.CategoryId",
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int index) throws SQLException {
						return fetch(rs);
					}
				});
	}

	public int add(Product obj) {
		String sql = "INSERT INTO product (CategoryId, ProductName, Price, Quantity, ImageUrl, Description) VALUES (?, ?, ?, ?, ?, ?)";
		return jdbc.update(sql, obj.getCategoryId(), obj.getProductName(), obj.getPrice(), obj.getQuantity(),
				obj.getImageUrl(), obj.getDescription());
	}

	public int delete(int id) {
		return jdbc.update("DELETE FROM product WHERE ProductId = ?", id);
	}

	public Product getProductById(int id) {
		String sql = "SELECT * FROM product INNER JOIN category ON product.ProductId = category.CategoryId WHERE ProductId = ?";

		return jdbc.queryForObject(sql, (rs, index) -> fetch(rs), id);

		/*
		 * return jdbc.queryForObject(sql, new RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int index) throws SQLException
		 * { return fetch(rs); }
		 * 
		 * }, id);
		 */
	}

	public int edit(Product obj) {
		return jdbc.update(
				"UPDATE product SET CategoryId = ?, ProductName = ?, Price = ?, Quantity = ?, ImageUrl = ?, Description = ? WHERE ProductId = ? ",
				obj.getCategoryId(), obj.getProductName(), obj.getPrice(), obj.getQuantity(), obj.getImageUrl(),
				obj.getDescription(), obj.getId());
	}
}
