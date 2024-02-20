package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Course {
	private String courseCode;
	private String courseName;
	private int credits;
	private Teacher responsible;
	private String responsibleName;
	private ArrayList<Teacher> teachingTeachers = new ArrayList<Teacher>();
	private Department department;
	private Map<Teacher, Integer> hoursTaught = new HashMap<>();
	private CourseRegister couRegi;
	private String departmentName;




	// constructors 
	public Course() {
	}
	
	public Course(String courseName, int credits, Department department, Teacher responsible) {
		this.courseCode = courseName.substring(0, 2) + String.format("%04d", new Random().nextInt(10000));
		this.courseName = courseName;
		this.credits = credits;
		this.department = department;
		this.responsible = responsible;
	}

	// getters and setters
	
	public CourseRegister getCouRegi() {
		return couRegi;
	}

	public void setCouRegi(CourseRegister couRegi) {
		this.couRegi = couRegi;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public Map<Teacher, Integer> getHoursTaught() {
		return hoursTaught;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getResponsibleName() {
		this.responsibleName = responsible.getTeacherName();
		return responsibleName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		Teacher t = responsible;
		if (credits < 0) {
			throw new IllegalArgumentException("Credits need to be a positive value");
		} else if(t.calculateTotalResponsibleForCredits() > 29) {
			throw new IllegalArgumentException("You Cannot Have Courses Adding \nUpp To Over 30 Credis!");
		}
		else {
			this.credits = credits;
		
	}
	}
	public ArrayList<Teacher> getTeachingTeachers() {
		return teachingTeachers;
	}

	public void setTeachingTeachers(ArrayList<Teacher> teachingTeachers) {
		this.teachingTeachers = teachingTeachers;
	}

	public Teacher getResponsible() {
		return responsible;
	}

	public void setResponsible(Teacher teacher) {
		int tot = 0;
		for(Teacher t : teachingTeachers) {
			for(Course c : t.getTeachingCourses()) {
			tot += c.getCredits();
				}
			}
		if(tot > 30) {
			throw new IllegalArgumentException("You Cannot Have Courses Adding \nUpp To Over 30 Credis!");
		}
		else {
		this.responsible = teacher;
			}
	}
	
	public void removeResponsible() {
		this.responsible = null;
	}
	
	public String getDepartmentName() {
		this.departmentName = department.getDepName();
		return departmentName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	// other methods

	public void addTeacher(Teacher name) {
		this.teachingTeachers.add(name);
		this.hoursTaught.put(name, 0);
	}
	
	public void removeTeachingTeacher(Teacher teacher) {
		teachingTeachers.remove(teacher);
		this.hoursTaught.remove(teacher);
	}
	
	
	public Teacher findTeachingTeacher(String employeeID) {
		for (Teacher tmpteacher : teachingTeachers) {
			if (tmpteacher.getEmployeeID().equals(employeeID)) {
				return tmpteacher;
			}
		}
		return null;
	}
	
	
	public void addHours(Teacher teacherName, Integer hours) {
		Integer totalHours = hoursTaught.get(teacherName) + hours;
		hoursTaught.put(teacherName, totalHours);
	}
	
	public Integer calcuclateTeacherHours (String teacherName) {
		Integer totalHours = 0;
		for (Teacher teacher : teachingTeachers) {
			if(teacher.getTeacherName().equals(teacherName)) {
				totalHours = hoursTaught.get(teacher);
			}
		}return totalHours;
	}


	
	public int calculateAllHoursTaught() {
		int totalHours = 0;
		for(int value : hoursTaught.values()) {
			totalHours += value;
		}return totalHours;
	}
	
	public double calculateCourseCost () {
		double totalCost = 0;
			for(Teacher teacher : teachingTeachers) {
				totalCost += teacher.getHourlySalary() * hoursTaught.get(teacher);
			}
		return totalCost;

	}
	
	public boolean checkContainingTeacher(String teacherName) {
		for (Teacher teacher : teachingTeachers) {
			if(teacher.getTeacherName().equals(teacherName)) {
				return true;
			}
		}
		return false;
	}
}
