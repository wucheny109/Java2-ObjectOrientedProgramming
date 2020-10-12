/**
 * CHENYU WU
 * 991566725
 * Assignment 2
 * Feb 25 2020
 */
package orderfx;

import content.DisplayOrder;
import content.Order;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private Label lblOrderID = new Label("Order ID: ");
    private TextField txtOrderID = new TextField();
    private Label lblFirstName = new Label("First Name: ");
    private TextField txtFirstName = new TextField();
    private Label lblLastName = new Label("Last Name: ");
    private TextField txtLastName = new TextField();
    private Label lblCity = new Label("City: ");
    private TextField txtCity = new TextField();

    private Circle circle = new Circle(25);
    private Rectangle rect = new Rectangle(50, 50);
    private Rectangle squre = new Rectangle(80, 50);
    private Polygon triangle = new Polygon(50.0, 0.0, 0.0, 50.0, 100.0, 50.0);
    private Label label = new Label("Click the shape to order");
    private Label labelA = new Label();
    private Label labelB = new Label();
    private Label labelC = new Label();
    private Label labelD = new Label();
    private HBox pane4 = new HBox(24, labelA, labelB, labelC, labelD);
    private HBox pane1 = new HBox(20, circle, rect, squre, triangle);
    private HBox pane2 = new HBox(label);
    private VBox pane3 = new VBox(5, pane4, pane1, pane2);

    private Button btnDisplay = new Button("Display");
    private int orderA = 0, orderB = 0, orderC = 0, orderD = 0;
    private Order one = new Order();

    @Override
    public void start(Stage primaryStage) {

        btnDisplay.setOnAction((e) -> {
            process();
            DisplayOrder ds = new DisplayOrder(one);
            ds.show();
        });

        circle.setFill(Color.YELLOW);
        rect.setFill(Color.RED);
        squre.setFill(Color.BLUE);
        triangle.setFill(Color.GREEN);

        label.setTextFill(Color.GRAY);
        labelA.setText("Circle: " + Integer.toString(orderA));
        labelB.setText("Squre: " + Integer.toString(orderB));
        labelC.setText("Rectangle: " + Integer.toString(orderC));
        labelD.setText("Triangle: " + Integer.toString(orderD));

        circle.setOnMouseClicked((e) -> {
            orderA++;
            labelA.setText("Circle: " + Integer.toString(orderA));
        });
        rect.setOnMouseClicked((e) -> {
            orderB++;
            labelB.setText("Squre: " + Integer.toString(orderB));
        });
        squre.setOnMouseClicked((e) -> {
            orderC++;
            labelC.setText("Rectangle: " + Integer.toString(orderC));
        });
        triangle.setOnMouseClicked((e) -> {
            orderD++;
            labelD.setText("Triangle: " + Integer.toString(orderD));
        });

        Scene scene = new Scene(getGrid(), 340, 280);
        primaryStage.setTitle("Assignment2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane getGrid() {
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.add(lblOrderID, 0, 0);
        pane.add(txtOrderID, 1, 0);
        pane.add(lblFirstName, 0, 1);
        pane.add(txtFirstName, 1, 1);
        pane.add(lblLastName, 0, 2);
        pane.add(txtLastName, 1, 2);
        pane.add(lblCity, 0, 3);
        pane.add(txtCity, 1, 3);
        pane.add(pane3, 0, 5, 4, 1);
        pane.add(btnDisplay, 0, 6);

        return pane;
    }

    private void process() {

        one.setOrderID(txtOrderID.getText());
        one.setFirstName(txtFirstName.getText());
        one.setLastName(txtLastName.getText());
        one.setCity(txtCity.getText());
        one.setOrderA(orderA);
        one.setOrderB(orderB);
        one.setOrderC(orderC);
        one.setOrderD(orderD);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
