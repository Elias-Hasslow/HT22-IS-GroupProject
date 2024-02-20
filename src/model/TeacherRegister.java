package model;

import java.util.ArrayList;

public class TeacherRegister {
	private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();

	// getters & setters 
	
	public ArrayList<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	// other methods
	
	public void createTeacher(Teacher teacher) {
		this.teacherList.add(teacher);
	}

	public Teacher readTeacher(String teacherID) {
		for (Teacher teacher : teacherList) {
			if (teacher.getEmployeeID().equals(teacherID)) {
				return teacher;
			}
		}
		return null;
	}

	public void updateTeacher(String employeeID, String teacherName, String title, String adress, double hourlySalary) {
		for (Teacher tempTeacher : teacherList) {
			if (tempTeacher.getEmployeeID().equals(employeeID)) {
				tempTeacher.setAdress(adress);
				tempTeacher.setName(teacherName);
				tempTeacher.setTitle(title);
				tempTeacher.setHourlySalary(hourlySalary);
			}

		}
	}

	public void removeTeacher(String employeeID) {
		Teacher tmpTeacher = readTeacher(employeeID);
		
		if(tmpTeacher != null) {
			teacherList.remove(tmpTeacher);
		}
	}

	public Teacher findTeacherByName(String name) {
		for (Teacher teacher : teacherList) {
			if (teacher.getTeacherName().equals(name)) {
				return teacher;
			}
		}
		return null;
	}

}
