package model;


public class ThirdCycle extends Course {
	private String courseType = "Third Cycle";


	public ThirdCycle(String name, int credits, Department department, Teacher responsible) {
		super(name, credits, department, responsible);
	}

	public ThirdCycle() {
	}

	public void addTeachingTeacher(Teacher teacher) {
		if (teacher.getTitle().equals("Professor") || teacher.getTitle().equals("Associate Professor")) {
			getTeachingTeachers().add(teacher);
		} else {
			System.out.println("You need to be Professor or Associate Professor to teach a Third Course");
		}

	}

	public void setResponsible(Teacher teacher) {
//		if (teacher.getTitle().equals("Professor") || teacher.getTitle().equals("Associate Professor")) {
			super.setResponsible(teacher);

	}
	
	public String getCourseType () {
		return this.courseType;
	}
}
