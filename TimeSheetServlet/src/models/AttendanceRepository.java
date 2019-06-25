package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceRepository extends BaseRepository {
	public int addAttendance(Attendance obj) {
		open();
		try {
			PreparedStatement ps = connection.prepareStatement("{CALL addAttendance(?, ?)}");
			ps.setInt(1, obj.getStudentId());
			ps.setDate(2, to(obj.getDated()));
			int ret = ps.executeUpdate();
			ps.close();
			connection.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
