package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DepartmentRegister {
	  private ObservableList<Department> departmentList = FXCollections.observableArrayList();
	
	  
	  // getters & setters
	public ObservableList<Department> getDepartmentList() {
			return departmentList;
		}
		
	public void setDepartmentList(ObservableList<Department> departmentList) {
			this.departmentList = departmentList;
		}  
	
	// other methods
	  
	public void updateDepartment(String name, String adress, double budget) {
		for(Department temp : departmentList) {
			if(temp.getDepName().equals(name)) {
				temp.setAdress(adress);
				temp.setBudget(budget);
			}
		}
	}
	

	public void createDepartment (Department name) {
		this.departmentList.add(name);
	}

	public Department readDepartment(String depName) {
		for (Department department : departmentList) {
			if(department.getDepName().equals(depName)) {
				return department;
			}
		}
		return null;
	}
	
	public void removeDepartment(String depName) {
		Department tmpDepartment = readDepartment(depName);
		
		if (tmpDepartment!= null) {
			departmentList.remove(tmpDepartment);
		}
	}
	
	
	public double costAverageDepartment() {
		double cost = 0;
		int amountOfDepartments = departmentList.size();
			for (Department department : departmentList) {
				cost += department.calculateDepartmentCost();
			}
			return cost / amountOfDepartments;
	}
	
	
}
