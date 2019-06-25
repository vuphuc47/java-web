package models;

import java.util.Date;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRepository extends BaseRepository {
	private static Employee fetch(ResultSet rs) throws SQLException {
		return new Employee(rs.getInt("EmployeeId"), rs.getInt("DepartmentId"), rs.getString("DepartmentName"),
				rs.getString("FullName"), rs.getDate("DateOfBirth"), rs.getByte("Gender"));

	}

	public Map<Integer, Boolean[]> getTimeSheet(Date start, Date end) {
		return jdbc.query("{CALL GetTimesheetsOnWeek(?, ?)}", new ResultSetExtractor<Map<Integer, Boolean[]>>() {

			@Override
			public Map<Integer, Boolean[]> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Map<Integer, Boolean[]> map = new HashMap<Integer, Boolean[]>();
				while (rs.next()) {
					int key = rs.getInt("EmployeeID");
					if (!map.containsKey(key)) {
						map.put(key, new Boolean[7]);
					}
					int day = (rs.getInt("Day") + 5) % 7;
					map.get(key)[day] = true;
				}
				return map;
			}

		}, start, end);
	}

	public List<Employee> getEmployees(Date start, Date end) {
		Map<Integer, Boolean[]> map = getTimeSheet(start, end);
		return jdbc.query("{CALL GetEmployees}", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int index) throws SQLException {
				Employee obj = fetch(rs);
				obj.setTimesheet(map.get(obj.getId()));
				return obj;
			}

		});

	}
}