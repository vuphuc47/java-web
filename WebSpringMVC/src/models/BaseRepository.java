package models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseRepository {
	final protected JdbcTemplate jdbc;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public BaseRepository() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf-8", "root", "");
		jdbc = new JdbcTemplate(dataSource);
	}
	
	protected static String bCript(String text) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(text);
	}
}
