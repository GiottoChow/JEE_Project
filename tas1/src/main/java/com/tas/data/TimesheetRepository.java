package com.tas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;

import com.tas.model.Timesheet;

@ApplicationScoped
public class TimesheetRepository {

	@Inject
	private EntityManager em;

	public Timesheet findById(Long id) {
		return em.find(Timesheet.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Timesheet> findAllOrderedByName() {
		Session session = (Session) em.getDelegate();
		session.setFlushMode(FlushMode.AUTO);
		Criteria cb = session.createCriteria(Timesheet.class);
		// cb.addOrder(Order.asc("name"));
		return cb.list();
	}
}
