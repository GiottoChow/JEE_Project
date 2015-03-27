package com.tas.data;

import java.util.List;

//<!-- 		<h:commandButton id="search" -->
//<!-- 						action="#{findAllCoursesOrderedByName2(testing)}" value="Search" -->
//<!-- 						styleClass="register" > -->
//<!-- 						 <f:ajax execute="search" render="courseId"></f:ajax> -->
//<!-- 						</h:commandButton> -->
//<!-- CourseProducer		 -->
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.tas.model.Course;

@Named
@RequestScoped
public class CourseProducer {

	@Inject
	private CourseRepository CourseRepository;

	private List<Course> Courses;

	private Course searchCourse = new Course();

	@Produces
	@Named
	public List<Course> getCourses() {
		return Courses;
	}

	@Named
	public Course getSearchCourse() {
		return searchCourse;
	}

	public void onCourseListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Course Course) {
		findAllCoursesOrderedByName();
	}

	@PostConstruct
	public void findAllCoursesOrderedByName() {
		Courses = CourseRepository.findAllOrderedByName(searchCourse);
	}

}
