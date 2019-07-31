package Bean_Package;

import java.sql.Date;
import java.time.LocalDate;

public class EmployeeBean {
	
	String start,employeeType;
	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	int leaveid;
	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}
	String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	int month,days_left;
	public void setDays_left(int days_left) {
		this.days_left = days_left;
	}

	public int getDays_left() {
		return days_left;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	String end;
	String reason;
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end_date) {
		this.end = end_date;
	}

	public int getLeaveid() {
		// TODO Auto-generated method stub
		return leaveid;
	}




}
