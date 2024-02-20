package model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Teacher {

	private String employeeID;
	private String teacherName;
	private String title;
	private String adress;
	private double hourlySalary;
	private Department department;
	private String departmentName;
	private TeacherRegister teaReg;
	private ArrayList<Course> teachingCourses = new ArrayList<Course>();
	private ArrayList<Course> responsibleFor = new ArrayList<Course>();

	// constructors
	public Teacher() {
	}

	public Teacher(String teacherName, String title, String adress, double hourlySalary, Department department) {
		
		this.employeeID = teacherName.substring(0, 2) + ThreadLocalRandom.current().nextInt(1000, 9999)
				+ teacherName.split(" ")[1].substring(0, 2);
		this.teacherName = teacherName;
		this.title = title;
		this.adress = adress;
		this.hourlySalary = hourlySalary;
		this.department = department;
	}
	
	// getters & setters
	
	public String getEmployeeID() {
		return employeeID;
	}

	public TeacherRegister getTeaReg() {
		return teaReg;
	}

	public void setTeaReg(TeacherRegister teaReg) {
		this.teaReg = teaReg;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getTeacherName() {
		return teacherName;
	}
	
	public String getDepartmentName() {
		this.departmentName = department.getDepName();
		return departmentName;
	}

	public void setName(String teacherName) {
		this.teacherName = teacherName;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		if (hourlySalary > 0) {
			this.hourlySalary = hourlySalary;
		} else {
			throw new IllegalArgumentException("Salary Needs To Be A Positive Value!");	
		}
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<Course> getTeachingCourses() {
		return teachingCourses;
	}

	public void addCourse(ArrayList<Course> teachingCourses) {
		this.teachingCourses = teachingCourses;
	}

	public ArrayList<Course> getResponsibleFor() {
		return responsibleFor;
	}

	public void setResponsibleFor(ArrayList<Course> responsibleFor) {
		this.responsibleFor = responsibleFor;
	}
	

	// other methods

	public void addTeachingCourse(Course course) {
		teachingCourses.add(course);
	}

	public void removeTeachingCourse(Course course) {
		teachingCourses.remove(course);
	}

	public Course findTeachingCourse(String courseCode) {
		for (Course tmpcourse : teachingCourses) {
			if (tmpcourse.getCourseCode().equals(courseCode)) {
				return tmpcourse;

			}
		}
		return null;
	}

	public void addResponsibleFor(Course course) {

		if (responsibleFor.size() >= 3) {
			throw new IllegalArgumentException("A Teacher May Not Be Responible\nFor More Than 3 Courses");
		} else if (course.getCredits() + course.getResponsible().calculateTotalResponsibleForCredits() > 30) {
			throw new IllegalArgumentException("You Can Not Have Courses That \nExcedes 30 Credits Together!");
		} else {
			responsibleFor.add(course);
		}
	}

	public void removeResponsibleFor(Course course) {
		responsibleFor.remove(course);
	}

	public Course findResponsibleFor(String courseCode) {
		for (Course tmpcourse : responsibleFor) {
			if (tmpcourse.getCourseCode().equals(courseCode)) {
				return tmpcourse;

			}
		}
		return null;
	}
	


	public int calculateAllHoursTaught() {
		int totalHours = 0;
		for (Course course : teachingCourses) {
			if(course.getHoursTaught().get(this) != null) {
			totalHours += course.getHoursTaught().get(this);
			}
		}
		return totalHours;
	}
	
	
	public int caluclateHoursTaughtOneCourse(Course courseName) {
		int hoursTaught = 0;
			for(Course course : teachingCourses) {
				for(Teacher teacher : course.getTeachingTeachers()) {
					if(course.equals(courseName)) {
					course.getHoursTaught().get(teacher);
				}	
				}
			}
			return hoursTaught;
	}

	public int calculateTotalResponsibleForCredits() {
		int totalCredits = 0;
		for (Course course : responsibleFor) {
			totalCredits += course.getCredits();
		}
		return totalCredits;
	}
	
	

}
