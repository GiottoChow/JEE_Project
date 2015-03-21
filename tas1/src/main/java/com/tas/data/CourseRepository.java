package com.tas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.tas.model.Course;

@ApplicationScoped
public class CourseRepository {

	@Inject
	private EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAllOrderedByName() {
		Session session = (Session) em.getDelegate();
		Criteria cb = session.createCriteria(Course.class);
		return cb.list();
	}

	@SuppressWarnings("unchecked")
	public List<Course> findAllOrderedByName2() {
		Session session = (Session) em.getDelegate();
		Criteria cb = session.createCriteria(Course.class);
		List<Course> tmp = cb.list();
		for (int i = 0; i < tmp.size(); i++) {
			session.setReadOnly(tmp.get(i), true);
			em.detach(tmp.get(i));
		}
		// cb.addOrder(Order.asc("name"));
		// return cb.list();

		// em.close();
		return tmp;
	}
}
