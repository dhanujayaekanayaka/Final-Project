package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/loginForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnMovetoDriverFormOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/driverForm.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Driver Form");
        stage.centerOnScreen();
    }
}
