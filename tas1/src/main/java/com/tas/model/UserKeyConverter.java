package com.tas.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@FacesConverter(value = "userKeyConverter")
public class UserKeyConverter implements Converter {

	@Inject
	private EntityManager em;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// Session session = (Session) em.getDelegate();
		//
		// session.setFlushMode(FlushMode.AUTO);
		// session.setDefaultReadOnly(true);
		// List<User> userLst = session.createCriteria(User.class)
		// // .setReadOnly(true).list();
		// // List<Course> courseLst = session.createCriteria(Course.class)
		// .setReadOnly(true).list();
		// return userLst.get(0);
		// userId, String passwd, String roleId, String email,
		// String mobile, Date inactiveDate, BigDecimal loginTrial,
		// String alias
		User tmp = new User();
		tmp.setUserId("A" + value);
		tmp.setEmail("Aaxx@axx");
		tmp.setMobile("A5555566665666");
		return tmp;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof User) {
			return ((User) value).getUserId();
		} else if (value instanceof String) {
			return value.toString();
		} else {
			throw new IllegalArgumentException("Cannot convert "
					+ value.getClass().getName() + " in "
					+ this.getClass().getName());
		}
	}
}
