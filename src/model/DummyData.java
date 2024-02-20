package model;

public class DummyData {

	public static void main(String[] args) {
		DepartmentRegister depReg = new DepartmentRegister();
		
		Department IT = new Department("IT", "Lund", 10000);
		depReg.createDepartment(IT);
		
		Department HR = new Department("HT", "Lund", 20000);
		depReg.createDepartment(HR);
		
		
		Teacher micke = new Teacher("Micke Jonsson", "Professo", "Sobelgränd", 100, IT);
		Teacher bjorn = new Teacher("Björn Jonsson", "Professor", "Sobelgränd", 100, IT);
		ThirdCycle sys = new ThirdCycle("SYS", 20, IT, bjorn);
		IT.addCourse(sys);	

		IT.addEmployedTeacher(bjorn);
		IT.addEmployedTeacher(micke);
		
		sys.addTeacher(micke);
		micke.addTeachingCourse(sys);
		sys.addHours(micke, 10);
		
		sys.addTeacher(bjorn);
		bjorn.addTeachingCourse(sys);
		sys.addHours(bjorn, 10);
		


		System.out.println(IT.calculateDepartmentCost());
//		System.out.println(sys.calcuclateTeacherHours(micke.getTeacherName()));
		System.out.println(IT.calculateMedianSalary());
		


	}

}
