package model;

public class SecondCycle extends Course{
	private String courseType = "Second Cycle";
	
	public SecondCycle(String name, int credits, Department department, Teacher responsible) {
		super(name, credits, department, responsible);
	}
	
	public SecondCycle() {
	}

	public void addTeachingTeacher(Teacher teacher) {
		getTeachingTeachers().add(teacher);
		}
	
	public String getCourseType() {
		return this.courseType;
	}
}