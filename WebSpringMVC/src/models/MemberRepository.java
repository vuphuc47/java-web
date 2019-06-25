package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class MemberRepository extends BaseRepository {
	public int add(Member obj) {
		return jdbc.update("{CALL AddMember(?, ?, ?)}", obj.getUsername(), bCript(obj.getPassword()), obj.getEmail());
	}

	public Member signIn(String username) {
		return jdbc.queryForObject("{CALL SignIn(?)}", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int index) throws SQLException {
				Member obj =  new Member(rs.getInt("MemberId"), rs.getString("UserName"), rs.getString("Password"),
						rs.getString("Email"));
				obj.setRoles(getRoleByMember(obj.getId()));
				return obj;
			}
		}, username);
	}

	public List<Role> getRoleByMember(int id) {
		return jdbc.query("{CALL GetRolesByMember(?)}", new RowMapper<Role>() {

			@Override
			public Role mapRow(ResultSet rs, int index) throws SQLException {
				return new Role(rs.getInt("RoleId"), rs.getString("RoleName"));
			}
		}, id);
	}
}
