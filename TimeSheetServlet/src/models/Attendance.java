package models;

import java.sql.Time;
import java.util.Date;

public class Attendance {
	private Integer studentId;
	private Date dated;
	private Time timed;

	public Attendance(Integer studentId, Date dated) {
		super();
		this.studentId = studentId;
		this.dated = dated;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
}
