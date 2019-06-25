package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CartRepository extends BaseRepository {
	public int add(Cart obj) {
		return jdbc.update("{CALL AddCart(?, ?, ?)}", obj.getToken(), obj.getProductId(), obj.getQuantity());
	}

	public List<Cart> getCarts(String token) {
		String sql = "SELECT cart.*, ProductName, ImageUrl FROM cart INNER JOIN product ON cart.ProductId = product.ProductId WHERE Token = ?";
		return jdbc.query(sql, new RowMapper<Cart>() {

			@Override
			public Cart mapRow(ResultSet rs, int index) throws SQLException {
				return new Cart(rs.getInt("CartId"), rs.getString("Token"), rs.getInt("ProductId"),
						rs.getString("ProductName"), rs.getString("ImageUrl"), rs.getInt("Quantity"),
						rs.getInt("Price"), rs.getDate("AddedDate"));
			}

		}, token);
	}

	public int delete(int id) {
		return jdbc.update("DELETE FROM cart WHERE CartId = ?", id);
	}
	
	public int edit(int id, int quantity) {
		return jdbc.update("UPDATE cart SET Quantity = ? WHERE CartId = ?", quantity, id);
	}
}
