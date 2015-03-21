package com.tas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "Course", uniqueConstraints = @UniqueConstraint(columnNames = "courseName"))
public class Course implements java.io.Serializable {

	private static final long serialVersionUID = 1749332232044887413L;

	@Id
	@NotNull
	@NotEmpty
	@Column(name = "courseName")
	private String courseName;

	public Course() {

	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Course))
			return false;
		Course castOther = (Course) other;

		return ((this.getCourseName() == castOther.getCourseName()) || (this
				.getCourseName() != null && castOther.getCourseName() != null && this
				.getCourseName().equals(castOther.getCourseName())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCourseName() == null ? 0 : this.getCourseName()
						.hashCode());
		return result;
	}

}
