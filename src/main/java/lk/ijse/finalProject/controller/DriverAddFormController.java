package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.IOException;

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
