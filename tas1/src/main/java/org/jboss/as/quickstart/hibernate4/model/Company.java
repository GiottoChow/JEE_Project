package org.jboss.as.quickstart.hibernate4.model;

// Generated Jan 16, 2015 11:33:43 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Company generated by hbm2java
 */
public class Company implements java.io.Serializable {

	private String companyCode;
	private String companyName;
	private Date createDate;
	private String createBy;
	private Date updDate;
	private String updBy;

	public Company() {
	}

	public Company(String companyCode, String companyName,
			Date createDate, String createBy) {
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.createDate = createDate;
		this.createBy = createBy;
	}

	public Company(String companyCode, String companyName,
			Date createDate, String createBy, Date updDate, String updBy) {
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.createDate = createDate;
		this.createBy = createBy;
		this.updDate = updDate;
		this.updBy = updBy;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUpdBy() {
		return this.updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Company))
			return false;
		Company castOther = (Company) other;

		return ((this.getCompanyCode() == castOther.getCompanyCode()) || (this
				.getCompanyCode() != null && castOther.getCompanyCode() != null && this
				.getCompanyCode().equals(castOther.getCompanyCode())))
				&& ((this.getCompanyName() == castOther.getCompanyName()) || (this
						.getCompanyName() != null
						&& castOther.getCompanyName() != null && this
						.getCompanyName().equals(castOther.getCompanyName())))
				&& ((this.getCreateDate() == castOther.getCreateDate()) || (this
						.getCreateDate() != null
						&& castOther.getCreateDate() != null && this
						.getCreateDate().equals(castOther.getCreateDate())))
				&& ((this.getCreateBy() == castOther.getCreateBy()) || (this
						.getCreateBy() != null
						&& castOther.getCreateBy() != null && this
						.getCreateBy().equals(castOther.getCreateBy())))
				&& ((this.getUpdDate() == castOther.getUpdDate()) || (this
						.getUpdDate() != null && castOther.getUpdDate() != null && this
						.getUpdDate().equals(castOther.getUpdDate())))
				&& ((this.getUpdBy() == castOther.getUpdBy()) || (this
						.getUpdBy() != null && castOther.getUpdBy() != null && this
						.getUpdBy().equals(castOther.getUpdBy())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCompanyCode() == null ? 0 : this.getCompanyCode()
						.hashCode());
		result = 37
				* result
				+ (getCompanyName() == null ? 0 : this.getCompanyName()
						.hashCode());
		result = 37
				* result
				+ (getCreateDate() == null ? 0 : this.getCreateDate()
						.hashCode());
		result = 37 * result
				+ (getCreateBy() == null ? 0 : this.getCreateBy().hashCode());
		result = 37 * result
				+ (getUpdDate() == null ? 0 : this.getUpdDate().hashCode());
		result = 37 * result
				+ (getUpdBy() == null ? 0 : this.getUpdBy().hashCode());
		return result;
	}

}
