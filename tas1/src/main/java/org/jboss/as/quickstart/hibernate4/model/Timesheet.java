package org.jboss.as.quickstart.hibernate4.model;

// Generated Jan 16, 2015 11:33:43 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Timesheet generated by hbm2java
 */
@Entity
@XmlRootElement
@Table(name = "Timesheet", uniqueConstraints = @UniqueConstraint(columnNames = "clientId"))
public class Timesheet implements java.io.Serializable {

	@Id
	private String clientId;
	private String instructorId;
	private String couseName;
	private String jobName;
	private Date startDate;
	private BigDecimal sundaySpend;
	private BigDecimal mondaySpend;
	private BigDecimal tuesdaySpend;
	private BigDecimal wednesdaySpend;
	private BigDecimal thursdaySpend;
	private BigDecimal fridaySpend;
	private BigDecimal saturdaySpend;
	private Date createDate;
	private Date lastUpdDate;

	public Timesheet() {
	}

	public Timesheet(String clientId, String couseName, String jobName,
			Date startDate, Date createDate) {
		this.clientId = clientId;
		this.couseName = couseName;
		this.jobName = jobName;
		this.startDate = startDate;
		this.createDate = createDate;
	}

	public Timesheet(String clientId, String instructorId, String couseName,
			String jobName, Date startDate, BigDecimal sundaySpend,
			BigDecimal mondaySpend, BigDecimal tuesdaySpend,
			BigDecimal wednesdaySpend, BigDecimal thursdaySpend,
			BigDecimal fridaySpend, BigDecimal saturdaySpend, Date createDate,
			Date lastUpdDate) {
		this.clientId = clientId;
		this.instructorId = instructorId;
		this.couseName = couseName;
		this.jobName = jobName;
		this.startDate = startDate;
		this.sundaySpend = sundaySpend;
		this.mondaySpend = mondaySpend;
		this.tuesdaySpend = tuesdaySpend;
		this.wednesdaySpend = wednesdaySpend;
		this.thursdaySpend = thursdaySpend;
		this.fridaySpend = fridaySpend;
		this.saturdaySpend = saturdaySpend;
		this.createDate = createDate;
		this.lastUpdDate = lastUpdDate;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getInstructorId() {
		return this.instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public String getCouseName() {
		return this.couseName;
	}

	public void setCouseName(String couseName) {
		this.couseName = couseName;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getSundaySpend() {
		return this.sundaySpend;
	}

	public void setSundaySpend(BigDecimal sundaySpend) {
		this.sundaySpend = sundaySpend;
	}

	public BigDecimal getMondaySpend() {
		return this.mondaySpend;
	}

	public void setMondaySpend(BigDecimal mondaySpend) {
		this.mondaySpend = mondaySpend;
	}

	public BigDecimal getTuesdaySpend() {
		return this.tuesdaySpend;
	}

	public void setTuesdaySpend(BigDecimal tuesdaySpend) {
		this.tuesdaySpend = tuesdaySpend;
	}

	public BigDecimal getWednesdaySpend() {
		return this.wednesdaySpend;
	}

	public void setWednesdaySpend(BigDecimal wednesdaySpend) {
		this.wednesdaySpend = wednesdaySpend;
	}

	public BigDecimal getThursdaySpend() {
		return this.thursdaySpend;
	}

	public void setThursdaySpend(BigDecimal thursdaySpend) {
		this.thursdaySpend = thursdaySpend;
	}

	public BigDecimal getFridaySpend() {
		return this.fridaySpend;
	}

	public void setFridaySpend(BigDecimal fridaySpend) {
		this.fridaySpend = fridaySpend;
	}

	public BigDecimal getSaturdaySpend() {
		return this.saturdaySpend;
	}

	public void setSaturdaySpend(BigDecimal saturdaySpend) {
		this.saturdaySpend = saturdaySpend;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdDate() {
		return this.lastUpdDate;
	}

	public void setLastUpdDate(Date lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
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

		return ((this.getClientId() == castOther.getClientId()) || (this
				.getClientId() != null && castOther.getClientId() != null && this
				.getClientId().equals(castOther.getClientId())))
				&& ((this.getInstructorId() == castOther.getInstructorId()) || (this
						.getInstructorId() != null
						&& castOther.getInstructorId() != null && this
						.getInstructorId().equals(castOther.getInstructorId())))
				&& ((this.getCouseName() == castOther.getCouseName()) || (this
						.getCouseName() != null
						&& castOther.getCouseName() != null && this
						.getCouseName().equals(castOther.getCouseName())))
				&& ((this.getJobName() == castOther.getJobName()) || (this
						.getJobName() != null && castOther.getJobName() != null && this
						.getJobName().equals(castOther.getJobName())))
				&& ((this.getStartDate() == castOther.getStartDate()) || (this
						.getStartDate() != null
						&& castOther.getStartDate() != null && this
						.getStartDate().equals(castOther.getStartDate())))
				&& ((this.getSundaySpend() == castOther.getSundaySpend()) || (this
						.getSundaySpend() != null
						&& castOther.getSundaySpend() != null && this
						.getSundaySpend().equals(castOther.getSundaySpend())))
				&& ((this.getMondaySpend() == castOther.getMondaySpend()) || (this
						.getMondaySpend() != null
						&& castOther.getMondaySpend() != null && this
						.getMondaySpend().equals(castOther.getMondaySpend())))
				&& ((this.getTuesdaySpend() == castOther.getTuesdaySpend()) || (this
						.getTuesdaySpend() != null
						&& castOther.getTuesdaySpend() != null && this
						.getTuesdaySpend().equals(castOther.getTuesdaySpend())))
				&& ((this.getWednesdaySpend() == castOther.getWednesdaySpend()) || (this
						.getWednesdaySpend() != null
						&& castOther.getWednesdaySpend() != null && this
						.getWednesdaySpend().equals(
								castOther.getWednesdaySpend())))
				&& ((this.getThursdaySpend() == castOther.getThursdaySpend()) || (this
						.getThursdaySpend() != null
						&& castOther.getThursdaySpend() != null && this
						.getThursdaySpend()
						.equals(castOther.getThursdaySpend())))
				&& ((this.getFridaySpend() == castOther.getFridaySpend()) || (this
						.getFridaySpend() != null
						&& castOther.getFridaySpend() != null && this
						.getFridaySpend().equals(castOther.getFridaySpend())))
				&& ((this.getSaturdaySpend() == castOther.getSaturdaySpend()) || (this
						.getSaturdaySpend() != null
						&& castOther.getSaturdaySpend() != null && this
						.getSaturdaySpend()
						.equals(castOther.getSaturdaySpend())))
				&& ((this.getCreateDate() == castOther.getCreateDate()) || (this
						.getCreateDate() != null
						&& castOther.getCreateDate() != null && this
						.getCreateDate().equals(castOther.getCreateDate())))
				&& ((this.getLastUpdDate() == castOther.getLastUpdDate()) || (this
						.getLastUpdDate() != null
						&& castOther.getLastUpdDate() != null && this
						.getLastUpdDate().equals(castOther.getLastUpdDate())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClientId() == null ? 0 : this.getClientId().hashCode());
		result = 37
				* result
				+ (getInstructorId() == null ? 0 : this.getInstructorId()
						.hashCode());
		result = 37 * result
				+ (getCouseName() == null ? 0 : this.getCouseName().hashCode());
		result = 37 * result
				+ (getJobName() == null ? 0 : this.getJobName().hashCode());
		result = 37 * result
				+ (getStartDate() == null ? 0 : this.getStartDate().hashCode());
		result = 37
				* result
				+ (getSundaySpend() == null ? 0 : this.getSundaySpend()
						.hashCode());
		result = 37
				* result
				+ (getMondaySpend() == null ? 0 : this.getMondaySpend()
						.hashCode());
		result = 37
				* result
				+ (getTuesdaySpend() == null ? 0 : this.getTuesdaySpend()
						.hashCode());
		result = 37
				* result
				+ (getWednesdaySpend() == null ? 0 : this.getWednesdaySpend()
						.hashCode());
		result = 37
				* result
				+ (getThursdaySpend() == null ? 0 : this.getThursdaySpend()
						.hashCode());
		result = 37
				* result
				+ (getFridaySpend() == null ? 0 : this.getFridaySpend()
						.hashCode());
		result = 37
				* result
				+ (getSaturdaySpend() == null ? 0 : this.getSaturdaySpend()
						.hashCode());
		result = 37
				* result
				+ (getCreateDate() == null ? 0 : this.getCreateDate()
						.hashCode());
		result = 37
				* result
				+ (getLastUpdDate() == null ? 0 : this.getLastUpdDate()
						.hashCode());
		return result;
	}

}
