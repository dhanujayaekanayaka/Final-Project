package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.Vehicle;
import lk.ijse.finalProject.repository.DriverRepo;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VehicleViewFormController implements Initializable {
    public Circle vehicleProfile;
    public TextField txtModel;
    public TextField txtColor;
    public TextField txtYom;
    public TextField txtCurrentMileage;
    public TextField txtVehicleNumber;
    public TextField txtChassisNumber;
    public TextField txtEngineNumber;
    public TextField txtSearch;

    public void btnBackOnAction(ActionEvent actionEvent) {
    }
    public void hplEditOnAction(ActionEvent actionEvent) {
    }
    public void hplDeleteVehicle(ActionEvent actionEvent) {
        String numberPlate = txtVehicleNumber.getText();
        try {
            boolean isDeleted = VehicleRepo.deleteVehicle(numberPlate);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Driver Deleted Successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"Driver can't delete").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    public void sendName(Vehicle vehicle) {
        txtModel.setText(vehicle.getName());
        txtColor.setText(vehicle.getColor());
        txtYom.setText(vehicle.getYom());
        txtChassisNumber.setText(vehicle.getChassis());
        txtEngineNumber.setText(vehicle.getEngineNum());
        txtVehicleNumber.setText(vehicle.getVehicle_number());
        txtCurrentMileage.setText(vehicle.getCurrentDistance());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String numberPlate = txtSearch.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(numberPlate);
            txtModel.setText(vehicle.getName());
            txtColor.setText(vehicle.getColor());
            txtYom.setText(vehicle.getYom());
            txtChassisNumber.setText(vehicle.getChassis());
            txtEngineNumber.setText(vehicle.getEngineNum());
            txtVehicleNumber.setText(vehicle.getVehicle_number());
            txtCurrentMileage.setText(vehicle.getCurrentDistance());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
