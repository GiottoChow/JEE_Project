package com.tas.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.tas.model.Course;

@Stateless
public class CourseRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Course> CourseEventSrc;

	public void merge(Course Course) throws Exception {
		log.info("Merge " + Course.getCourseName());

		Session session = (Session) em.getDelegate();
		session.merge(Course);
		CourseEventSrc.fire(Course);
	}

	public void delete(Course Course) throws Exception {
		log.info("Delete " + Course.getCourseName());

		Course targetCourse = em.getReference(Course.class,
				Course.getCourseName());
		em.remove(targetCourse);
		// session.delete(targetCourse);
		CourseEventSrc.fire(targetCourse);
	}
}
