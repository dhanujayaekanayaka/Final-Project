package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.IOException;
import java.sql.SQLException;

public class VehicleFormController {
    public TextField txtModel;
    public TextField txtVehicleNumber;
    public TextField txtColor;
    public TextField txtYom;
    public TextField txtRegDate;
    public TextField txtCurrentMillage;
    public TextField txtChassisNumber;
    public TextField txtEngineNumber;
    public AnchorPane rootNode;
    public ScrollPane scrollPane;
    public VBox vBox;
    public Circle vp1;
    public Circle vp2;
    public Circle vp3;
    public Circle vp4;
    public Circle vp5;
    public Circle vp6;
    public Circle vp7;
    public Circle vp8;
    public Label vn1;
    public Label vnp1;
    public Label vn2;
    public Label vnp2;
    public Label vn3;
    public Label vnp3;
    public Label vn4;
    public Label vnp4;
    public Label vn5;
    public Label vnp5;
    public Label vn6;
    public Label vnp6;
    public Label vn7;
    public Label vnp7;
    public Label vn8;
    public Label vnp8;
    public Circle profilePicture;
    public Circle vehicleProfile;
    public Circle profilePicture1;
    public Label username;

    public void initialize(){
        setProfile();
    }

    private void setProfile() {
        Image image = new Image(String.valueOf(getClass().getResource("/image/humen1.jpeg")));
        profilePicture.setFill(new ImagePattern(image));
        profilePicture1.setFill(new ImagePattern(image));
    }

    public void btnConformOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void btnSaveOnAction(ActionEvent event) {
        String model = txtModel.getText();
        String vehicleNumber = txtVehicleNumber.getText();
        String chassisNumber = txtChassisNumber.getText();
        String engineNumber = txtEngineNumber.getText();
        String color = txtColor.getText();
        String  yom = txtYom.getText();
        String registerDate = txtRegDate.getText();
        String currentDistance = txtCurrentMillage.getText();
        try {
            String currentId = VehicleRepo.getVehicleId();
            String availableId = VehicleRepo.getVehicleId(currentId);
            boolean isSaved = VehicleRepo.registerVehicle(availableId,model,vehicleNumber,chassisNumber,engineNumber,color,yom,registerDate,currentDistance);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Vehicle saved successfully").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Vehicle not saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnBackToLoginOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnMovetoDriverFormOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToVehicleFormAction(ActionEvent actionEvent) {
    }

    public void btnMoveToPackageFormOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToRouteOnAction(ActionEvent actionEvent) {
    }

    public void btnMyProfileOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToDashboardOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToServiceOnAction(ActionEvent actionEvent) {
    }

    public void goToDetailOnSwipeLeft(SwipeEvent swipeEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/vehicleViewForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Vehicle View");
        stage.centerOnScreen();
    }
}
