package com.tas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.tas.model.User;

@ApplicationScoped
public class UserRepository {

	@Inject
	private EntityManager em;

	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllOrderedByName() {
		Session session = (Session) em.getDelegate();
		Criteria cb = session.createCriteria(User.class);
		// cb.addOrder(Order.asc("name"));
		return cb.list();
	}
}
