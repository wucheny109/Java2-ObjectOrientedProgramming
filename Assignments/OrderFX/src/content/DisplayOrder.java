/**
 * CHENYU WU
 * 991566725
 * Assignment 2
 * Feb 25 2020
 */
package content;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DisplayOrder extends Stage {

    public DisplayOrder(Order one) {
        setScene(getScene(one));
    }

    private Scene getScene(Order one) {
        String orderID = one.getOrderID();
        String firstName = one.getFirstName();
        String lastName = one.getLastName();
        String city = one.getCity();

        int orderA = one.getOrderA();
        int orderB = one.getOrderB();
        int orderC = one.getOrderC();
        int orderD = one.getOrderD();

        Label lblOrderID = new Label("Order ID: " + orderID);
        Label lblFirstName = new Label("First Name: " + firstName);
        Label lblLastName = new Label("Last Name: " + lastName);
        Label lblCity = new Label("City: " + city);
        Label lblLine = new Label("- - - - - - - - - - - - - - - - - - - - \n"
                + "Order Quantity:\n" + " ");
        lblLine.setTextFill(Color.BLUE);
        Label lblOrderA = new Label("Yellow Circle: " + orderA);
        Label lblOrderB = new Label("Red Squre: " + orderB);
        Label lblOrderC = new Label("Blue Rectangle: " + orderC);
        Label lblOrderD = new Label("Green Triangle: " + orderD);

        VBox pane = new VBox(lblOrderID, lblFirstName, lblLastName, lblCity,
                lblLine, lblOrderA, lblOrderB, lblOrderC, lblOrderD);

        Scene scene = new Scene(pane, 340, 280);
        return scene;
    }
}
