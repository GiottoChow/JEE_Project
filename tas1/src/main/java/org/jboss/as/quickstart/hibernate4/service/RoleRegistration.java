/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstart.hibernate4.service;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.jboss.as.quickstart.hibernate4.model.Role_bkup;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class RoleRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Role_bkup> memberEventSrc;

	public void register(Role_bkup role) throws Exception {
		log.info("Registering " + role.getName());
		// em.persist(member);

		// using Hibernate session(Native API) and JPA entitymanager
		Session session = (Session) em.getDelegate();
		session.persist(role);
		memberEventSrc.fire(role);
	}
}
