/**
 * CHENYU WU
 * 991566725
 * Final Project
 * April 5 2020
 */
package finalproject;

import content.Order;
import content.OrderFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author j.kw
 */
public class Main extends Application {

    private Label lblOrderID = new Label("Order ID: ");
    private TextField txtOrderID = new TextField();
    private Label lblCustomerID = new Label("Customer ID: ");
    private TextField txtCustomerID = new TextField();
    private Label lblProduct = new Label("Product: ");
    private TextField txtProduct = new TextField();
    private Label lblShippingMethod = new Label("Shipping Method: ");
    private TextField txtShippingMethod = new TextField();
    private Label lblTitleSearch = new Label("Search:");
    private Label lblTitleNavigate = new Label("Navigation:");
    private Label lblTitleModify = new Label("Modification:");
    private Button btnFirst = new Button("First");
    private Button btnLast = new Button("Last");
    private Button btnPrevious = new Button("Previous");
    private Button btnNext = new Button("Next");
    private Button btnSearchAll = new Button("All Orders");
    private Button btnSearchByCustomerID = new Button("Customer ID");
    private Button btnSearchByProduct = new Button("Product");
    private Button btnUpdate = new Button("Update");
    private Button btnAdd = new Button("Add");
    private Button btnDelete = new Button("Delete");

    private ArrayList<Order> orderList = new ArrayList<>();
    private int position = 0;

    private boolean checkOrderID = false;
    private boolean checkCustomerID = false;
    private boolean checkAdd = false;
    private boolean checkDelete = false;

    @Override
    public void start(Stage primaryStage) throws IOException {

        process();
        Scene scene = new Scene(getGrid(), 400, 250);
        primaryStage.setTitle("PROG24178 - Final Project");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // When primaryStage close, close the application
        primaryStage.setOnCloseRequest((e) ->{
                System.exit(0);
            });
    }

    @Override
    public void stop() throws IOException {
        OrderFile.setData(this.orderList);
    }
    
    

    private GridPane getGrid() {
        GridPane pane = new GridPane();
        GridPane paneBtn = new GridPane();

        lblTitleSearch.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        lblTitleNavigate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        lblTitleModify.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnSearchAll.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnSearchByCustomerID.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnSearchByProduct.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnFirst.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnLast.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnPrevious.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnNext.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnAdd.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnDelete.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnUpdate.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        TilePane tileBtnSearch = new TilePane();
        tileBtnSearch.setPadding(new Insets(5, 5, 0, 0));
        tileBtnSearch.setHgap(4);
        tileBtnSearch.setVgap(3);
        tileBtnSearch.getChildren().addAll(lblTitleSearch, btnSearchAll,
                btnSearchByCustomerID, btnSearchByProduct);

        TilePane tileBtnNavigate = new TilePane();
        tileBtnNavigate.setPadding(new Insets(5, 5, 0, 0));
        tileBtnNavigate.setHgap(4);
        tileBtnNavigate.setVgap(3);
        tileBtnNavigate.getChildren().addAll(lblTitleNavigate, btnFirst,
                btnPrevious, btnNext, btnLast);

        TilePane tileBtnModify = new TilePane();
        tileBtnModify.setPadding(new Insets(5, 5, 0, 0));
        tileBtnModify.setHgap(4);
        tileBtnModify.setVgap(3);
        tileBtnModify.getChildren().addAll(lblTitleModify, btnAdd,
                btnDelete, btnUpdate);

        pane.setVgap(5);
        pane.setHgap(3);
        pane.add(lblOrderID, 0, 0);
        pane.add(txtOrderID, 1, 0);
        pane.add(lblCustomerID, 0, 1);
        pane.add(txtCustomerID, 1, 1);
        pane.add(lblProduct, 0, 2);
        pane.add(txtProduct, 1, 2);
        pane.add(lblShippingMethod, 0, 3);
        pane.add(txtShippingMethod, 1, 3);
        pane.add(paneBtn, 0, 5, 8, 5);

        paneBtn.add(tileBtnSearch, 0, 1);
        paneBtn.add(tileBtnNavigate, 0, 3);
        paneBtn.add(tileBtnModify, 0, 4);

        return pane;
    }

    private void process() throws IOException {
        OrderFile.getData();
        orderList = OrderFile.getData();
        showFirst();
        btnFirst.setOnAction((e) -> {
            showFirst();
        });
        btnLast.setOnAction((e) -> {
            showLast();
        });
        btnPrevious.setOnAction((e) -> {
            showPrevious();
        });
        btnNext.setOnAction((e) -> {
            showNext();
        });
        btnSearchAll.setOnAction((e) -> {
            displayAll();
        });
        btnSearchByCustomerID.setOnAction((e) -> {
            searchCustomerID();
        });
        btnSearchByProduct.setOnAction((e) -> {
            searchProduct();
        });
        btnAdd.setOnAction((e) -> {
            add();
            checkAdd = true;
        });
        btnDelete.setOnAction((e) -> {
            checkDelete = true;
            delete();
        });
        btnUpdate.setOnAction((e) -> {
            validate();
        });

    }

    // Display result by different requirement on a separate stage
    private void displayAll() {
        DisplayStage ds = new DisplayStage(orderList);
        ds.show();
    }

    private void searchCustomerID() {
        ArrayList<Order> resultList = new ArrayList<>();
        for (Order sub : orderList) {
            if (txtCustomerID.getText().equals(sub.getCustomerID())) {
                resultList.add(sub);
            }
        }
        DisplayStage ds = new DisplayStage(resultList);
        ds.show();
    }

    private void searchProduct() {
        ArrayList<Order> resultList = new ArrayList<>();
        for (Order sub : orderList) {
            if (txtProduct.getText().equals(sub.getProduct())) {
                resultList.add(sub);
            }
        }
        DisplayStage ds = new DisplayStage(resultList);
        ds.show();
    }

    // Navigate the record and let it appear
    private void showFirst() {
        txtOrderID.setText(orderList.get(0).getOrderID());
        txtCustomerID.setText(orderList.get(0).getCustomerID());
        txtProduct.setText(orderList.get(0).getProduct());
        txtShippingMethod.setText(orderList.get(0).getShippingMethod());
        position = 0;

    }

    private void showLast() {
        txtOrderID.setText(orderList.get(orderList.size() - 1).getOrderID());
        txtCustomerID.setText(orderList.get(orderList.size() - 1)
                .getCustomerID());
        txtProduct.setText(orderList.get(orderList.size() - 1).getProduct());
        txtShippingMethod.setText(orderList.get(orderList.size() - 1)
                .getShippingMethod());
        position = orderList.size() - 1;

    }

    private void showPrevious() {
        if (position > 0) {
            txtOrderID.setText(orderList.get(position - 1).getOrderID());
            txtCustomerID.setText(orderList.get(position - 1).getCustomerID());
            txtProduct.setText(orderList.get(position - 1).getProduct());
            txtShippingMethod.setText(orderList.get(position - 1)
                    .getShippingMethod());
            position--;
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("It is the First One!");
            a.show();
        }
    }

    private void showNext() {
        if (position < orderList.size() - 1) {
            txtOrderID.setText(orderList.get(position + 1).getOrderID());
            txtCustomerID.setText(orderList.get(position + 1).getCustomerID());
            txtProduct.setText(orderList.get(position + 1).getProduct());
            txtShippingMethod.setText(orderList.get(position + 1)
                    .getShippingMethod());
            position++;
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setContentText("It is the Last One!");
            a.show();
        }
    }

    private void showCurrent() {
        txtOrderID.setText(orderList.get(position).getOrderID());
        txtCustomerID.setText(orderList.get(position).getCustomerID());
        txtProduct.setText(orderList.get(position).getProduct());
        txtShippingMethod.setText(orderList.get(position).getShippingMethod());
    }

    // Clear the textfields
    private void add() {
        txtOrderID.clear();
        txtCustomerID.clear();
        txtProduct.clear();
        txtShippingMethod.clear();
        checkAdd = true;

    }

    // Update: Change product and shipping method, or Add new record
    private void update() {
        if (!checkAdd) {
            for (Order sub : orderList) {
                if (sub.getOrderID().equals(txtOrderID.getText())
                        && sub.getCustomerID().equals(txtCustomerID.getText())){
                    sub.setProduct(txtProduct.getText());
                    sub.setShippingMethod(txtShippingMethod.getText());
                }
            }
        } else {
            if (!txtOrderID.getText().isEmpty()
                    && !txtCustomerID.getText().isEmpty()
                    && !txtProduct.getText().isEmpty()
                    && !txtShippingMethod.getText().isEmpty()) {
                Order one = new Order(txtOrderID.getText());
                one.setCustomerID(txtCustomerID.getText());
                one.setProduct(txtProduct.getText());
                one.setShippingMethod(txtShippingMethod.getText());
                orderList.add(one);
            }
        }
        checkAdd = false;
    }

    //Validation
    private void validate() {

        checkOrderID = false;
        checkCustomerID = false;

        Alert aW = new Alert(AlertType.WARNING);
        Alert aC = new Alert(AlertType.CONFIRMATION);
        if (!txtOrderID.getText().isEmpty()
                && !txtCustomerID.getText().isEmpty()
                && !txtProduct.getText().isEmpty()
                && !txtShippingMethod.getText().isEmpty()) {
            for (Order sub : orderList) {
                if (txtOrderID.getText().equals(sub.getOrderID())) {
                    checkOrderID = true;
                }
                if (txtCustomerID.getText().equals(sub.getCustomerID())) {
                    checkCustomerID = true;
                }
            }

            if (!checkAdd) {
                if (!checkOrderID || !checkCustomerID) {
                    aW.setContentText("Cannot change OrderID or CustomerID !");
                    aW.show();
                    showCurrent();
                }
                if (checkOrderID && checkCustomerID) {

                    aC.setTitle("Confirmation Dialog");
                    aC.setHeaderText("Update : Change Info");
                    aC.setContentText("Do you want to make this change ?");
                    Optional<ButtonType> result = aC.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        update();
                        showCurrent();
                    } else {
                        showCurrent();
                    }
                }
            } else {
                if (!checkOrderID) {
                    if (!txtOrderID.getText().isEmpty()
                            && !txtCustomerID.getText().isEmpty()
                            && !txtProduct.getText().isEmpty()
                            && !txtShippingMethod.getText().isEmpty()) {
                        aC.setTitle("Confirmation Dialog");
                        aC.setHeaderText("Update : Add record");
                        aC.setContentText("Do you want to add this record ?");
                        Optional<ButtonType> result = aC.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            update();
                            showLast();
                        } else {
                            showCurrent();
                        }
                    }
                } else {
                    aW.setContentText("This OrderID has been used !");
                    aW.show();
                }
            }
        } else {
            aW.setContentText("Should fill out all informations !");
            aW.show();
        }
    }

    // Delete the record, and let the following record appear
    private void delete() {
        if (!txtOrderID.getText().isEmpty()
                && !txtCustomerID.getText().isEmpty()
                && !txtProduct.getText().isEmpty()
                && !txtShippingMethod.getText().isEmpty()) {
            if (checkDelete) {
                Alert aC = new Alert(AlertType.CONFIRMATION);
                aC.setTitle("Confirmation Dialog");
                aC.setHeaderText("Deleting...");
                aC.setContentText("Do you want to delete this record?");
                Optional<ButtonType> result = aC.showAndWait();
                if (result.get() == ButtonType.OK) {
                    orderList.remove(orderList.get(position));
                    showCurrent();
                } else {
                    showCurrent();
                }
            }
        }
        checkDelete = false;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
