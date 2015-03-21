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

	public void merge(User user) throws Exception {
		log.info("Merge " + user.getUserId());

		Session session = (Session) em.getDelegate();
		session.merge(user);
		userEventSrc.fire(user);
	}

	public void delete(User user) throws Exception {
		log.info("Merge " + user.getUserId());

		Session session = (Session) em.getDelegate();
		session.delete(user);
		userEventSrc.fire(user);
	}

}
