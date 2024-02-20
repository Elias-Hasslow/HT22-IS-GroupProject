package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Course;
import model.CourseRegister;
import model.Department;
import model.DepartmentRegister;
import model.FirstCycle;
import model.SecondCycle;
import model.Teacher;
import model.TeacherRegister;
import model.ThirdCycle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	// JavaFX's elements of the main menu layers
	@FXML
	private Button btnCourse;

	@FXML
	private Button btnDepartment;

	@FXML
	private Button btnEconomy;

	@FXML
	private Button btnTeacher;

	@FXML
	private Label labelStatus;

	@FXML
	private Label labelStatusMini;

	@FXML
	private Pane panelStatus;

	@FXML
	private Pane panelEconomy;
	@FXML
	private GridPane panelDepartment;

	@FXML
	private GridPane panelCourse;
	@FXML
	private GridPane panelTeacher;

	// ************************************
	// Department JavaFX elements
	@FXML
	private TextField insertDepartmentName;

	@FXML
	private TextField insertDepartmentAdress;

	@FXML
	private TextField insertCreatedDepartmentName;

	@FXML
	private TextField insertDepartmentBudget;

	@FXML
	private TextField readDepartment;

	@FXML
	private Button btnCreateDepartment;

	@FXML
	private Button btnReadDepartment;

	@FXML
	private Button btnDeleteDepartment;

	@FXML
	private Button btnUpdateDepartment;

	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, String> columnDepartmentName;

	@FXML
	private TableColumn<Department, String> columnDepartmentAdress;

	@FXML
	private TableColumn<Department, Double> columnDepartmentBudget;

	@FXML
	private Label economyDisplayLabel;

	@FXML
	private Button btnCreateCourse;

	@FXML
	private Button btnReadCourse;

	@FXML
	private Button btnDeleteCourse;

	@FXML
	private Button btnUpdateCourse;

	@FXML
	private TextField textFieldInsertCourseCredits;

	@FXML
	private TextField textFieldInsertResposibleTeacher;

	@FXML
	private TextField textFieldInsertCourseCode;

	@FXML
	private TextField textFieldInsertCourseName;

	@FXML
	private TableView<Course> tableViewCourse;

	@FXML
	private TableColumn<Course, String> tableColumnCourseCode;

	@FXML
	private TableColumn<Course, String> tableColumnCourseName;

	@FXML
	private TableColumn<Course, Integer> tableColumnCourseCredits;

	@FXML
	private TableColumn<Course, String> tableColumnCourseResponsibleTeacher;

	@FXML
	private TableColumn<Course, String> columnCourseDepartmentName;

	@FXML
	private TextField textFieldInsertEmployeeID;

	@FXML
	private TextField textFieldInsertTeacherName;

	@FXML
	private TextField textFieldInsertTeacherAdress;

	@FXML
	private TextField textFieldInsertTeacherSalary;

	@FXML
	private Button btnCreateTeacher;

	@FXML
	private Button btnReadTeacher;

	@FXML
	private Button btnDeleteTeacher;

	@FXML
	private Button btnUpdateTeacher;

	@FXML
	private TableView<Teacher> tableViewDepartmentEmployees;

	@FXML
	private TableColumn<Teacher, String> tableColumnDepartmentEmployees;

	@FXML
	private TableView<Teacher> tableViewCourseTeachers;

	@FXML
	private TableColumn<Teacher, String> tableColumnCourseTeachers;

	@FXML
	private TableView<Teacher> tableViewTeacher;

	@FXML
	private TableColumn<Teacher, String> tableColumnTeacherID;

	@FXML
	private TableColumn<Teacher, String> tableColumnTeacherName;

	@FXML
	private TableColumn<Teacher, String> tableColumnTeacherTitle;

	@FXML
	private TableColumn<Teacher, String> tableColumnTeacherAdress;

	@FXML
	private TableColumn<Teacher, String> tableColumnTeachersDepartment;

	@FXML
	private TableColumn<Teacher, Double> tableColumnTeacherSalary;

	@FXML
	private ComboBox<String> comboBoxTeacherTitle;

	@FXML
	private ComboBox<String> comboBoxDepartment;

	@FXML
	private ComboBox<String> comboBoxTeacher;

	@FXML
	private ComboBox<String> comboBoxCourse;

	@FXML
	private ComboBox<String> comboBoxDepartmentToCalculate;

	@FXML
	private ComboBox<String> comboBoxCalculateCourseCost;

	@FXML
	private ComboBox<String> comboBoxCourseToCalculate;

	@FXML
	private Button buttonCalculateEconomyTop;

	@FXML
	private Button buttonCalculateEconomyMiddle;

	@FXML
	private Button buttonCalculateEconomyBottom;

	@FXML
	private Label resultFromCalculationTop;

	@FXML
	private Label resultFromCalculationMiddle;

	@FXML
	private Label resultFromCalculationBottom;

	@FXML
	private ComboBox<String> comboBoxResponsibleTeacher;

	@FXML
	private ComboBox<String> comboBoxCourseType;

	@FXML
	private ComboBox<String> comboBoxCourseDepartment;

	@FXML
	private ComboBox<String> comboBoxTeacherChooseDepartment;

	@FXML
	private ComboBox<String> comboBoxTeacherAddHours;

	@FXML
	private ComboBox<String> comboBoxCourseAddHours;

	@FXML
	private Button btnAddHours;

	@FXML
	private TextField textFieldInsertHoursWorked;

	@FXML
	private Label departmentDisplayLabel;

	@FXML
	private Label teacherDisplayLabel;

	@FXML
	private Label courseDisplayLabel;

	@FXML
	private Button btnAddTeacherToCourse;

	@FXML
	private ComboBox<String> comboBoxCourseAddTeacher;

	@FXML
	private ComboBox<String> comboBoxTeacherAddTeacher;

	@FXML
	private Button btnReadDepartmentEconomy;

	@FXML
	private Button btnReadCourseEconomy;

	private ObservableList<Course> courseData = FXCollections.observableArrayList();
	private ObservableList<Teacher> teacherData = FXCollections.observableArrayList();
	private ObservableList<Department> departmentData = FXCollections.observableArrayList();
	private ObservableList<Teacher> departmentTeachers = FXCollections.observableArrayList();
	private ObservableList<Teacher> courseTeacherList = FXCollections.observableArrayList();

	private DepartmentRegister depReg = new DepartmentRegister();
	private CourseRegister couReg = new CourseRegister();
	private TeacherRegister teaReg = new TeacherRegister();

	// Button handler and layer handler for main menu
	@FXML
	private void buttonClickHandler(ActionEvent event) {
		if (event.getSource() == btnDepartment) {
			labelStatusMini.setText("/home/department");
			labelStatus.setText("Department");
			panelStatus.setBackground(
					new Background(new BackgroundFill(Color.rgb(88, 140, 224), CornerRadii.EMPTY, Insets.EMPTY)));
			panelDepartment.toFront();
			panelDepartment.setVisible(true);
			panelTeacher.setVisible(false);
			panelCourse.setVisible(false);
			panelEconomy.setVisible(false);

		} else if (event.getSource() == btnTeacher) {
			labelStatusMini.setText("/home/teacher");
			labelStatus.setText("Teacher");
			panelStatus.setBackground(
					new Background(new BackgroundFill(Color.rgb(88, 206, 224), CornerRadii.EMPTY, Insets.EMPTY)));
			panelTeacher.toFront();
			panelTeacher.setVisible(true);
			panelDepartment.setVisible(false);
			panelCourse.setVisible(false);
			panelEconomy.setVisible(false);

		} else if (event.getSource() == btnCourse) {
			labelStatusMini.setText("/home/course");
			labelStatus.setText("Course");
			panelStatus.setBackground(
					new Background(new BackgroundFill(Color.rgb(224, 113, 88), CornerRadii.EMPTY, Insets.EMPTY)));
			panelCourse.toFront();
			panelCourse.setVisible(true);
			panelDepartment.setVisible(false);
			panelTeacher.setVisible(false);
			panelEconomy.setVisible(false);

		} else if (event.getSource() == btnEconomy) {
			labelStatusMini.setText("/home/economy");
			labelStatus.setText("Economy");
			panelStatus.setBackground(
					new Background(new BackgroundFill(Color.rgb(88, 224, 133), CornerRadii.EMPTY, Insets.EMPTY)));
			panelCourse.toFront();
			panelEconomy.setVisible(true);
			panelCourse.setVisible(false);
			panelDepartment.setVisible(false);
			panelTeacher.setVisible(false);

		}
	}

	// ****************************************************************
	// Department Methods

	@FXML
	public void btnCreateDepartment_Click(ActionEvent event) {
		try {
			String departmentName = insertDepartmentName.getText();
			String departmentAdress = insertDepartmentAdress.getText();
			double departmentBudget = Double.parseDouble(insertDepartmentBudget.getText());
			if (depReg.readDepartment(departmentName) == null) {
				Department tmpDepartment = new Department();
				tmpDepartment.setDepName(departmentName);
				tmpDepartment.setAdress(departmentAdress);
				tmpDepartment.setBudget(departmentBudget);
				tmpDepartment.setDepRegi(depReg);
				depReg.createDepartment(tmpDepartment);
				tmpDepartment.setDepRegi(depReg);
				departmentData.add(tmpDepartment);
				comboBoxTeacherChooseDepartment.getItems().add(departmentName);
				comboBoxCourseDepartment.getItems().add(departmentName);
				comboBoxDepartmentToCalculate.getItems().add(departmentName);
				departmentDisplayLabel.setText("Department Added Succesfully!");

			} else {
				departmentDisplayLabel.setText("Department with that name alredy exists");
			}
			insertDepartmentName.clear();
			insertDepartmentAdress.clear();
			insertDepartmentBudget.clear();
		} catch (NumberFormatException e) {
			departmentDisplayLabel.setText("Make Sure You Entered All Required\nFields And Budget As A Number!");
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
	}

	@FXML
	public void btnDeleteDepartment_Click(ActionEvent event) {
		try {
			// Search for the department object
			Department department = depReg.readDepartment(insertCreatedDepartmentName.getText());
			if (department != null) {
				// Remove the object from the departmentData list and the depReg object
				comboBoxCourseDepartment.getItems().remove(department.getDepName());
				comboBoxDepartmentToCalculate.getItems().remove(department.getDepName());
				comboBoxTeacherChooseDepartment.getItems().remove(department.getDepName());
				departmentData.remove(department);
				depReg.removeDepartment(department.getDepName());
				departmentDisplayLabel.setText("Department Deleted Succesfully!");
				// Set the object to null
				department = null;
			} else {
				departmentDisplayLabel.setText("No Department With That Name Exists!");
			}
			insertCreatedDepartmentName.clear();
			tableViewDepartment.refresh();
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
	}

	@FXML
	public void btnUpdateDepartment_Click(ActionEvent event) {
		try {
			String departmentName = insertDepartmentName.getText();
			double depBud = Double.parseDouble(insertDepartmentBudget.getText());
			String depAdi = insertDepartmentAdress.getText();

			for (Department department : depReg.getDepartmentList()) {
				if (department.getDepName().equals(departmentName)) {

					depReg.updateDepartment(departmentName, depAdi, depBud);
					tableViewDepartment.refresh();

					insertDepartmentAdress.clear();
					insertDepartmentBudget.clear();
					departmentDisplayLabel.setText("The Department: " + department.getDepName() + "\nHas Now Been Updated!");
					insertDepartmentName.clear();
				} else {
					departmentDisplayLabel.setText("There Is No Department With That Name!");
					insertDepartmentName.clear();
					insertDepartmentAdress.clear();
					insertDepartmentBudget.clear();
				}

			}
		} catch (NumberFormatException e) {
			departmentDisplayLabel.setText("Make Sure To Enter All Reqired Fields!");
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
	}

	// **************************************************************************
	// Teacher Methods

	public void btnCreateTeacher_Click(ActionEvent event) {
		try {

			if (comboBoxTeacherChooseDepartment.getValue() == "Choose Department"
					|| comboBoxTeacherTitle.getValue() == "Choose Teachers Title"
					|| comboBoxTeacherTitle.getValue() == null) {
				teacherDisplayLabel.setText("You Have To Choose An Department \nOr Title!");
			} else {
				String teacherName = textFieldInsertTeacherName.getText();
				String teacherAddress = textFieldInsertTeacherAdress.getText();
				String teacherTitle = comboBoxTeacherTitle.getValue();
				double teacherSalary = Integer.parseInt(textFieldInsertTeacherSalary.getText());

				Teacher tmpTeacher = new Teacher(teacherName, teacherTitle, teacherAddress, teacherSalary,
						depReg.readDepartment(comboBoxTeacherChooseDepartment.getValue()));
				tmpTeacher.setHourlySalary(teacherSalary);
				teaReg.createTeacher(tmpTeacher);
				depReg.readDepartment(comboBoxTeacherChooseDepartment.getValue()).addEmployedTeacher(tmpTeacher);
				teacherData.add(tmpTeacher);
				comboBoxResponsibleTeacher.getItems().add(teacherName);
				comboBoxTeacherAddHours.getItems().add(teacherName);
				comboBoxTeacherAddTeacher.getItems().add(teacherName);

				textFieldInsertTeacherName.clear();
				textFieldInsertTeacherAdress.clear();
				textFieldInsertTeacherSalary.clear();
				teacherDisplayLabel
						.setText("Teacher: " + tmpTeacher.getTeacherName() + "\nWas Created And Added To Department: "
								+ comboBoxTeacherChooseDepartment.getValue() + " \nSuccesfully!");

				comboBoxTeacherTitle.setValue("Choose Teachers Title");
				comboBoxTeacherChooseDepartment.setValue("Choose Department");
			}

		} catch (StringIndexOutOfBoundsException exception) {
			teacherDisplayLabel.setText("Your Firstname And Lastname Must\nBe Atleast Two Characters Long!");
		} catch (ArrayIndexOutOfBoundsException exception) {
			teacherDisplayLabel.setText("Make Sure You Enter Your First And Last Name!");
		} catch (NullPointerException exception) {
			teacherDisplayLabel.setText("Make Sure You Choose An Department To Work At!");
		} catch (NumberFormatException exception) {
			teacherDisplayLabel.setText(
					"Make Sure You Entered All Required Fields \nIncluding EmployeeID \nAnd Salary As A Number!");
		} catch (IllegalArgumentException e) {
			teacherDisplayLabel.setText(e.getMessage());
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
	}

	@FXML
	public void btnUpdateTeacherInfo_Click(ActionEvent event) {
		try {
			String teacherName = textFieldInsertTeacherName.getText();
			double teacherSalary = Double.parseDouble(textFieldInsertTeacherSalary.getText());
			String employeeID = textFieldInsertEmployeeID.getText();
			String teacherTitle = comboBoxTeacherTitle.getValue();
			String teacherAdress = textFieldInsertTeacherAdress.getText();

			for (Teacher T : teaReg.getTeacherList()) {
				if (T.getEmployeeID().equals(employeeID)) {
					comboBoxResponsibleTeacher.getItems().remove(T.getTeacherName());
					teaReg.updateTeacher(employeeID, teacherName, teacherTitle, teacherAdress, teacherSalary);
					comboBoxResponsibleTeacher.getItems().add(textFieldInsertTeacherName.getText());
					tableViewTeacher.refresh();
					textFieldInsertEmployeeID.clear();
					textFieldInsertTeacherSalary.clear();
					textFieldInsertTeacherName.clear();
					textFieldInsertTeacherAdress.clear();
					comboBoxTeacherTitle.setValue("Choose Teachers Title");
					comboBoxTeacherChooseDepartment.setValue("Choose Department");
					teacherDisplayLabel.setText("Teacher: " + T.getEmployeeID() + "\nHas Been Updated Succesfully!");
				} else {
					teacherDisplayLabel.setText(
							"You Also Need The EmployeeID Of The\nTeacher Whos Information You\nWant To Update!");
				}
			}
		} catch (NumberFormatException e) {
			teacherDisplayLabel
					.setText("Make Sure to Enter all Required Fields \nFor An Update And Salary \nAs A Number!");
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}

	}

	@FXML
	public void btnRemoveTeacher_Click(ActionEvent event) {

		try {
			Teacher teacher = teaReg.readTeacher(textFieldInsertEmployeeID.getText());

			if (teacher.getResponsibleFor() != null) {
				teacherDisplayLabel.setText(
						"Dont Forget To Update Responisble Teacher For\nThe Course That The Teacher You \nRemoved Was Responsiible For");

				if (teacher != null) {
					for (Course course : teacher.getResponsibleFor()) {
						course.setResponsible(null);
					}

					comboBoxResponsibleTeacher.getItems().remove(teacher.getTeacherName());
					teacherData.remove(teacher);
					teaReg.removeTeacher(teacher.getEmployeeID());

					teacher = null;

				}
			} else {
				teacherDisplayLabel.setText("There Is No Teacher With That Id!");

			}
			tableViewCourse.refresh();
			textFieldInsertEmployeeID.clear();
			textFieldInsertEmployeeID.clear();
			textFieldInsertTeacherSalary.clear();
			textFieldInsertTeacherName.clear();
			textFieldInsertTeacherAdress.clear();
			comboBoxTeacherTitle.setValue("Choose Teachers Title");
			comboBoxTeacherChooseDepartment.setValue("Choose Department");
			tableViewTeacher.refresh();

		} catch (NullPointerException e) {
			teacherDisplayLabel.setText(
					"Dont Forget To Update Responisble Teacher For\nThe Course That The Teacher You \nRemoved Was Responsiible For");
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
	}

	public void btnAddHours_Click(ActionEvent event) {

		try {
			int hours = Integer.parseInt(textFieldInsertHoursWorked.getText());
			int totalHours = 0;

			totalHours += couReg.findCourseByName(comboBoxCourseAddHours.getValue()).calcuclateTeacherHours(
					teaReg.findTeacherByName(comboBoxTeacherAddHours.getValue()).getTeacherName()) + hours;

			if (totalHours <= 3600) {
				if (couReg.findCourseByName(comboBoxCourseAddHours.getValue()) instanceof FirstCycle) {
					FirstCycle tmp = new FirstCycle();
					tmp = (FirstCycle) couReg.findCourseByName(comboBoxCourseAddHours.getValue());
					tmp.addHours(teaReg.findTeacherByName(comboBoxTeacherAddHours.getValue()), hours);
					teacherDisplayLabel
							.setText("Added " + hours + " To " + comboBoxTeacherAddHours.getValue() + " Work time on "
									+ comboBoxCourseAddHours.getValue() + "\n" + "Total worktime on this course = "
									+ couReg.findCourseByName(comboBoxCourseAddHours.getValue())
											.calcuclateTeacherHours(comboBoxTeacherAddHours.getValue()));
				} else if (couReg.findCourseByName(comboBoxCourseAddHours.getValue()) instanceof SecondCycle) {
					SecondCycle tmp = new SecondCycle();
					tmp = (SecondCycle) couReg.findCourseByName(comboBoxCourseAddHours.getValue());
					tmp.addHours(teaReg.findTeacherByName(comboBoxTeacherAddHours.getValue()), hours);
					teacherDisplayLabel
							.setText("Added " + hours + " To " + comboBoxTeacherAddHours.getValue() + " Work time on "
									+ comboBoxCourseAddHours.getValue() + "\n" + "Total worktime on this course = "
									+ couReg.findCourseByName(comboBoxCourseAddHours.getValue())
											.calcuclateTeacherHours(comboBoxTeacherAddHours.getValue()));

				} else if (couReg.findCourseByName(comboBoxCourseAddHours.getValue()) instanceof ThirdCycle) {
					ThirdCycle tmp = new ThirdCycle();
					tmp = (ThirdCycle) couReg.findCourseByName(comboBoxCourseAddTeacher.getValue());
					tmp.addHours(teaReg.findTeacherByName(comboBoxTeacherAddHours.getValue()), hours);
					teacherDisplayLabel
							.setText("Added " + hours + " To " + comboBoxTeacherAddHours.getValue() + " Work time on "
									+ comboBoxCourseAddHours.getValue() + "\n" + "Total worktime on this course = "
									+ couReg.findCourseByName(comboBoxCourseAddHours.getValue())
											.calcuclateTeacherHours(comboBoxTeacherAddHours.getValue()));

				} else {
					teacherDisplayLabel.setText("Make Sure To Select Teacher And\nCourse For Adding Hours!");
				}

			} else {
				teacherDisplayLabel.setText("A teacher may only teach 3600 hours");
			}
		} catch (NumberFormatException e) {
			teacherDisplayLabel.setText("Make Sure To Input All Fields\nWhen Adding Hours!");
		} catch (NullPointerException e) {
			teacherDisplayLabel
					.setText("Make Sure That The Teacher You Want\nTo Add Hours To Is Actually\nTeaching That Course!");
		}
	}

	// **************************************************************************
	// Economy Methods

	@FXML
	public void btnCalculateEconomyTop_Click(ActionEvent event) {

		try {
			// For department
			if (comboBoxDepartment.getValue().equals("Calculate the total cost for a given department")
					&& comboBoxDepartmentToCalculate != null) {
				Department tmpDepartment = new Department();
				tmpDepartment = depReg.readDepartment(comboBoxDepartmentToCalculate.getValue());
				String output = String.valueOf(tmpDepartment.calculateTotalCostForDepartment());
				resultFromCalculationTop.setText(output);
				System.out.println();

			} else if (comboBoxDepartment.getValue().equals("Calculate the average course cost for a given department")
					&& comboBoxDepartmentToCalculate != null) {
				Department tmpDepartment = new Department();
				tmpDepartment = depReg.readDepartment(comboBoxDepartmentToCalculate.getValue());
				String output = String.valueOf(tmpDepartment.calculateAverageCourseCost());
				resultFromCalculationTop.setText(output);
			} else if (comboBoxDepartment.getValue()
					.equals("Show the median salary for teachers at a certain department")
					&& comboBoxDepartmentToCalculate != null) {
				Department tmpDepartment = new Department();
				tmpDepartment = depReg.readDepartment(comboBoxDepartmentToCalculate.getValue());
				String output = String.valueOf(tmpDepartment.calculateMedianSalary());
				resultFromCalculationTop.setText(output);
				System.out.println(output + " Tomt?");
			} else if (comboBoxDepartment.getValue().equals("Calculate the cost for all courses at a given department")
					&& comboBoxDepartmentToCalculate != null) {
				for (Department department : depReg.getDepartmentList()) {
					if (comboBoxCourseToCalculate.getValue().equals(department.getDepName())) {
						String output = String.valueOf(department.calculateDepartmentCost());
						resultFromCalculationTop.setText(output);
					}
				}
			} else if (comboBoxDepartment.getValue()
					.equals("Calculate the cost for all first cycle courses at a given department")
					&& comboBoxDepartmentToCalculate != null) {
				for (Department department : depReg.getDepartmentList()) {
					if (comboBoxCourseToCalculate.getValue().equals(department.getDepName())) {
						String output = String.valueOf(department.costFirstCycle());
						resultFromCalculationTop.setText(output);
					}
				}
			} else if (comboBoxDepartment.getValue()
					.equals("Calculate the cost for all second cycle courses at a given department")
					&& comboBoxDepartmentToCalculate != null) {
				for (Department department : depReg.getDepartmentList()) {
					if (comboBoxCourseToCalculate.getValue().equals(department.getDepName())) {
						String output = String.valueOf(department.costSecondCycle());
						resultFromCalculationTop.setText(output);
					}
				}
			} else if (comboBoxDepartment.getValue()
					.equals("Calculate the cost for all third cycle courses at a given department")
					&& comboBoxDepartmentToCalculate != null) {
				for (Department department : depReg.getDepartmentList()) {
					if (comboBoxCourseToCalculate.getValue().equals(department.getDepName())) {
						String output = String.valueOf(department.costThirdCycle());
						resultFromCalculationTop.setText(output);
					}
				}
			}

		} catch (NullPointerException exception) {
			economyDisplayLabel.setText("Make sure you choose what you would\nlike to calculate and a department");
		}
	}

	public void btnCalculateCourseCost_Click() {
		if (couReg.findCourseByName(comboBoxCalculateCourseCost.getValue()) instanceof FirstCycle) {
			FirstCycle tmpCourse = new FirstCycle();
			tmpCourse = (FirstCycle) couReg.findCourseByName(comboBoxCalculateCourseCost.getValue());
			String output = String.valueOf(tmpCourse.calculateCourseCost());
			resultFromCalculationMiddle.setText(output);
		} else if (couReg.findCourseByName(comboBoxCalculateCourseCost.getValue()) instanceof SecondCycle) {
			SecondCycle tmpCourse = new SecondCycle();
			tmpCourse = (SecondCycle) couReg.findCourseByName(comboBoxCalculateCourseCost.getValue());

			String output = String.valueOf(tmpCourse.calculateCourseCost());
			resultFromCalculationMiddle.setText(output);
		} else if (couReg.findCourseByName(comboBoxCalculateCourseCost.getValue()) instanceof ThirdCycle) {
			ThirdCycle tmpCourse = new ThirdCycle();
			tmpCourse = (ThirdCycle) couReg.findCourseByName(comboBoxCalculateCourseCost.getValue());
			String output = String.valueOf(tmpCourse.calculateCourseCost());
			resultFromCalculationMiddle.setText(output);
			System.out.println(output);
		}
	}

	// **************************************************************************
	// Course Methods

	public void btnCreateCourse_Click(ActionEvent event) {

		try {
			String courseName = textFieldInsertCourseName.getText();
			int courseCredits = Integer.parseInt(textFieldInsertCourseCredits.getText());

			Teacher teacher = teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue());
			if (comboBoxResponsibleTeacher.getValue() == "Responsible Teacher"
					|| comboBoxCourseDepartment.getValue() == "Choose Department"
					|| comboBoxCourseType.getValue() == "Course Type") {
				courseDisplayLabel.setText(
						"You Have To Choose A Actuall Option As\nResponsible Teacher, Department\nOr Course type!");
			} else {
				if (couReg.findCourseByName(courseName) == null) {

					if (comboBoxCourseType.getValue().equals("First Cycle")
							&& teacher.getDepartment().getDepName().equals(comboBoxCourseDepartment.getValue())) {
						FirstCycle tmpCourse = new FirstCycle(courseName, courseCredits,
								depReg.readDepartment(comboBoxCourseDepartment.getValue()),
								teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()));
						teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()).addResponsibleFor(tmpCourse);
						depReg.readDepartment(comboBoxCourseDepartment.getValue()).addCourse(tmpCourse);
						tmpCourse.setCouRegi(couReg);
						depReg.readDepartment(comboBoxCourseDepartment.getValue()).addCourse(tmpCourse);
						couReg.createCourse(tmpCourse);
						courseData.add(tmpCourse);
						courseDisplayLabel.setText("Course Created Succesfully!");
						comboBoxCourseAddHours.getItems().add(courseName);
						comboBoxCourseAddTeacher.getItems().add(courseName);
						comboBoxCalculateCourseCost.getItems().add(courseName);

					} else if (comboBoxCourseType.getValue().equals("Second Cycle")
							&& teacher.getDepartmentName().equals(comboBoxCourseDepartment.getValue())) {
						SecondCycle tmpCourse = new SecondCycle(courseName, courseCredits,
								depReg.readDepartment(comboBoxCourseDepartment.getValue()),
								teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()));
						teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()).addResponsibleFor(tmpCourse);
						depReg.readDepartment(comboBoxCourseDepartment.getValue()).addCourse(tmpCourse);
						tmpCourse.setCouRegi(couReg);
						couReg.createCourse(tmpCourse);
						courseData.add(tmpCourse);
						courseDisplayLabel.setText("Course Created Succesfully!");
						comboBoxCourseAddHours.getItems().add(courseName);
						comboBoxCourseAddTeacher.getItems().add(courseName);
						comboBoxCalculateCourseCost.getItems().add(courseName);

					} else if (comboBoxCourseType.getValue().equals("Third Cycle")
							&& teacher.getDepartmentName().equals(comboBoxCourseDepartment.getValue())) {
						if (teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()).getTitle()
								.equals("Professor")
								|| teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()).getTitle()
										.equals("Associate Professor")) {
							ThirdCycle tmpCourse = new ThirdCycle(courseName, courseCredits,
									depReg.readDepartment(comboBoxCourseDepartment.getValue()),
									teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()));
							teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue())
									.addResponsibleFor(tmpCourse);
							depReg.readDepartment(comboBoxCourseDepartment.getValue()).addCourse(tmpCourse);
							tmpCourse.setCouRegi(couReg);
							couReg.createCourse(tmpCourse);
							courseData.add(tmpCourse);
							courseDisplayLabel.setText("Course Created Succesfully!");
							comboBoxCourseAddHours.getItems().add(courseName);
							comboBoxCourseAddTeacher.getItems().add(courseName);
							comboBoxCalculateCourseCost.getItems().add(courseName);

						} else {
							// error message
							courseDisplayLabel.setText(
									"You Have To Be Professor Or \nAssociate Professor To Be In Charge For \nA Third Cycle Course!");
						}
					} else {
						courseDisplayLabel.setText(
								"The teacher you selected as responsible\ndoesn't belong to that department.\nPlease choose the correct department");
					}

				} else {
					courseDisplayLabel.setText("A Course With That Name Already Exists!");

				}

				comboBoxResponsibleTeacher.setValue("Responsible Teacher");
				comboBoxCourseDepartment.setValue("Choose Department");
				comboBoxCourseType.setValue("Course Type");
				textFieldInsertCourseName.clear();
				textFieldInsertCourseCredits.clear();
			}

		} catch (NumberFormatException e) {
			courseDisplayLabel.setText("Make Sure To Enter All Fields \nAnd Credits As A Number!");
		} catch (NullPointerException e) {
			courseDisplayLabel.setText("Make Sure You Choose From All \nDropdown Menus!");
		} catch (IllegalArgumentException e) {
			if (e.getMessage().equals("You Can Not Have Courses That \nExcedes 30 Credits Together!")) {
				courseDisplayLabel.setText(e.getMessage());
			} else if (e.getMessage().equals("You Cannot Have Courses Adding \nUpp To Over 30 Credis!")) {
				courseDisplayLabel.setText(e.getMessage());
			} else {
				courseDisplayLabel.setText(e.getMessage());
				;
			}
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
	}

	@FXML
	private void btnDeleteCourse_Click(ActionEvent event) {
		try {
			Course course = couReg.readCourse(textFieldInsertCourseCode.getText());
			if (course != null) {
				courseData.remove(course);
				couReg.removeCourse(course.getCourseCode());
				comboBoxCourseAddHours.getItems().remove(course.getCourseName());
				courseDisplayLabel.setText(
						"Course: " + textFieldInsertCourseCode.getText() + " \nHas Been Removed Successfully!");
				for (Teacher T : teaReg.getTeacherList()) {
					T.removeResponsibleFor(course);
				}
				course = null;
			} else {
				courseDisplayLabel.setText("The Course Code Is Invalid!");
				textFieldInsertCourseCode.clear();
			}
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");

		}
	}

	@FXML
	private void btnUpdateCourse_Click(ActionEvent event) {
		try {
			if (comboBoxResponsibleTeacher.getValue() == "Responsible Teacher"
					|| comboBoxCourseDepartment.getValue() == "Choose Department"
					|| comboBoxCourseType.getValue() == "Course Type") {
				courseDisplayLabel.setText(
						"You Have To Choose An Actuall Option As\nResponsible Teacher, Department\nOr Course type!");
			} else {

				String couName = textFieldInsertCourseName.getText();
//		int couCredits = Integer.parseInt(textFieldInsertCourseCredits.getText());
				String couCode = textFieldInsertCourseCode.getText();
				String cRT = comboBoxResponsibleTeacher.getValue();
				String cCT = comboBoxCourseType.getValue();
				String cD = comboBoxCourseDepartment.getValue();

				boolean a = (couName != "");
				boolean b = (textFieldInsertCourseCredits.getText().isEmpty());
				boolean d = (cRT != null);
				boolean e = (cCT != null);
				boolean f = (cD != null);

				for (Course course : couReg.getCourseRegister()) {
					if (course.getCourseCode().equals(couCode)) {
						if (a) {
							course.setCourseName(couName);
						} else if (!a) {
							courseDisplayLabel.setText("Course updated successfully!");
						}
						if (!b) {
							course.setCredits(Integer.parseInt(textFieldInsertCourseCredits.getText()));
						} else if (b) {
							courseDisplayLabel.setText("Course updated successfully!");
						}
						if (d && (teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()).getTitle()
								.equals("Professor")
								|| teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()).getTitle()
										.equals("Associate Professor"))) {
							course.setResponsible(teaReg.findTeacherByName(cRT));
						} else if (comboBoxResponsibleTeacher.getValue() == null
								&& teaReg.findTeacherByName(comboBoxResponsibleTeacher.getValue()) == null) {
							courseDisplayLabel.setText("Update Succesful!");
						}
						if (e) {
							courseDisplayLabel.setText("You Can Not Change The Course Type!");
						}
						if (f) {
							courseDisplayLabel.setText(
									"Update Succesfull But Cycle \nAnd Department Was NOT\nUpdated Since You Can't Change These!");
						}
					} else {
						courseDisplayLabel.setText("Make Sure You Also Enter\nThe Correct Course Code");
					}
				}
				tableViewCourse.refresh();
				textFieldInsertCourseName.clear();
				textFieldInsertCourseCredits.clear();
			}
		} catch (NumberFormatException e) {
			courseDisplayLabel.setText("Please Enter Credits As A Number");
		} catch (Exception e) {
			departmentDisplayLabel.setText("Oops Something went Wrong, Try Agian\nOr Contact Our Support!");
		}
		tableViewCourse.refresh();
		textFieldInsertCourseName.clear();
		textFieldInsertCourseCredits.clear();
	}

	public void btnAddTeacherToCourse_Click(ActionEvent event) {
		try {
			if (couReg.findCourseByName(comboBoxCourseAddTeacher.getValue()) instanceof FirstCycle) {
				FirstCycle tmp = new FirstCycle();
				tmp = (FirstCycle) couReg.findCourseByName(comboBoxCourseAddTeacher.getValue());
				tmp.addTeacher(teaReg.findTeacherByName(comboBoxTeacherAddTeacher.getValue()));
				courseDisplayLabel.setText("Succesfully added "
						+ teaReg.findTeacherByName(comboBoxTeacherAddTeacher.getValue()).getTeacherName() + " to "
						+ couReg.findCourseByName(comboBoxCourseAddTeacher.getValue()).getCourseName());
			} else if (couReg.findCourseByName(comboBoxCourseAddTeacher.getValue()) instanceof SecondCycle) {
				SecondCycle tmp = new SecondCycle();
				tmp = (SecondCycle) couReg.findCourseByName(comboBoxCourseAddTeacher.getValue());
				tmp.addTeacher(teaReg.findTeacherByName(comboBoxTeacherAddTeacher.getValue()));
				courseDisplayLabel.setText("Succesfully added "
						+ teaReg.findTeacherByName(comboBoxTeacherAddTeacher.getValue()).getTeacherName() + " to "
						+ couReg.findCourseByName(comboBoxCourseAddTeacher.getValue()).getCourseName());

			} else if (couReg.findCourseByName(comboBoxCourseAddTeacher.getValue()) instanceof ThirdCycle) {
				ThirdCycle tmp = new ThirdCycle();
				tmp = (ThirdCycle) couReg.findCourseByName(comboBoxCourseAddTeacher.getValue());
				tmp.addTeacher(teaReg.findTeacherByName(comboBoxTeacherAddTeacher.getValue()));
				courseDisplayLabel.setText("Succesfully added "
						+ teaReg.findTeacherByName(comboBoxTeacherAddTeacher.getValue()).getTeacherName() + " to "
						+ couReg.findCourseByName(comboBoxCourseAddTeacher.getValue()).getCourseName());

			} else {
				courseDisplayLabel.setText("Make Sure To Enter All The Fields!");
			}
		} catch (NullPointerException e) {
			courseDisplayLabel.setText("Make Sure To Enter All The Fields!");
		}

	}

	public void btnReadDepartmentEconomy_Click(ActionEvent event) {
		if (comboBoxDepartmentToCalculate.getValue() != null) {
			departmentTeachers.clear();
			for (Teacher t : depReg.readDepartment(comboBoxDepartmentToCalculate.getValue()).getEmployedTeachers()) {
				departmentTeachers.add(t);
			}
		}
	}

	public void btnReadCourseEconomy_Click(ActionEvent event) {
		if (comboBoxCalculateCourseCost.getValue() != null) {
			courseTeacherList.clear();
			for (Teacher t : couReg.findCourseByName(comboBoxCalculateCourseCost.getValue()).getTeachingTeachers()) {
				courseTeacherList.add(t);
			}
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		panelDepartment.setVisible(true);
		panelTeacher.setVisible(false);
		panelCourse.setVisible(false);
		panelEconomy.setVisible(false);

		tableColumnDepartmentEmployees.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherName"));
		tableViewDepartmentEmployees.setItems(departmentTeachers);

		columnDepartmentName.setCellValueFactory(new PropertyValueFactory<Department, String>("depName"));
		columnDepartmentAdress.setCellValueFactory(new PropertyValueFactory<Department, String>("adress"));
		columnDepartmentBudget.setCellValueFactory(new PropertyValueFactory<Department, Double>("budget"));
		tableViewDepartment.setItems(departmentData);

		tableColumnTeacherID.setCellValueFactory(new PropertyValueFactory<Teacher, String>("employeeID"));
		tableColumnTeacherName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherName"));
		tableColumnTeacherTitle.setCellValueFactory(new PropertyValueFactory<Teacher, String>("title"));
		tableColumnTeacherAdress.setCellValueFactory(new PropertyValueFactory<Teacher, String>("adress"));
		tableColumnTeachersDepartment.setCellValueFactory(new PropertyValueFactory<Teacher, String>("departmentName"));
		tableColumnTeacherSalary.setCellValueFactory(new PropertyValueFactory<Teacher, Double>("hourlySalary"));
		tableViewTeacher.setItems(teacherData);

		tableColumnCourseCode.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
		tableColumnCourseName.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
		tableColumnCourseCredits.setCellValueFactory(new PropertyValueFactory<Course, Integer>("credits"));
		tableColumnCourseResponsibleTeacher
				.setCellValueFactory(new PropertyValueFactory<Course, String>("responsibleName"));
		columnCourseDepartmentName.setCellValueFactory(new PropertyValueFactory<Course, String>("departmentName"));

		tableColumnCourseTeachers.setCellValueFactory(null);

		tableViewCourse.setItems(courseData);

		comboBoxDepartment.getItems().addAll("Calculate the total cost for a given department",
				"Calculate the average course cost for a given departmet",
				"Calculate the cost for all courses at a given department",
				"Calculate the cost for a first cycle courses at a given department",
				"Calculate the cost for a second cycle courses at a given department",
				"Calculate the cost for a third cycle courses at a given department",
				"Show the median hourly salary for teachers at a certain department");

		comboBoxTeacherTitle.getItems().addAll("Choose Teachers Title", "Lecturer", "Assistant Professor",
				"Associate Professor", "Professor");
		comboBoxCourseType.getItems().addAll("Course Type", "First Cycle", "Second Cycle", "Third Cycle");
		comboBoxCourseDepartment.getItems().add("Choose Department");
		comboBoxResponsibleTeacher.getItems().addAll("Responsible Teacher");
		comboBoxTeacherChooseDepartment.getItems().addAll("Choose Department");

		tableColumnCourseTeachers.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherName"));
		tableViewCourseTeachers.setItems(courseTeacherList);

		// Dummy departments

		Department it = new Department("IT", "lund", 10000);
		depReg.createDepartment(it);
		it.setDepRegi(depReg);
		departmentData.add(it);
		comboBoxTeacherChooseDepartment.getItems().add(it.getDepName());
		comboBoxCourseDepartment.getItems().add(it.getDepName());
		comboBoxDepartmentToCalculate.getItems().add(it.getDepName());

		Department hr = new Department("HR", "lund", 15000);
		depReg.createDepartment(hr);
		hr.setDepRegi(depReg);
		departmentData.add(hr);
		comboBoxTeacherChooseDepartment.getItems().add(hr.getDepName());
		comboBoxCourseDepartment.getItems().add(hr.getDepName());
		comboBoxDepartmentToCalculate.getItems().add(hr.getDepName());

		Department pr = new Department("PR", "lund", 200000);
		depReg.createDepartment(pr);
		pr.setDepRegi(depReg);
		departmentData.add(pr);
		comboBoxTeacherChooseDepartment.getItems().add(pr.getDepName());
		comboBoxCourseDepartment.getItems().add(pr.getDepName());
		comboBoxDepartmentToCalculate.getItems().add(pr.getDepName());

		// Dummy teachers

		Teacher bjorn = new Teacher("Björn Svensson", "Professor", "Lund", 100, it);
		it.addEmployedTeacher(bjorn);
		bjorn.setTeaReg(teaReg);
		teaReg.createTeacher(bjorn);
		teacherData.add(bjorn);
		comboBoxResponsibleTeacher.getItems().add(bjorn.getTeacherName());
		comboBoxTeacherAddHours.getItems().add(bjorn.getTeacherName());
		comboBoxTeacherAddTeacher.getItems().add(bjorn.getTeacherName());

		Teacher micke = new Teacher("Micke Jonsson", "Professor", "Lund", 100, it);
		it.addEmployedTeacher(micke);
		micke.setTeaReg(teaReg);
		teaReg.createTeacher(micke);
		teacherData.add(micke);
		comboBoxResponsibleTeacher.getItems().add(micke.getTeacherName());
		comboBoxTeacherAddHours.getItems().add(micke.getTeacherName());
		comboBoxTeacherAddTeacher.getItems().add(micke.getTeacherName());

		Teacher johan = new Teacher("Johan Hasslow", "Professor", "Lund", 100, hr);
		hr.addEmployedTeacher(johan);
		johan.setTeaReg(teaReg);
		teaReg.createTeacher(johan);
		teacherData.add(johan);
		comboBoxResponsibleTeacher.getItems().add(johan.getTeacherName());
		comboBoxTeacherAddHours.getItems().add(johan.getTeacherName());
		comboBoxTeacherAddTeacher.getItems().add(johan.getTeacherName());

		Teacher elias = new Teacher("Elias Jensen", "Professor", "Lund", 100, pr);
		pr.addEmployedTeacher(elias);
		elias.setTeaReg(teaReg);
		teaReg.createTeacher(elias);
		teacherData.add(elias);
		comboBoxResponsibleTeacher.getItems().add(elias.getTeacherName());
		comboBoxTeacherAddHours.getItems().add(elias.getTeacherName());
		comboBoxTeacherAddTeacher.getItems().add(elias.getTeacherName());

		// Dummy Courses

		ThirdCycle sys = new ThirdCycle("SYS", 10, it, bjorn);
		bjorn.addResponsibleFor(sys);
		bjorn.addTeachingCourse(sys);
		sys.addTeachingTeacher(bjorn);
		sys.setCouRegi(couReg);
		it.addCourse(sys);
		couReg.createCourse(sys);
		courseData.add(sys);
		comboBoxCourseAddHours.getItems().add(sys.getCourseName());
		comboBoxCourseAddTeacher.getItems().add(sys.getCourseName());
		comboBoxCalculateCourseCost.getItems().add(sys.getCourseName());

		ThirdCycle sam = new ThirdCycle("SAM", 10, it, bjorn);
		bjorn.addResponsibleFor(sam);
		bjorn.addTeachingCourse(sam);
		sam.addTeachingTeacher(bjorn);
		sam.setCouRegi(couReg);
		it.addCourse(sam);
		couReg.createCourse(sam);
		courseData.add(sam);
		comboBoxCourseAddHours.getItems().add(sam.getCourseName());
		comboBoxCourseAddTeacher.getItems().add(sam.getCourseName());
		comboBoxCalculateCourseCost.getItems().add(sam.getCourseName());

		ThirdCycle eko = new ThirdCycle("EKONOMI", 10, hr, johan);
		johan.addResponsibleFor(eko);
		johan.addTeachingCourse(eko);
		eko.addTeachingTeacher(johan);
		eko.setCouRegi(couReg);
		hr.addCourse(eko);
		couReg.createCourse(eko);
		courseData.add(eko);
		comboBoxCourseAddHours.getItems().add(eko.getCourseName());
		comboBoxCourseAddTeacher.getItems().add(eko.getCourseName());
		comboBoxCalculateCourseCost.getItems().add(eko.getCourseName());

		ThirdCycle pol = new ThirdCycle("POLKAND", 10, pr, elias);
		elias.addResponsibleFor(pol);
		elias.addTeachingCourse(pol);
		pol.addTeachingTeacher(elias);
		pol.setCouRegi(couReg);
		pr.addCourse(pol);
		couReg.createCourse(pol);
		courseData.add(pol);
		comboBoxCourseAddHours.getItems().add(pol.getCourseName());
		comboBoxCourseAddTeacher.getItems().add(pol.getCourseName());
		comboBoxCalculateCourseCost.getItems().add(pol.getCourseName());

	}

}