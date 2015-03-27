package com.tas.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.tas.model.User;

@ApplicationScoped
public class UserRepository {

	@Inject
	private EntityManager em;

	public User findById(String userId) {
		return em.find(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllOrderedByName(User user) {
		Session session = (Session) em.getDelegate();
		Criteria cb = session.createCriteria(User.class);

		if (user.getUserId() != null) {
			cb.add(Restrictions.like("userId", "%" + user.getUserId() + "%"));
		}
		if (user.getAlias() != null) {
			cb.add(Restrictions.like("alias", "%" + user.getAlias() + "%"));
		}
		if (user.getEmail() != null) {
			cb.add(Restrictions.like("email", "%" + user.getEmail() + "%"));
		}
		if (user.getMobile() != null) {
			cb.add(Restrictions.like("mobile", "%" + user.getMobile() + "%"));
		}
		if (user.getRoleId() != null) {
			cb.add(Restrictions.like("roleId", "%" + user.getRoleId() + "%"));
		}
		return cb.list();
	}
}
