package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import lk.ijse.finalProject.model.Vehicle;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.File;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class VehicleUpdateFormController implements Initializable {
    public TextField txtModel;
    public TextField txtVehicleNumber;
    public TextField txtColor;
    public TextField txtYom;
    public TextField txtRegDate;
    public TextField txtCurrentMillage;
    public TextField txtChassisNumber;
    public TextField txtEngineNumber;
    public Circle vehicleProfile;
    public static String vehiId;
    public String rest;
    public JFXComboBox<String> comboId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCombo();
    }

    private void setCombo() {
        ObservableList<String > obList = FXCollections.observableArrayList();
        try {
            List<String> id = VehicleRepo.getId();
            for (String idList : id){
                obList.add(idList);
            }
            comboId.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public static void sendComboVAlues(String value) {
        String  id = value;
        vehiId=id;
    }
    public void txtModelOnAction(ActionEvent actionEvent) {
    }

    public void txtVehicleNumberOnAction(ActionEvent actionEvent) {
    }

    public void txtColorOnAction(ActionEvent actionEvent) {
    }

    public void txtYomOnAction(ActionEvent actionEvent) {
    }

    public void txtRegOnAction(ActionEvent actionEvent) {
    }

    public void txtCurrentDistanceOnAction(ActionEvent actionEvent) {
    }

    public void txtChassisOnAction(ActionEvent actionEvent) {
    }

    public void txtEngineNumberOnaction(ActionEvent actionEvent) {
    }

    public void btnChooseImageOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open My Files");
        fileChooser.setInitialDirectory(new File("/home/dhanujaya/Desktop/FinalProject/Final-Project/src/main/resources"));
        File selectedFile = fileChooser.showOpenDialog(null);
        String absolutePath = selectedFile.getAbsolutePath();
        String[] split =absolutePath.split("/home/dhanujaya/Desktop/FinalProject/Final-Project/src/main/resources");
        rest = split[1];
        Image image = new Image(String.valueOf(this.getClass().getResource(rest)));
        vehicleProfile.setFill(new ImagePattern(image));
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String vehiId = comboId.getValue();
        String model = txtModel.getText();
        String vehicleNumber = txtVehicleNumber.getText();
        String chassis = txtChassisNumber.getText();
        String engineNumber = txtEngineNumber.getText();
        String color = txtColor.getText();
        String yom = txtYom.getText();
        Date date = Date.valueOf(txtRegDate.getText());
        double distance = Double.parseDouble(txtCurrentMillage.getText());

        Vehicle vehicle = new Vehicle(vehiId,model,vehicleNumber,chassis,engineNumber,color,yom,date,distance,rest);
        try {
            boolean isUpdated = VehicleRepo.updateVehicle(vehicle);
            if (isUpdated) {
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle updated successfully").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Vehicle can't update").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    private void clearFields() {
        txtModel.clear();
        txtVehicleNumber.clear();
        txtYom.clear();
        txtColor.clear();
        txtEngineNumber.clear();
        txtChassisNumber.clear();
        txtRegDate.clear();
        txtCurrentMillage.clear();
        vehicleProfile.setFill(null);
    }
    public void comboIdOnAction(ActionEvent actionEvent) {
        String id = comboId.getValue();
        try {
            Vehicle vehicle = VehicleRepo.getValues(id);
            txtModel.setText(vehicle.getName());
            txtVehicleNumber.setText(vehicle.getVehicle_number());
            txtChassisNumber.setText(vehicle.getChassis());
            txtEngineNumber.setText(vehicle.getEngineNum());
            txtColor.setText(vehicle.getColor());
            txtYom.setText(vehicle.getYom());
            txtRegDate.setText(String.valueOf(vehicle.getRegDate()));
            txtCurrentMillage.setText(String.valueOf(vehicle.getCurrentDistance()));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }
}
