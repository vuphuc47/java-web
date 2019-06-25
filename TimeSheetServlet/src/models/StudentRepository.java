package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudentRepository extends BaseRepository {
	private Student fetch(ResultSet rs) throws SQLException {
		return new Student(rs.getInt("StudentId"), rs.getString("FirstName"), rs.getString("LastName"),
				rs.getByte("Gender"), rs.getDate("DateOfBirth"), rs.getString("PlaceOfBirth"), rs.getString("Subject"));
	}

	public List<Student> getStudents(Date start, Date end) {
		Map<Integer, Boolean[]> map = getTimeSheet(start, end);
		open();
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("{CALL GetStudents()}");
			List<Student> list = new ArrayList<Student>();
			while (rs.next()) {
				Student obj = fetch(rs);
				obj.setTimeSheet(map.get(obj.getId()));
				list.add(obj);
			}
			st.close();
			rs.close();
			connection.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<Integer, Boolean[]> getTimeSheet(Date start, Date end) {
		open();
		try {
			PreparedStatement ps = connection.prepareStatement("{CALL GetTimeSheet(?, ?)}");
			ps.setDate(1, to(start));
			ps.setDate(2, to(end));
			ResultSet rs = ps.executeQuery();
			Map<Integer, Boolean[]> map = new HashMap<Integer, Boolean[]>();
			while (rs.next()) {
				int key = rs.getInt("StudentId");
				if (!map.containsKey(key)) {
					map.put(key, new Boolean[7]);
				}
				int day = (rs.getInt("Day") + 5) % 7;
				map.get(key)[day] = true;
			}
			rs.close();
			ps.close();
			connection.close();
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
