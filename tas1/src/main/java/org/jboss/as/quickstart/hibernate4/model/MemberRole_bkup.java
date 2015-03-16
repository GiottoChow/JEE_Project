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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/*The Model uses JPA Entity as well as Hibernate Validators
 * 
 */

@Entity
@XmlRootElement
public class MemberRole_bkup implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberRoleId;

	// @MapsId("name")
	// , parameters = @Parameter(name = "property", value = "name")
	// @GenericGenerator(name = "generator", strategy = "foreign")
	// @GeneratedValue(generator = "generator")
	@ManyToOne
	@JoinColumn(name = "role_name")
	private Role_bkup roleBkup;

	// private String name;
	//
	// public String getName() {
	// return this.name;
	// }
	//
	// public void setName(String tmp) {
	// this.name = tmp;
	// }

	// @OneToOne
	// private Role_bkup name;

	// @OneToOne
	// @ForeignKey(name = "name")
	public Role_bkup getRoleBkup() {
		return this.roleBkup;
	}

	public void setRoleBkup(Role_bkup roleBkup) {
		this.roleBkup = roleBkup;
	}

	public int getId() {
		return this.memberRoleId;
	}

	public void setId(int x) {
		this.memberRoleId = x;
	}

	// private String name;
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }

}
