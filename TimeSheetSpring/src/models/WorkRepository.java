package models;

public class WorkRepository extends BaseRepository {
	public int add(Work obj) {
		return jdbc.update("CALL AddWork(?, ?)", obj.getEmployeeId(), obj.getDated());

	}
}
