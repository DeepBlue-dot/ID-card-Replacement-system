package org.IDentifyMe.Controller;

import org.IDentifyMe.MainApp;
import org.IDentifyMe.Models.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentDashboardController implements Initializable {

    @FXML
    private TableView<Student> tbData;

    @FXML
    public TableColumn<Student, Integer> studentId;

    @FXML
    public TableColumn<Student, String> firstName;

    @FXML
    public TableColumn<Student, String> lastName;

    @FXML
    private PieChart pieChart;

    @FXML
    Pane headerBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainApp.router.setBackground("loginBg.png", headerBar);
        System.out.println("Student Dashboard Page");
        loadChart();
        loadStudents();
    }

    private void loadChart() {

        PieChart.Data slice1 = new PieChart.Data("Classes", 213);
        PieChart.Data slice2 = new PieChart.Data("Attendance", 67);
        PieChart.Data slice3 = new PieChart.Data("Teachers", 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

    }

    private void loadStudents() {
        studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));

    }

    @FXML
    private void reloadPage() {
        MainApp.router.reloadPage();
    }

    @FXML
    private void homePage() {
        MainApp.router.navigateTo(MainApp.User +"Home");
    }

    @FXML
    private void previousPage() {
        MainApp.router.navigateBack();
    }
}
