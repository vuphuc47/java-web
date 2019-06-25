package models;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class BaseRepository {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected JdbcTemplate jdbc;
	public BaseRepository() {
		DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/hr?useUnicode=true&characterEncoding=utf-8", "root", "");
		jdbc = new JdbcTemplate(dataSource);
	}
}
