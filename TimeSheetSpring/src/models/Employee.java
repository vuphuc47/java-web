package models;

import java.util.Date;

public class Employee {
	private Integer id;
	private int departmentId;
	private String departmentName;
	private String fullName;
	private Date dateOfBirth;
	private byte gender;
	private Boolean[] timesheet;
	public Employee() {
		
	}
	
	public Employee(Integer id, int departmentId, String fullName, Date dateOfBirth, byte gender) {
		this(id, departmentId, null, fullName, dateOfBirth, gender);
	}

	public Employee(Integer id, int departmentId, String departmentName, String fullName, Date dateOfBirth,
			byte gender) {
		this.id = id;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public Boolean[] getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(Boolean[] timesheet) {
		this.timesheet = timesheet;
	}
}
