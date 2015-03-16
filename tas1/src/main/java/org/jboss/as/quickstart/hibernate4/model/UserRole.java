package org.jboss.as.quickstart.hibernate4.model;

// Generated Jan 16, 2015 11:33:43 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Id;

/**
 * UserRole generated by hbm2java
 */
// @Entity
// @IdClass(Role.class)
// @XmlRootElement
// @Table(name = "UserRole", uniqueConstraints = @UniqueConstraint(columnNames =
// "userId"))
public class UserRole implements java.io.Serializable {

	@Id
	private String userId;

	@Id
	private String roleId;
	private String crtUser;
	private Date crtDate;
	private String updUser;
	private Date updDate;

	public UserRole() {
	}

	public UserRole(String userId, String roleId, Date crtDate, Date updDate) {
		this.userId = userId;
		this.roleId = roleId;
		this.crtDate = crtDate;
		this.updDate = updDate;
	}

	public UserRole(String userId, String roleId, String crtUser, Date crtDate,
			String updUser, Date updDate) {
		this.userId = userId;
		this.roleId = roleId;
		this.crtUser = crtUser;
		this.crtDate = crtDate;
		this.updUser = updUser;
		this.updDate = updDate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getCrtUser() {
		return this.crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public Date getCrtDate() {
		return this.crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getUpdUser() {
		return this.updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRole))
			return false;
		UserRole castOther = (UserRole) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getCrtUser() == castOther.getCrtUser()) || (this
						.getCrtUser() != null && castOther.getCrtUser() != null && this
						.getCrtUser().equals(castOther.getCrtUser())))
				&& ((this.getCrtDate() == castOther.getCrtDate()) || (this
						.getCrtDate() != null && castOther.getCrtDate() != null && this
						.getCrtDate().equals(castOther.getCrtDate())))
				&& ((this.getUpdUser() == castOther.getUpdUser()) || (this
						.getUpdUser() != null && castOther.getUpdUser() != null && this
						.getUpdUser().equals(castOther.getUpdUser())))
				&& ((this.getUpdDate() == castOther.getUpdDate()) || (this
						.getUpdDate() != null && castOther.getUpdDate() != null && this
						.getUpdDate().equals(castOther.getUpdDate())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getCrtUser() == null ? 0 : this.getCrtUser().hashCode());
		result = 37 * result
				+ (getCrtDate() == null ? 0 : this.getCrtDate().hashCode());
		result = 37 * result
				+ (getUpdUser() == null ? 0 : this.getUpdUser().hashCode());
		result = 37 * result
				+ (getUpdDate() == null ? 0 : this.getUpdDate().hashCode());
		return result;
	}

}
