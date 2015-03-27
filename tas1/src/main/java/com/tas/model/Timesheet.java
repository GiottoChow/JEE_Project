package com.tas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name = "Timesheet", uniqueConstraints = @UniqueConstraint(columnNames = { "tid" }))
public class Timesheet implements java.io.Serializable {

	private static final long serialVersionUID = -3582673343379994170L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String tid;
	private String userId;
	private String courseName;
	private Date startDateTime;
	private Date endDateTime;

	public Timesheet() {
	}

	public String getTId() {
		return tid;
	}

	public void setTId(String tid) {
		this.tid = tid;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Timesheet))
			return false;
		Timesheet castOther = (Timesheet) other;

		return ((this.getTId() == castOther.getTId()) || (this.getTId() != null
				&& castOther.getTId() != null && this.getTId().equals(
				castOther.getTId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getCourseName() == castOther.getCourseName()) || (this
						.getCourseName() != null
						&& castOther.getCourseName() != null && this
						.getCourseName().equals(castOther.getCourseName())))
				&& ((this.getStartDateTime() == castOther.getStartDateTime()) || (this
						.getStartDateTime() != null
						&& castOther.getStartDateTime() != null && this
						.getStartDateTime()
						.equals(castOther.getStartDateTime())))
				&& ((this.getEndDateTime() == castOther.getEndDateTime()) || (this
						.getEndDateTime() != null
						&& castOther.getEndDateTime() != null && this
						.getEndDateTime().equals(castOther.getEndDateTime())));
	}

	@Override
	public int hashCode() {

		int result = 17;

		result = 37 * result
				+ (getTId() == null ? 0 : this.getTId().hashCode());

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());

		result = 37
				* result
				+ (getCourseName() == null ? 0 : this.getCourseName()
						.hashCode());
		result = 37
				* result
				+ (getStartDateTime() == null ? 0 : this.getStartDateTime()
						.hashCode());
		result = 37
				* result
				+ (getEndDateTime() == null ? 0 : this.getEndDateTime()
						.hashCode());
		return result;
	}

}
