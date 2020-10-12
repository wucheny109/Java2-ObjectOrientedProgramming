/**
 * CHENYU WU
 * 991566725
 * Assignment 3
 * Mar 6 2020
 */
package studentfx;

import content.Student;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Studentfx extends Application {

    private ArrayList<Student> studentList = new ArrayList();
    private Label lblID = new Label("Student ID: ");
    private TextField txtID = new TextField();
    private Label lblC1 = new Label("Grade of Course1: ");
    private TextField txtC1 = new TextField();
    private Label lblC2 = new Label("Grade of Course2: ");
    private TextField txtC2 = new TextField();
    private Label lblC3 = new Label("Grade of Course3: ");
    private TextField txtC3 = new TextField();
    private Label lblC4 = new Label("Grade of Course4: ");
    private TextField txtC4 = new TextField();
    private Label lblC5 = new Label("Grade of Course5: ");
    private TextField txtC5 = new TextField();
    private Button btnAdd = new Button("Add Student");
    private Button btnDisplay = new Button("Display");
    public static Stage primaryStage;

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        btnAdd.setOnAction((e) -> {
            addStudent();
            sendClear();
        });
        btnDisplay.setOnAction((e) -> {
            DisplayStage ds = new DisplayStage(studentList);
            ds.show();
            primaryStage.close();
        });

        Scene scene = new Scene(addPane(), 280, 205);

        primaryStage.setTitle("Assignment3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane addPane() {
        GridPane pane = new GridPane();
        pane.setVgap(2);
        pane.add(lblID, 0, 0);
        pane.add(txtID, 1, 0);
        pane.add(lblC1, 0, 1);
        pane.add(txtC1, 1, 1);
        pane.add(lblC2, 0, 2);
        pane.add(txtC2, 1, 2);
        pane.add(lblC3, 0, 3);
        pane.add(txtC3, 1, 3);
        pane.add(lblC4, 0, 4);
        pane.add(txtC4, 1, 4);
        pane.add(lblC5, 0, 5);
        pane.add(txtC5, 1, 5);
        pane.add(btnAdd, 0, 6);
        pane.add(btnDisplay, 1, 6);
        return pane;
    }

    private void addStudent() {
        int id = Integer.parseInt(txtID.getText());
        int gradeC1 = Integer.parseInt(txtC1.getText());
        int gradeC2 = Integer.parseInt(txtC2.getText());
        int gradeC3 = Integer.parseInt(txtC3.getText());
        int gradeC4 = Integer.parseInt(txtC4.getText());
        int gradeC5 = Integer.parseInt(txtC5.getText());

        double[] grade = {gradeC1, gradeC2, gradeC3, gradeC4, gradeC5};

        Student one = new Student(id);
        one.setGrade(grade);
        studentList.add(one);
    }

    private void sendClear() {
        txtID.clear();
        txtC1.clear();
        txtC2.clear();
        txtC3.clear();
        txtC4.clear();
        txtC5.clear();
        txtID.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
