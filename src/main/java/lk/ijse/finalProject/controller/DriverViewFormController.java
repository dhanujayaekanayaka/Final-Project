package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.repository.DriverRepo;

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

    public void hplEditOnction(ActionEvent actionEvent) {

    }
}
