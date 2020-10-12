/**
 * CHENYU WU
 * 991566725
 * Assignment 1
 * Jan 16 2020
 */
package content;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstInitial extends Stage {

    private Rectangle r1 = new Rectangle(115, 110, 180, 120);
    private Rectangle r2 = new Rectangle(232, 100, 70, 140);
    private Circle c1 = new Circle(150, 170, 100);
    private Arc a1 = new Arc();

    public FirstInitial() {
        setTitle("First Initial - CHENYU WU");
        setX(360);
        setY(100);

        Text tName = new Text(115, 15, "CHENYU WU");
        tName.setFill(Color.DARKGREEN);

        Pane pane = new Pane(tName, c1, r1, r2, a1);
        Scene Scene = new Scene(pane, 300, 300);
        setScene(Scene);
        setRectangle();
        setCircle();
        setArc();
    }

    private void setRectangle() {
        r1.setFill(Color.WHITE);
        r1.setStrokeWidth(8);
        r1.setStroke(Color.BROWN);
        r2.setFill(Color.WHITE);
    }

    private void setCircle() {
        c1.setFill(Color.AQUAMARINE);
        c1.setStrokeWidth(8);
        c1.setStroke(Color.BROWN);
    }

    private void setArc() {
        a1.setFill(Color.WHITE);
        a1.setCenterX(155);
        a1.setCenterY(170);
        a1.setRadiusX(70);
        a1.setRadiusY(70);
        a1.setStartAngle(120);
        a1.setLength(120);
        a1.setStrokeWidth(8);
        a1.setStroke(Color.BROWN);
    }
}