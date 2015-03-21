package com.tas.model;

import java.io.Serializable;
import java.util.Date;

public class TimesheetId implements Serializable {

	private static final long serialVersionUID = 6135181032893435987L;

	private String userId;
	private String courseName;
	private Date startDateTime;

	public TimesheetId() {
	}

	public TimesheetId(String userId, String courseName, Date startDateTime) {
		this.userId = userId;
		this.courseName = courseName;
		this.startDateTime = startDateTime;
	}

	public String getuserId() {
		return this.userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getcourseName() {
		return this.courseName;
	}

	public void setcourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TimesheetId))
			return false;
		TimesheetId castOther = (TimesheetId) other;

		return ((this.getuserId() == castOther.getuserId()) || (this
				.getuserId() != null && castOther.getuserId() != null && this
				.getuserId().equals(castOther.getuserId())))
				&& ((this.getcourseName() == castOther.getcourseName()) || (this
						.getcourseName() != null
						&& castOther.getcourseName() != null && this
						.getcourseName().equals(castOther.getcourseName())))
				&& ((this.getStartDateTime() == castOther.getStartDateTime()) || (this
						.getStartDateTime() != null
						&& castOther.getStartDateTime() != null && this
						.getStartDateTime()
						.equals(castOther.getStartDateTime())));
	}

	@Override
	public int hashCode() {

		int result = 17;

		result = 37 * result
				+ (getuserId() == null ? 0 : this.getuserId().hashCode());
		result = 37
				* result
				+ (getcourseName() == null ? 0 : this.getcourseName()
						.hashCode());
		result = 37
				* result
				+ (getStartDateTime() == null ? 0 : this.getStartDateTime()
						.hashCode());
		return result;
	}

}
