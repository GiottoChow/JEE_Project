package com.tas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.tas.model.Course;

@ApplicationScoped
public class CourseRepository {

	@Inject
	private EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAllOrderedByName(Course course) {
		Session session = (Session) em.getDelegate();
		Criteria cb = session.createCriteria(Course.class);

		if (course.getCourseName() != null) {
			cb.add(Restrictions.like("courseName", "%" + course.getCourseName()
					+ "%"));
		}

		cb.addOrder(Order.asc("courseName"));
		return cb.list();
	}
}
