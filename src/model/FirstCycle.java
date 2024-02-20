package model;

public class FirstCycle extends Course{
	private String courseType = "First Cycle";
	
	public FirstCycle(String name, int credits, Department department, Teacher responsible) {
		super(name, credits, department, responsible);
	}
	
	public FirstCycle() {
	}

	public void addTeachingTeacher(Teacher teacher) {
		getTeachingTeachers().add(teacher);
	}

	public String getCourseType() {
		return courseType;
	}

}