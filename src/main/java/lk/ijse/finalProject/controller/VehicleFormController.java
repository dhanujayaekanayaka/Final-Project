package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.model.Vehicle;
import lk.ijse.finalProject.model.tm.VehicleTm;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static lk.ijse.finalProject.repository.VehicleRepo.getVehicleId;

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
    public Circle vehicleProfile;
    public Circle profilePicture1;
    public Label username;
    public JFXComboBox comboBox;

    public void initialize(){
        setProfile();
        getVehiclesId();
    }

    private void getVehiclesId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<Vehicle> idList = VehicleRepo.getId();
            for (Vehicle vehicle : idList){
                obList.add(vehicle.getId());
                comboBox.setItems(obList);
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setProfile() {
        Image image = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
        profilePicture1.setFill(new ImagePattern(image));

        Image image1 = new Image(String.valueOf(this.getClass().getResource("/truck/daf.jpeg")));
        Image image2 = new Image(String.valueOf(this.getClass().getResource("/truck/Scania3.jpg")));
        Image image3 = new Image(String.valueOf(this.getClass().getResource("/truck/image-2.jpeg")));
        Image image4 = new Image(String.valueOf(this.getClass().getResource("/truck/Scania1.jpeg")));
        Image image5 = new Image(String.valueOf(this.getClass().getResource("/truck/DAF1.jpeg")));
        Image image6 = new Image(String.valueOf(this.getClass().getResource("/truck/Scania2.jpg")));
        Image image7 = new Image(String.valueOf(this.getClass().getResource("/truck/daf.jpg")));
        Image image8 = new Image(String.valueOf(this.getClass().getResource("/truck/images.jpeg")));

        vp1.setFill(new ImagePattern(image1));
        vp2.setFill(new ImagePattern(image2));
        vp3.setFill(new ImagePattern(image3));
        vp4.setFill(new ImagePattern(image4));
        vp5.setFill(new ImagePattern(image5));
        vp6.setFill(new ImagePattern(image6));
        vp7.setFill(new ImagePattern(image7));
        vp8.setFill(new ImagePattern(image8));

        Image blank = new Image(String.valueOf(this.getClass().getResource("/blankProfile/images.png")));
        vehicleProfile.setFill(new ImagePattern(blank));
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
            String currentId = getVehicleId();
            String availableId = getVehicleId(currentId);
            Vehicle vehicle = new Vehicle(availableId,model,vehicleNumber,chassisNumber,engineNumber,color,yom,registerDate,currentDistance);
            boolean isSaved = VehicleRepo.registerVehicle(vehicle);
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
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/vehicleViewForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Vehicle View");
        stage.centerOnScreen();
    }
}
