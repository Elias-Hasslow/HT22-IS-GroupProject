package model;

import java.util.ArrayList;

public class CourseRegister {
	private ArrayList<Course> courseRegister = new ArrayList<Course>();

	//getters & setters
	
	public ArrayList<Course> getCourseRegister() {
		return courseRegister;
	}

	public void setCourseRegister(ArrayList<Course> courseRegister) {
		this.courseRegister = courseRegister;
	}
	
	
	// other methods
	
	public void createCourse(Course courseCode) {
		this.courseRegister.add(courseCode);
	}
	

	public Course readCourse(String courseCode) {
		for (Course course : courseRegister) {
			if (course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null;
	}
	

	public Course findCourseByName(String courseName) {
		for (Course course : courseRegister) {
			if (course.getCourseName().equals(courseName)) {

				return course;
			}
		}
		return null;
	}

	
	public void removeCourse(String courseCode) {
		Course tmpCourse = readCourse(courseCode);

		if (tmpCourse != null) {
			courseRegister.remove(tmpCourse);
		}
	}

	
}
