package com.tas.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.tas.model.Timesheet;
import com.tas.model.TimesheetId;

@Stateless
public class TimesheetRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Timesheet> TimesheetEventSrc;

	public void merge(Timesheet timesheet) throws Exception {
		log.info("Merge " + timesheet.getUserId() + "@"
				+ timesheet.getCourseName() + "@"
				+ timesheet.getStartDateTime().getTime());
		Session session = (Session) em.getDelegate();
		session.merge(timesheet);
		TimesheetEventSrc.fire(timesheet);
	}

	public void delete(Timesheet timesheet) throws Exception {
		log.info("Delete " + timesheet.getUserId() + "@"
				+ timesheet.getCourseName() + "@"
				+ timesheet.getStartDateTime().getTime());

		Session session = (Session) em.getDelegate();

		TimesheetId x = new TimesheetId(timesheet.getUserId(),
				timesheet.getCourseName(), timesheet.getStartDateTime());
		Timesheet y = em.getReference(Timesheet.class, x);
		session.delete(y);

		TimesheetEventSrc.fire(timesheet);
	}

}
