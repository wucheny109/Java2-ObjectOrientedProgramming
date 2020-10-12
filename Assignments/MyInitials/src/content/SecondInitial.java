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
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SecondInitial extends Stage {

    private Rectangle r1 = new Rectangle(55, 60, 200, 200);
    private Arc a1 = new Arc();
    private Arc a2 = new Arc();
    private Arc a3 = new Arc();
    private Ellipse e1 = new Ellipse(125, 125, 20, 80);
    private Ellipse e2 = new Ellipse(180, 125, 20, 80);

    public SecondInitial() {
        setTitle("Second Initial - CHENYU WU");
        setX(670);
        setY(100);

        Text tName = new Text(115, 15, "CHENYU WU");
        tName.setFill(Color.PURPLE);

        Pane pane = new Pane(tName, r1, a1, a2, a3, e1, e2);
        Scene Scene = new Scene(pane, 300, 300);
        setScene(Scene);
        setArc();
        setRectangle();
        setEllipse();
    }

    private void setArc() {
        a1.setCenterX(30);
        a1.setCenterY(160);
        a1.setRadiusX(50);
        a1.setRadiusY(110);
        a1.setStartAngle(300);
        a1.setLength(120);
        a1.setFill(Color.WHITE);
        a1.setStrokeWidth(5);
        a1.setStroke(Color.NAVY);

        a2.setCenterX(155);
        a2.setCenterY(290);
        a2.setRadiusX(115);
        a2.setRadiusY(60);
        a2.setStartAngle(30);
        a2.setLength(120);
        a2.setFill(Color.WHITE);
        a2.setStrokeWidth(5);
        a2.setStroke(Color.NAVY);

        a3.setCenterX(280);
        a3.setCenterY(160);
        a3.setRadiusX(50);
        a3.setRadiusY(110);
        a3.setStartAngle(120);
        a3.setLength(120);
        a3.setFill(Color.WHITE);
        a3.setStrokeWidth(5);
        a3.setStroke(Color.NAVY);
    }

    private void setRectangle() {
        r1.setFill(Color.LIGHTSKYBLUE);
    }

    private void setEllipse() {
        e1.setFill(Color.WHITE);
        e2.setFill(Color.WHITE);
    }
}