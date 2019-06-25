package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class CategoryRepository extends BaseRepository {
	/*
	 * public List<Category> getCategories(){ return
	 * jdbc.query("SELECT * FROM Category", new RowMapper<Category>() {
	 * 
	 * @Override public Category mapRow(ResultSet rs, int index) throws
	 * SQLException{ return new Category(rs.getInt("CategoryId"),
	 * rs.getString("CategoryName")); } }); }
	 */

	public List<Category> getParents() {
		return jdbc.query("SELECT * FROM  Category WHERE ParentId IS NULL", new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int index) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
			}

		});

	}

	public Map<Integer, List<Category>> getChildren() {
		String sql = "SELECT * FROM Category WHERE ParentId IS NOT NULL";
		return jdbc.query(sql, new ResultSetExtractor<Map<Integer, List<Category>>>() {

			@Override
			public Map<Integer, List<Category>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<Integer, List<Category>> map = new HashMap<Integer, List<Category>>();
				while (rs.next()) {
					Integer key = rs.getInt("ParentId");
					if (!map.containsKey(key)) {
						map.put(key, new ArrayList<Category>());
					}
					map.get(key).add(new Category(rs.getInt("CategoryId"), rs.getString("CategoryName")));
				}
				return map;
			}

		});
	}

	public int delete(String[] arr) {
		String sql = String.format("DELETE FROM Category WHERE CategoryId IN(%s)", String.join(",", arr));
		return jdbc.update(sql);
	}

	public List<Category> getCategories() {
		String sql = "{CALL GetCategories()}";
		return jdbc.query(sql, (rs, index) -> new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"),
				(Integer) rs.getObject("ParentId"), rs.getString("ParentName")));
		// return jdbc.query(sql,(rs,index) -> new Category(rs.getInt("CategoryId"),
		// rs.getString("CategoryName"), rs.getInt("ParentId")));
	}

	public int[] delete(int[] arr) {
		String sql = " DELETE FROM Category WHERE CategoryId = ?";
		return jdbc.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt, int index) throws SQLException {
				pstmt.setInt(1, arr[index]);
			}

			@Override
			public int getBatchSize() {

				return arr.length;
			}
		});
	}

	public int add(Category obj) {
		return jdbc.update("INSERT INTO Category(CategoryName, ParentId) VALUE (?, ?)", obj.getName(), obj.getParent());
	}

	public int delete(int id) {
		return jdbc.update("DELETE FROM Category WHERE CategoryId = ?", id);
	}

	public int edit(Category obj) {
		return jdbc.update("UPDATE Category SET CategoryName = ?, ParentId = ? WHERE CategoryId = ?", obj.getName(),
				obj.getParent(), obj.getId());
	}

	public Category getCategoryById(int id) {
		return jdbc.queryForObject("SELECT * FROM Category WHERE CategoryId = ?", new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int index) throws SQLException {
				return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"),
						(Integer) rs.getInt("ParentId"));

			}
		}, id);
	}

	public List<Pair> getGroup() {
		String sql = "SELECT * FROM category";
		return jdbc.query(sql, new ResultSetExtractor<List<Pair>>() {

			@Override
			public List<Pair> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
				List<Pair> parents = new ArrayList<Pair>();
				while (rs.next()) {
					Object key = rs.getObject("ParentId");
					Pair obj = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					if (key == null) {
						parents.add(obj);
					} else {
						if (!map.containsKey(key)) {
							map.put((Integer) key, new ArrayList<Pair>());
						}
						map.get(key).add(obj);
					}
				}
				for (Pair p : parents) {
					p.setChildren(map.get(p.getId()));
				}
				return parents;
			}

		});
	}
}
