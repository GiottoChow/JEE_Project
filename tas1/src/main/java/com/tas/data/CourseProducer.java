package com.tas.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.Course;

@RequestScoped
public class CourseProducer {

	@Inject
	private CourseRepository CourseRepository;

	private List<Course> Courses;

	@Produces
	@Named
	public List<Course> getCourses() {
		return Courses;
	}

	public void onCourseListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Course Course) {
		retrieveAllCoursesOrderedByName();
	}

	@PostConstruct
	public void retrieveAllCoursesOrderedByName() {
		Courses = CourseRepository.findAllOrderedByName();
	}
}
