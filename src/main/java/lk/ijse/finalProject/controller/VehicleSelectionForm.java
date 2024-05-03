package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import lk.ijse.finalProject.repository.DriverRepo;

import java.io.IOException;

public class VehicleSelectionForm {

    public JFXComboBox comboId;
    public AnchorPane rootNode;

    public void btnConformOnAction(ActionEvent actionEvent) {

    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/driverAddForm.fxml"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(rootNode);
    }

    public void btnCancelOnAction1(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/driverAddForm.fxml"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(rootNode);

    }
}
