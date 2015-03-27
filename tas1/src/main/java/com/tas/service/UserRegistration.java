package com.tas.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.tas.model.User;

@Stateless
public class UserRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<User> userEventSrc;

	public void add(User user) {
		log.info("Add " + user.getUserId());

		Session session = (Session) em.getDelegate();
		session.persist(user);
		userEventSrc.fire(user);
	}

	public void merge(User user) {
		log.info("Add " + user.getUserId());

		Session session = (Session) em.getDelegate();
		session.merge(user);
		userEventSrc.fire(user);
	}

	public void modify(User from, User to) {
		log.info("Modify " + from.getUserId());

		Session session = (Session) em.getDelegate();
		User targetUser = em.getReference(User.class, from.getUserId());
		em.remove(targetUser);
		userEventSrc.fire(from);

		session.persist(to);
		userEventSrc.fire(to);
	}

	public void delete(User user) {
		log.info("Delete " + user.getUserId());

		User targetUser = em.getReference(User.class, user.getUserId());
		em.remove(targetUser);
		userEventSrc.fire(targetUser);
	}

}
