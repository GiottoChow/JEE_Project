package com.tas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.tas.model.Timesheet;

@ApplicationScoped
public class TimesheetRepository {

	@Inject
	private EntityManager em;

	public Timesheet findById(Long id) {
		return em.find(Timesheet.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Timesheet> findAllOrderedByName(Timesheet timesheet) {
		Session session = (Session) em.getDelegate();
		Criteria cb = session.createCriteria(Timesheet.class);

		if (timesheet.getCourseName() != null) {
			cb.add(Restrictions.like("courseName",
					"%" + timesheet.getCourseName() + "%"));
		}
		if (timesheet.getUserId() != null) {
			cb.add(Restrictions.like("userId", "%" + timesheet.getUserId()
					+ "%"));
		}
		if (timesheet.getStartDateTime() != null) {
			cb.add(Restrictions.ge("startDateTime",
					timesheet.getStartDateTime()));
		}
		if (timesheet.getEndDateTime() != null) {
			cb.add(Restrictions.le("endDateTime", timesheet.getEndDateTime()));
		}

		return cb.list();
	}
}
