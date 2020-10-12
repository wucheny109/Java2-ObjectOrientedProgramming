/**
 * CHENYU WU
 * 991566725
 * Final Project
 * April 5 2020
 */
package finalproject;

import content.Order;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author j.kw
 */
public class DisplayStage extends Stage {

    private ArrayList<Order> orderList = new ArrayList<>();

    public DisplayStage(ArrayList<Order> orderList) {
        this.orderList = orderList;
        setScene(addScene());
        setX(840);
        setY(170);
    }

    private Scene addScene() {

        String elements = new String();
        for (Order sub : orderList) {
            elements += sub + "\n";
        }
        TextArea txtDisplay = new TextArea(elements);
        txtDisplay.setPrefSize(250, 250);
        Pane pane = new Pane(txtDisplay);
        Scene scene = new Scene(pane, 250, 250);
        return scene;
    }

}
