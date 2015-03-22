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

	@Produces
	@Named
	public Course getNewCourse() {
		return newCourse;
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

	@PostConstruct
	public void initNewCourse() {
		newCourse = new Course();
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

	public void search() {
		try {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Search Complete!",
					"Search Complete"));
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
		}
	}

	public void delete() {
		try {
			CourseRegistration.delete(newCourse);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Delete Successful!",
					"Successful"));
			initNewCourse();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));

		}
	}
}
