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
package org.jboss.as.quickstart.hibernate4.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/*The Model uses JPA Entity as well as Hibernate Validators
 * 
 */

@Embeddable
@Entity
@XmlRootElement
@Table(name = "Role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Role_bkup implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	// @OneToOne(fetch = FetchType.LAZY, mappedBy = "Role")
	private String name;

	private String desc;

	public String getDesc() {
		return desc;
	}

	public String getName() {
		return name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roleBkup")
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<MemberRole_bkup> memberRoles;

	public Set<MemberRole_bkup> getMemberRole_bkups() {
		return memberRoles;
	}

	public void setMemberRole_bkups(Set<MemberRole_bkup> memberRoles) {
		this.memberRoles = memberRoles;
	}
}
