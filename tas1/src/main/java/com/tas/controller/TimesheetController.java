package com.tas.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.Timesheet;
import com.tas.service.TimesheetRegistration;

@Model
public class TimesheetController {

	// private List<Timesheet> lstTimesheets = new ArrayList<Timesheet>();
	//
	// @Produces
	// public List<Timesheet> getTimesheets() {
	// return this.lstTimesheets;
	// }

	public TimesheetController() {
		// Timesheet tmp = new Timesheet();
		// tmp.setUserId("Ädmin");
		// tmp.setCourseName("A");
		// tmp.setStartDateTime(new GregorianCalendar(2015, 03, 26, 11, 11, 11)
		// .getTime());
		// tmp.setEndDateTime(new GregorianCalendar(2015, 03, 26, 21, 11, 11)
		// .getTime());
		// this.lstTimesheets.add(tmp);
		// tmp = new Timesheet();
		// tmp.setUserId("Ädmin");
		// tmp.setCourseName("A");
		// tmp.setStartDateTime(new GregorianCalendar(2015, 03, 24, 11, 11, 11)
		// .getTime());
		// tmp.setEndDateTime(new GregorianCalendar(2015, 03, 24, 21, 11, 11)
		// .getTime());
		// this.lstTimesheets.add(tmp);
		// tmp = new Timesheet();
		// tmp.setUserId("Ädmin");
		// tmp.setCourseName("A");
		// tmp.setStartDateTime(new GregorianCalendar(2015, 03, 21, 11, 11, 11)
		// .getTime());
		// tmp.setEndDateTime(new GregorianCalendar(2015, 03, 21, 21, 11, 11)
		// .getTime());
		// this.lstTimesheets.add(tmp);
		// tmp = new Timesheet();
		// tmp.setUserId("Ädmin");
		// tmp.setCourseName("A");
		// tmp.setStartDateTime(new GregorianCalendar(2015, 03, 22, 11, 11, 11)
		// .getTime());
		// tmp.setEndDateTime(new GregorianCalendar(2015, 03, 22, 21, 11, 11)
		// .getTime());
		// this.lstTimesheets.add(tmp);

	}

	@Inject
	private FacesContext facesContext;

	@Inject
	private TimesheetRegistration timesheetRegistration;

	private Timesheet newTimesheet;

	private boolean isEdit = false;

	@Named
	public boolean isEdit() {
		return isEdit;
	}

	@Named
	public void setNewTimesheet(Timesheet timesheet) {
		newTimesheet = timesheet;
	}

	@Produces
	@Named
	public Timesheet getNewTimesheet() {
		return newTimesheet;
	}

	@PostConstruct
	public void initNewTimesheet() {
		newTimesheet = new Timesheet();
	}

	// public void onUserSelectChanged(ValueChangeEvent event) {
	// event.getNewValue();
	// }

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
	public String navToEdit(Timesheet timesheet) {
		newTimesheet = timesheet;
		isEdit = true;
		return "timesheet.jsf";
	}

	@Named
	public String merge() {
		try {
			timesheetRegistration.merge(newTimesheet);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Successful!", "Successful"));
			initNewTimesheet();
			return "findTimesheet.jsf";
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, errorMessage,
					"Error, unsuccessful"));
			return "#";
		}
	}

	@Named
	public void delete() {
		try {
			timesheetRegistration.delete(newTimesheet);
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
