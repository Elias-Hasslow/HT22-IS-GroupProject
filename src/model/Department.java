package model;

import java.util.ArrayList;
import java.util.Collections;

public class Department {
	private String depName;
	private String adress;
	private double budget;
	private DepartmentRegister depRegi;
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Teacher> employedTeachers = new ArrayList<Teacher>();
	
	
	// constructors 
	public Department () {
	}
	
	public Department(String depName, String address, double budget) {
		this.depName = depName;
		this.adress = address;
		this.budget = budget;
	}
	
	// getters and setters
	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		if (budget > 0) {
		this.budget = budget;
		} else {
			System.out.println("Budget needs to be a positive value");
		}
	}

	public ArrayList<Teacher> getEmployedTeachers() {
		return employedTeachers;
	}


	public void setEmployedTeachers(ArrayList<Teacher> employedTeachers) {
		this.employedTeachers = employedTeachers;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}	
	
	public DepartmentRegister getDepRegi() {
		return depRegi;
	}

	public void setDepRegi(DepartmentRegister depRegi) {
		this.depRegi = depRegi;
	}
	
	// other methods
	
	public void addCourse(Course course) {
		courses.add(course);
	}

	public void addEmployedTeacher(Teacher teacher) {
		employedTeachers.add(teacher);
	}
	
	public void removeEmployedTeacher(Teacher teacher) {
		employedTeachers.remove(teacher);
	}
	
	public Teacher findEmployedTeacher(String employeeName) {
		for (Teacher tmpteacher : employedTeachers) {
			if (tmpteacher.getTeacherName().equals(employeeName)) {
				return tmpteacher;
			}
		}
		return null;
	}

	
	public double calculateTotalCostForDepartment() {
		double total = 0;
		for(Teacher teacher : employedTeachers) {
				total += teacher.getHourlySalary() * teacher.calculateAllHoursTaught();
			}
		return total;
	}

	
	public double calculateDepartmentCost() {
		double cost = 0;
			for (Course course : courses) {
				cost += course.calculateCourseCost();
		}
		return cost;
	}
	
	public double costFirstCycle() {
		double costFirstCycle = 0;
			for(Course course : courses) {
				if(course instanceof FirstCycle) {
					costFirstCycle += course.calculateCourseCost();
				}
			}
		return costFirstCycle;
	}
	
	public double costSecondCycle() {
		double costFirstCycle = 0;
			for(Course course : courses) {
				if(course instanceof SecondCycle) {
					costFirstCycle += course.calculateCourseCost();
				}
			}
		return costFirstCycle;
	}
	
	public double costThirdCycle() {
		double costFirstCycle = 0;
			for(Course course : courses) {
				if(course instanceof ThirdCycle) {
					costFirstCycle += course.calculateCourseCost();
				}
			}
		return costFirstCycle;
	}
	
	public Double calculateMedianSalary () {
		Double median = (double) 0;
		ArrayList<Double> salaryList = new ArrayList<>();
			for(Teacher teacher : employedTeachers) {
			salaryList.add(teacher.calculateAllHoursTaught() * teacher.getHourlySalary());
			}
			Collections.sort(salaryList);
			int size = salaryList.size();
			if(salaryList.size() % 2 == 1) {
				int medianIndex = size / 2;
				median = Double.valueOf(salaryList.get(medianIndex));
			} else {
				int medianIndex = size / 2;
				   median = Double.valueOf(((medianIndex - 1) + salaryList.get(medianIndex)) / 2);
		    }
			return median;
	}
	
		public Double calculateAverageSalary () {
			Double totalSalary = (double) 0;
			for (Teacher teacher : employedTeachers) {
				totalSalary += teacher.getHourlySalary() * teacher.calculateAllHoursTaught();
			}
			return(totalSalary / employedTeachers.size());
		}
		
		public double calculateAverageCourseCost () {
			double TotalCost = 0;
			int amountOfCourses = courses.size();
			for (Course c : courses) {
				TotalCost += c.calculateCourseCost(); 
			}
			return (TotalCost / amountOfCourses);
		}
		
}
