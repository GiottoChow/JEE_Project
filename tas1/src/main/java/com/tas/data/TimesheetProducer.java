package com.tas.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.Timesheet;

@Named
@RequestScoped
public class TimesheetProducer {

	@Inject
	private TimesheetRepository TimeshetRepository;

	private List<Timesheet> Timesheets;

	private Timesheet searchTimesheet = new Timesheet();

	@Produces
	@Named
	public List<Timesheet> getTimesheets() {
		return Timesheets;
	}

	@Named
	public Timesheet getSearchTimesheet() {
		return searchTimesheet;
	}

	public void onTimeshetListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Timesheet Timesheet) {
		retrieveAllTimesheetsOrderedByName();
	}

	@PostConstruct
	public void retrieveAllTimesheetsOrderedByName() {
		Timesheets = TimeshetRepository.findAllOrderedByName(searchTimesheet);
		// List<Timesheet> tmpLst = new ArrayList<Timesheet>(Timesheets);
		//
		// for (int i = 0; i < Timesheets.size(); i++) {
		// Timesheets.get(i);
		// }
	}
}
