package sample.controller;

import java.sql.Date;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.Employee;
import sample.model.EmployeeDAO;

/**
 * Created by ONUR BASKIRT on 23.02.2016.
 */
public class EmployeeController {
	@FXML
	private TextField empIdText;
	@FXML
	private TextArea resultArea;
	@FXML
	private TextField newEmailText;
	@FXML
	private TextField nameText;
	@FXML
	private TextField surnameText;
	@FXML
	private TextField emailText;
	@FXML
	private TableView employeeTable;
	@FXML
	private TableColumn<Employee, Integer> empIdColumn;
	@FXML
	private TableColumn<Employee, String> empNameColumn;
	@FXML
	private TableColumn<Employee, String> empLastNameColumn;
	@FXML
	private TableColumn<Employee, String> empEmailColumn;
	@FXML
	private TableColumn<Employee, String> empPhoneNumberColumn;
	@FXML
	private TableColumn<Employee, Date> empHireDateColumn;

	@FXML
	private void searchEmployee(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		try {
			Employee emp = EmployeeDAO.searchEmployee(empIdText.getText());
			populateAndShowEmployee(emp);
		} catch (SQLException e) {
			e.printStackTrace();
			resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
			throw e;
		}
	}

	@FXML
	private void searchEmployees(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			ObservableList<Employee> empData = EmployeeDAO.searchEmployees();
			populateEmployees(empData);
		} catch (SQLException e) {
			System.out.println("Error occurred while getting employees information from DB.\n" + e);
			throw e;
		}
	}

	@FXML
	private void initialize() {
		empIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
		empNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		empLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		empEmailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		empPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
		empHireDateColumn.setCellValueFactory(cellData -> cellData.getValue().hireDateProperty());
	}

	@FXML
	private void populateEmployee(Employee emp) throws ClassNotFoundException {
		ObservableList<Employee> empData = FXCollections.observableArrayList();
		empData.add(emp);
		employeeTable.setItems(empData);
	}

	@FXML
	private void setEmpInfoToTextArea(Employee emp) {
		resultArea.setText("First Name: " + emp.getFirstName() + "\n" + "Last Name: " + emp.getLastName());
	}

	@FXML
	private void populateAndShowEmployee(Employee emp) throws ClassNotFoundException {
		if (emp != null) {
			populateEmployee(emp);
			setEmpInfoToTextArea(emp);
		} else {
			resultArea.setText("This employee does not exist!\n");
		}
	}

	@FXML
	private void populateEmployees(ObservableList<Employee> empData) throws ClassNotFoundException {
		employeeTable.setItems(empData);
	}

	@FXML
	private void updateEmployeeEmail(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			EmployeeDAO.updateEmpEmail(empIdText.getText(), newEmailText.getText());
			resultArea.setText("Email has been updated for, employee id: " + empIdText.getText() + "\n");
		} catch (SQLException e) {
			resultArea.setText("Problem occurred while updating email: " + e);
		}
	}

	// Insert an employee to the DB
	@FXML
	private void insertEmployee(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			EmployeeDAO.insertEmp(nameText.getText(), surnameText.getText(), emailText.getText());
			resultArea.setText("Employee inserted! \n");
		} catch (SQLException e) {
			resultArea.setText("Problem occurred while inserting employee " + e);
			throw e;
		}
	}

	@FXML
	private void deleteEmployee(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			EmployeeDAO.deleteEmpWithId(empIdText.getText());
			resultArea.setText("Employee deleted! Employee id: " + empIdText.getText() + "\n");
		} catch (SQLException e) {
			resultArea.setText("Problem occurred while deleting employee " + e);
			throw e;
		}
	}
}