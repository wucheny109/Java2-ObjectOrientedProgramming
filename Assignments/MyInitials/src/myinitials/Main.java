/**
 * CHENYU WU
 * 991566725
 * Assignment 1
 * Jan 16 2020
 */
package myinitials;

import content.FirstInitial;
import content.SecondInitial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Primary Stage - CHENYU WU");
        primaryStage.setX(50);
        primaryStage.setY(100);

        Text tName = new Text(115, 15, "CHENYU WU");
        tName.setFill(Color.BLUE);

        ImageView iID = new ImageView("images/ID.jpg");
        iID.setFitHeight(300);
        iID.setFitWidth(300);

        Pane pane = new Pane(iID, tName);
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage fStage = new FirstInitial();
        fStage.show();

        Stage sStage = new SecondInitial();
        sStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}