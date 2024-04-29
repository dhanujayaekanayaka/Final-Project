package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DashboardFormController {

    public AnchorPane rootNode;
    public Label lblDatePicker;

    public void initialize(){
        setDate();
    }
    public void setDate(){
        LocalDate now = LocalDate.now();
        lblDatePicker.setText(String.valueOf(now));
    }

    public void btnBackToLoginOnAction(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnMoveToDriverFormOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverForm.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Driver Form");
        stage.centerOnScreen();
    }

    public void btnMoveToVehicleFormAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/vehicleForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Vehicle Form");
        stage.centerOnScreen();
    }

    public void btnMoveToPackageFormOnAction(ActionEvent event) {
    }

    public void btnMoveToRouteOnAction(ActionEvent event) {
    }

    public void btnMoveToServiceOnAction(ActionEvent event) {
    }

    public void btnMyProfileOnAction(ActionEvent event) {
    }

    public void btnMoveToDashboardOnAction(ActionEvent event) {
    }
}
