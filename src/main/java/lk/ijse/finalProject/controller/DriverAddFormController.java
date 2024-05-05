package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.repository.DriverRepo;

import java.io.IOException;
import java.sql.SQLException;

public class DriverAddFormController {
    public Pane node;
    public AnchorPane rootNode;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtDob;
    public TextField txtNic;
    public TextField txtPhone;
    public TextField txtEmail;
    public TextField txtAddress;
    public Circle driverProfile;

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane node = FXMLLoader.load(this.getClass().getResource("/view/vehicleSelection.fxml"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(node);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String address = txtAddress.getText();
            String dob = txtDob.getText();
            String nic = txtNic.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();

            try {
                String currentDriverId = DriverRepo.getCurrentDriverId();
                String driverId = DriverRepo.generateDriverId(currentDriverId);
                DriverRepo.saveDriver(driverId,firstName,lastName,address,dob,nic,phone,email);
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
    }

    public void txtJumpToLastNameOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpNicOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToPhoneOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpTOEmailOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToDobOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToAddrsOnAction(ActionEvent actionEvent) {
    }
}
