package com.tas.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.Course;
import com.tas.service.CourseRegistration;

@Model
public class CourseController {
	@Inject
	private FacesContext facesContext;

	@Inject
	private CourseRegistration CourseRegistration;

	private Course newCourse;

	private boolean isEdit = false;

	@Named
	public boolean isEdit() {
		return isEdit;
	}

	@Named
	public void setNewCourse(Course course) {
		newCourse = course;
		;
	}

	@Produces
	@Named
	public Course getNewCourse() {
		return newCourse;
	}

	@PostConstruct
	public void initNewCourse() {
		newCourse = new Course();
	}

	private String getRootErrorMessage(Exception e) {
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			return errorMessage;
		}
		Throwable t = e;
		while (t != null) {
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		return errorMessage;
	}

	@Named
	public String navToEdit(Course course) {
		newCourse = course;
		isEdit = true;
		return "course.jsf";
	}

	public String merge() {
		try {
			CourseRegistration.merge(newCourse);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Successful!", "Successful"));
			initNewCourse();
			return "findCourse.jsf";
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
			return "#";
		}
	}

	public void delete() {
		try {
			CourseRegistration.delete(newCourse);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Delete Successful!",
					"Successful"));
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
		}
	}
}
