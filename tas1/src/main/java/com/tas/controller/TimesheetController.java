package com.tas.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.Timesheet;
import com.tas.service.TimesheetRegistration;

@Model
public class TimesheetController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private TimesheetRegistration timesheetRegistration;

	private Timesheet newTimesheet;

	@Produces
	@Named
	public Timesheet getNewtimesheet() {
		return newTimesheet;
	}

	public void onUserSelectChanged(ValueChangeEvent event) {
		event.getNewValue();
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
	public void initNewTimesheet() {
		newTimesheet = new Timesheet();
	}

	public String merge() {
		try {
			timesheetRegistration.merge(newTimesheet);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Successful!", "Successful"));
			initNewTimesheet();
			return "course.jsf";
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
			return "#";
		}
	}

	public String delete() {
		try {
			timesheetRegistration.delete(newTimesheet);

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Successful!", "Successful"));
			initNewTimesheet();

			return "tas1/course.jsf";
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
			return "tas1/course.jsf";
		}
	}

}
