package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.repository.DriverRepo;

import java.io.IOException;
import java.sql.SQLException;

public class DriverViewFormController {
    public Circle profilePic;
    public Label lblDriver;
    public Label lblDriverid;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtDob;
    public TextField txtNic;
    public TextField txtPhone;
    public TextField txtEmail;
    public AnchorPane rootNode;
    public Circle employeeProfile;

    public void btnPersonelInfoOnAction(ActionEvent actionEvent) {
        try {
            DriverRepo.setValues();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnJobOnAction(ActionEvent actionEvent) {
    }

    public void btnJourneyOnAction(ActionEvent actionEvent) {
    }

    public void btnDocOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void hplEditOnction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("driverForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Vehicle Form");
        stage.centerOnScreen();
    }

    public void btnPersonelOnAction(ActionEvent actionEvent) {
    }

    public void btnFeedBackOnAction(ActionEvent actionEvent) {
    }

    public void hplEditOnAction(ActionEvent actionEvent) {
    }

    public void hplDeleteOnAction(ActionEvent actionEvent) {
    }
}
