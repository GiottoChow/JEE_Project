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

@RequestScoped
public class TimesheetProducer {

	@Inject
	private TimesheetRepository TimeshetRepository;

	private List<Timesheet> Timesheets;

	@Produces
	@Named
	public List<Timesheet> getTimesheets() {
		return Timesheets;
	}

	public void onTimeshetListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Timesheet Timesheet) {
		retrieveAllTimesheetsOrderedByName();
	}

	@PostConstruct
	public void retrieveAllTimesheetsOrderedByName() {
		Timesheets = TimeshetRepository.findAllOrderedByName();
	}
}
