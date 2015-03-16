package org.jboss.as.quickstart.hibernate4.model;

// Generated Jan 16, 2015 11:33:43 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * RoleFunc generated by hbm2java
 */
public class RoleFunc implements java.io.Serializable {

	private String roleId;
	private String funcId;
	private String remark;
	private String crtUser;
	private Date crtDate;
	private String updUser;
	private Date updDate;

	public RoleFunc() {
	}

	public RoleFunc(String roleId, String funcId, String crtUser,
			String updUser) {
		this.roleId = roleId;
		this.funcId = funcId;
		this.crtUser = crtUser;
		this.updUser = updUser;
	}

	public RoleFunc(String roleId, String funcId, String remark,
			String crtUser, Date crtDate, String updUser, Date updDate) {
		this.roleId = roleId;
		this.funcId = funcId;
		this.remark = remark;
		this.crtUser = crtUser;
		this.crtDate = crtDate;
		this.updUser = updUser;
		this.updDate = updDate;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getFuncId() {
		return this.funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleFunc))
			return false;
		RoleFunc castOther = (RoleFunc) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this
				.getRoleId() != null && castOther.getRoleId() != null && this
				.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getFuncId() == castOther.getFuncId()) || (this
						.getFuncId() != null && castOther.getFuncId() != null && this
						.getFuncId().equals(castOther.getFuncId())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())))
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

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getFuncId() == null ? 0 : this.getFuncId().hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
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
