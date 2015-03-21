package com.tas.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.tas.data.CourseRepository;

@FacesConverter(value = "courseKeyConverter")
public class CourseKeyConverter implements Converter {

	@Inject
	private EntityManager em;

	@Inject
	private CourseRepository courseRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return new Course(value);
		// return courseRepository.findAllOrderedByName().get(0);
		// Session session = (Session) em.getDelegate();
		//
		// session.setFlushMode(FlushMode.AUTO);
		// session.setDefaultReadOnly(true);
		// List<User> userLst = session.createCriteria(User.class)
		// .setReadOnly(true).list();
		// List<Course> courseLst = session.createCriteria(Course.class)
		// .setReadOnly(true).list();
		// return courseLst.get(0);
		// .setReadOnly(true).list();
		// newTimesheet.setUser(userLst.get(0));
		// newTimesheet.setCourse(courseLst.get(0));
		// session.close();
		// em.close();r
		// newTimesheet.setCourse(courseRepository.findAllOrderedByName2()
		// .get(0));
		// newTimesheet.setUser(userRepository.findAllOrderedByName2().get(0));
		// newTimesheet.setUser(new UserRepository().findAllOrderedByName()
		// .get(0));
		// PersistentBag x = ((PersistentBag) (newTimesheet.getCourse()
		// .getTimesheets()));
		// x.getSession().connection().close();
		// x.getSession().flush();
		// x = ((PersistentBag) (newTimesheet.getUser().getTimesheets()));
		// x.getSession().connection().close();
		// x.getSession().flush();

		// return new Course(value);
		// return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof Course) {
			return ((Course) value).getCourseName();
		} else {
			throw new IllegalArgumentException("Cannot convert "
					+ value.getClass().getName() + " in "
					+ this.getClass().getName());
		}
	}

}
