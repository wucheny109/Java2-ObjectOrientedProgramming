/**
 * CHENYU WU
 * 991566725
 * Assignment 3
 * Mar 6 2020
 */
package studentfx;

import content.Student;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import studentfx.Studentfx;

public class DisplayStage extends Stage {

    private ArrayList<Student> studentList = new ArrayList();
    private Button btnAdd = new Button("Return to Add");
    private Button btnSave = new Button("Save data");
    private Label lblHint = new Label();

    public DisplayStage(ArrayList<Student> studentList) {
        this.studentList = studentList;
        setScene(addScene());

        btnAdd.setOnAction((e) -> {
            this.close();
            Studentfx.primaryStage.show();
        });
        btnSave.setOnAction((e) -> {
            try {
                saveData();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });
    }

    private Scene addScene() {
        TextArea txtDisplay = new TextArea(getResult(1));
        GridPane pane = new GridPane();
        pane.setVgap(2);
        pane.add(txtDisplay, 0, 0);
        pane.add(btnAdd, 0, 1);
        pane.add(btnSave, 0, 2);
        pane.add(lblHint, 0, 3);

        Scene scene = new Scene(pane, 520, 300);
        return scene;
    }

    /**
     * getResult() to calculate and get the result.
     *
     * @param optionNum (1: Full content, 2: only averages part of result
     * @return strFinal
     */
    private String getResult(int optionNum) {
        String elements = new String();
        String strFinal = new String();
        String avgs = new String();
        double avgAll = 0, avgC1 = 0, avgC2 = 0,
                avgC3 = 0, avgC4 = 0, avgC5 = 0;

        for (Student sub : studentList) {
            // average of each course, and average of all students
            avgC1 += sub.getGrade()[0] / studentList.size();
            avgC2 += sub.getGrade()[1] / studentList.size();
            avgC3 += sub.getGrade()[2] / studentList.size();
            avgC4 += sub.getGrade()[3] / studentList.size();
            avgC5 += sub.getGrade()[4] / studentList.size();
            avgAll += sub.getAvgStudent() / studentList.size();

            elements += "Student ID: " + sub.getId()
                    + ", Overall: " + sub.getAvgStudent() + "\n";

            avgs = "Overall of Course1: " + (int) avgC1 + "\n"
                    + "Overall of Course2: " + (int) avgC2 + "\n"
                    + "Overall of Course3: " + (int) avgC3 + "\n"
                    + "Overall of Course4: " + (int) avgC4 + "\n"
                    + "Overall of Course5: " + (int) avgC5 + "\n"
                    + "Overall of all students: " + (int) avgAll;

        }
        switch (optionNum) {
            case 1:
                strFinal = elements + avgs;
                break;
            case 2:
                strFinal = avgs;
        }
        return strFinal;
    }

    private void saveData() throws IOException {
        String title = new String("Student ID | Course1 | Course2 | Course3"
                + " | Course4 | Course5 | Overall");
        String grades = new String();
        String sData = new String();
        String space12 = "            ";
        String space6 = "      ";
        String space5 = "     ";
        FileWriter fw = new FileWriter("StudentRecord.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Student sub : studentList) {
            grades = "";
            for (int courseNum = 0; courseNum < 5; courseNum++) {
                if (sub.getGrade()[courseNum] < 100) {
                    grades += sub.getGrade()[courseNum] + space6;
                } else {
                    grades += sub.getGrade()[courseNum] + space5;
                }
            }
            sData += sub.getId() + space12 + grades
                    + sub.getAvgStudent() + "\n";
        }
        bw.write(title + "\n");
        bw.write(sData);
        bw.newLine();
        bw.write("Results: ");
        bw.newLine();
        bw.write(getResult(2));
        bw.close();
        fw.close();

        lblHint.setText("Data Saved!");
        lblHint.setTextFill(Color.RED);
    }
}
