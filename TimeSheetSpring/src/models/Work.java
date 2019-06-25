package models;

import java.sql.Time;
import java.util.Date;

public class Work {
	private int employeeId;
	private Date dated;
	private Time timed;
	private boolean deleted;
	public Work() {
		
	}
	
	public Work(int employeeId, Date dated) {
		this.employeeId = employeeId;
		this.dated = dated;
		
	}
	
	public Work(int employeeId, Date dated, Time timed, boolean deleted) {
		this(employeeId, dated);
		this.timed = timed;
		this.deleted = deleted;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	
	public Time getTimed() {
		return timed;
	}

	public void setTimed(Time timed) {
		this.timed = timed;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
