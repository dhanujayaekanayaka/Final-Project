package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.repository.DriverRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Stack;

public class DriverFormController {
    public TextField txtFirstName   ;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtDob;
    public TextField txtNic;
    public TextField txtPhone;
    public TextField txtEmail;
    public AnchorPane rootNode;
    public AnchorPane scrollPane;
    public Circle userProfile;
    public Circle userProfile1;
    public Circle driverProfile;
    public Circle dp1;
    public Label dnp1;
    public Circle dp2;
    public Label dn2;
    public Label dnp2;
    public Circle dp3;
    public Label dn3;
    public Label dnp3;
    public Circle dp4;
    public Label dn4;
    public Label dnp4;
    public Circle dp5;
    public Label dn5;
    public Label dnp5;
    public Circle dp6;
    public Label dn6;
    public Label dnp6;
    public Circle dp7;
    public Label dn7;
    public Label dnp7;
    public Circle dp8;
    public Label dn8;
    public Label dnp8;

    public void initialize(){
        setProfilePicture();

    }

    private void setProfilePicture() {
        Image image = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
        userProfile.setFill(new ImagePattern(image));
        userProfile1.setFill(new ImagePattern(image));

        Image image1 = new Image(String.valueOf(this.getClass().getResource("/driver/humen2.jpeg")));
        Image image2 = new Image(String.valueOf(this.getClass().getResource("/driver/humen3.jpeg")));
        Image image3 = new Image(String.valueOf(this.getClass().getResource("/driver/humen4.jpeg")));
        Image image4 = new Image(String.valueOf(this.getClass().getResource("/driver/driver1.jpg")));
        Image image5 = new Image(String.valueOf(this.getClass().getResource("/driver/humen5.jpg")));
        Image image6 = new Image(String.valueOf(this.getClass().getResource("/driver/manager1.jpg")));
        Image image7 = new Image(String.valueOf(this.getClass().getResource("/driver/driver2.jpg")));
        Image image8 = new Image(String.valueOf(this.getClass().getResource("/driver/dispatcher.jpeg")));

        dp1.setFill(new ImagePattern(image1));
        dp2.setFill(new ImagePattern(image2));
        dp3.setFill(new ImagePattern(image3));
        dp4.setFill(new ImagePattern(image4));
        dp5.setFill(new ImagePattern(image5));
        dp6.setFill(new ImagePattern(image6));
        dp7.setFill(new ImagePattern(image7));
        dp8.setFill(new ImagePattern(image8));
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

    public void hplViewDriverOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane node = FXMLLoader.load(this.getClass().getResource("/view/driverViewForm.fxml"));
        Scene scene = new Scene(node);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Driver Info");
        stage.centerOnScreen();
    }
}
