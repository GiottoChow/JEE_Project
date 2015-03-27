package com.tas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = "userId"))
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 5507721352299042899L;

	@Id
	@Column(name = "userId")
	private String userId;
	private String passwd;
	private String roleId;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Size(min = 8, max = 25)
	@Digits(fraction = 0, integer = 25)
	private String mobile;
	private String alias;
	private String lastSessionId;

	public User() {
	}

	public User(String userId, String passwd, String roleId, String email,
			String mobile, String alias) {
		this.userId = userId;
		this.passwd = passwd;
		this.roleId = roleId;
		this.email = email;
		this.mobile = mobile;
		this.alias = alias;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLastSessionId() {
		return this.lastSessionId;
	}

	public void setLastSessionId(String lastSessionId) {
		this.lastSessionId = lastSessionId;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof User))
			return false;
		User castOther = (User) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getMobile() == castOther.getMobile()) || (this
						.getMobile() != null && castOther.getMobile() != null && this
						.getMobile().equals(castOther.getMobile())))
				&& ((this.getLastSessionId() == castOther.getLastSessionId()) || (this
						.getLastSessionId() != null
						&& castOther.getLastSessionId() != null && this
						.getLastSessionId()
						.equals(castOther.getLastSessionId())))
				&& ((this.getAlias() == castOther.getAlias()) || (this
						.getAlias() != null && castOther.getAlias() != null && this
						.getAlias().equals(castOther.getAlias())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getPasswd() == null ? 0 : this.getPasswd().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getMobile() == null ? 0 : this.getMobile().hashCode());
		result = 37
				* result
				+ (getLastSessionId() == null ? 0 : this.getLastSessionId()
						.hashCode());
		result = 37 * result
				+ (getAlias() == null ? 0 : this.getAlias().hashCode());
		return result;
	}

}
