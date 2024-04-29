package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.ijse.finalProject.repository.DriverRepo;

import java.sql.SQLException;

public class DriverFormController {
    public TextField txtFirstName   ;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtDob;
    public TextField txtNic;
    public TextField txtPhone;
    public TextField txtEmail;
    public ImageView imvProfilePicture;
    public AnchorPane rootNode;
    public AnchorPane scrollPane;
    public void initialize(){
        try {
            DriverRepo.setUpScrollPane(scrollPane);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnConformOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void btnSaveOnAction(ActionEvent event) {
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

    public void btnMovetoDriverFormOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToVehicleFormAction(ActionEvent actionEvent) {
    }

    public void btnMoveToPackageFormOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToRouteOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToServiceOnAction(ActionEvent actionEvent) {
    }

    public void btnMyProfileOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToDashboardOnAction(ActionEvent actionEvent) {
    }

    public void btnBackToLoginOnAction(ActionEvent actionEvent) {
    }
}
