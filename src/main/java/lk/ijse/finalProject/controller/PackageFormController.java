package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.*;
import lk.ijse.finalProject.model.Package;
import lk.ijse.finalProject.repository.PackageRepo;
import lk.ijse.finalProject.repository.PackageSaveRepo;
import lk.ijse.finalProject.repository.RouteRepo;
import lk.ijse.finalProject.repository.ShipmentRepo;
import lk.ijse.finalProject.util.Regex;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class PackageFormController implements Initializable {
    public TableColumn<?,?> colmTrackingNumber;
    public TableColumn<?,?> columnCompany;
    public TableColumn<?,?> columnTypeOfGood;
    public TableColumn<?,?> columnWeight;
    public TableColumn<?,?> columnPrice;
    public TableColumn<?,?> columnDelete;
    public TextField txtWeight;
    public JFXComboBox<String> comboTransportMode;
    public TableView<?> tblPackage;
    public JFXComboBox<String> comboId;
    public AnchorPane oldPane;
    public TextField txtDate;
    public TextField txtType;
    public JFXComboBox<String> comboRoute;
    public TextField txtLocation;
    public TextField txtDestination;
    public TextField txtDistance;
    public JFXComboBox<String> comboDescription;
    public Circle picture1;
    public Circle picture2;
    public Circle picture3;
    public Circle picture4;
    public Circle picture5;
    public Label packageType1;
    public Label packageType2;
    public Label packageType3;
    public Label packageType4;
    public Label packageType5;
    public PieChart pieChart;
    public Label userName;
    public Circle profilePicture;
    public TextField txtSearchBar;
    public Label lblDatePicker;
    public AnchorPane newPane;


    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    private void clearFields() {
        txtType.clear();
        txtDate.clear();
        txtWeight.clear();
        comboId.setItems(null);
        comboRoute.setItems(null);
        comboDescription.setItems(null);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String companyId = comboId.getValue();
        String typeOfGood = txtType.getText();
        double weight = Double.parseDouble(txtWeight.getText());
        String vehicleId = comboTransportMode.getValue();
        Date date = Date.valueOf(txtDate.getText());
        String routId = comboRoute.getValue();
        double shipmentCost = weight * 500;

        try {
            String currentId = PackageRepo.getCurrentId();
            String availableId = PackageRepo.getAvailableId(currentId);
            String currentTrackingNUmber = PackageRepo.getTrackingNumber();
            String availableNumber = PackageRepo.getAvailableNumber(currentTrackingNUmber);
            String currentShipmentId = PackageRepo.getCurrentShipmenId();
            String availableShipmentId = PackageRepo.getAvailableShipmentId(currentShipmentId);
            String destination = getTransportMode(routId);
            String mode = RouteRepo.getMode(destination);
            double distance = Double.parseDouble(RouteRepo.getDistance(routId));
            String description = RouteRepo.getDescription(routId);
            Shipment shipment = new Shipment(availableShipmentId,shipmentCost,routId);
            Package savePackage = new Package(availableId,availableNumber,companyId,typeOfGood,weight,mode,date,availableShipmentId);
            DeliveryDetail deliveryDetail = new DeliveryDetail(availableShipmentId,vehicleId,destination);
            Route route = new Route(routId,"Panadura",destination,description,distance);
            PackageSave packageSave = new PackageSave(savePackage,shipment,deliveryDetail,route);
            PackageSaveRepo.placeClientOrder(packageSave);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private String getTransportMode(String routId) {
        try {
            String destination = RouteRepo.getDestination(routId);
            return destination;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK).show();
        }
        return null;
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String companyId = comboId.getValue();
        String typeOfGood = txtType.getText();
        double weight = Double.parseDouble(txtWeight.getText());
        String mode = comboTransportMode.getValue();
        Date date = Date.valueOf(txtDate.getText());
        String routId = comboRoute.getValue();
        String packId = txtSearchBar.getText();

    }

    public void comboIdOnAction(ActionEvent actionEvent) {
    }
    public void txtWeightOnAction(ActionEvent actionEvent) {
        txtDate.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCombo();
        setTransportMode();
        setComboDescription();
        setDate();

    }

    private void setDate() {
        lblDatePicker.setText(String.valueOf(LocalDate.now()));
        txtDate.setText(String.valueOf(LocalDate.now()));
    }

    private void setComboDescription() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("With Traffic");
        obList.add("Without Traffic");
        comboDescription.setItems(obList);
    }

    private void setTransportMode() {
        ObservableList<String> modes = FXCollections.observableArrayList();
        modes.add("Flight");
        modes.add("Ship");
        comboTransportMode.setItems(modes);
    }

    private void setCombo() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> companyId = PackageRepo.getCompanyId();
            for (String id : companyId){
                obList.add(id);
            }
            comboId.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void txtDateOnAction(ActionEvent actionEvent) {
    }

    public void txtTypeOnAction(ActionEvent actionEvent) {
        txtWeight.requestFocus();
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String packageId = txtSearchBar.getText();
        try {
            List<Package> all = PackageRepo.getAll(packageId);
            txtType.setText(String.valueOf(all.get(3)));
            txtWeight.setText(String.valueOf(all.get(4)));
            txtDate.setText(String.valueOf(all.get(6)));
            comboId.setItems((ObservableList<String>) all.get(2));
            ObservableList<String> routeId = ShipmentRepo.getRouteId(String.valueOf(all.get(8)));
            comboRoute.setItems(routeId);
            comboTransportMode.setItems((ObservableList<String>) all.get(5));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.CANCEL).show();
        }

    }

    public void txtLocationOnAction(ActionEvent actionEvent) {
        txtDestination.requestFocus();
    }

    public void txtDestinationOnAction(ActionEvent actionEvent) {
        txtDistance.requestFocus();
    }

    public void txtDistanceOnAction(ActionEvent actionEvent) {
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        newPane.setVisible(false);
    }
    public void comboDescriptionOnAction(ActionEvent actionEvent) {
        txtDistance.requestFocus();
    }

    public void btnRouteAddOnAction(ActionEvent actionEvent) {
        newPane.setVisible(true);
    }

    public void btnRouteClearOnAction(ActionEvent actionEvent) {
        txtLocation.clear();
        txtDestination.clear();
        txtDistance.clear();
    }

    public void btnRouteSaveOnAction(ActionEvent actionEvent) {
        String location = txtLocation.getText();
        String destination = txtDestination.getText();
        String description = comboDescription.getValue();
        double distance = Double.parseDouble(txtDistance.getText());
        try {
            String currentRouteId = RouteRepo.getCurrentRouteId();
            String nextAvailableId = RouteRepo.getNextAvailableId(currentRouteId);
            if (isValided()) {
                Route route = new Route(nextAvailableId, location, destination, description, distance);
                boolean isSaved = RouteRepo.saveRoute(route);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Route saved successfully", ButtonType.OK).show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Route saved unsuccessfully", ButtonType.CANCEL).show();
                }
            }
            } catch(SQLException e){
                new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
        }
    }

    private boolean isValided() {
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.NAME,txtLocation)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.NAME,txtDestination)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.DISTANCE,txtDistance)) return false;
        return true;
    }

    public void btnRouteUpdateOnAction(ActionEvent actionEvent) {

    }

    public void txtTypesKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtType);
    }

    public void txtWeightKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WEIGHT,txtWeight);
    }

    public void txtDateKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.DATE,txtDate);
    }

    public void txtLocationKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.NAME,txtLocation);
    }

    public void txtDestinationKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.NAME,txtDestination);
    }

    public void txtDistanceKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.DISTANCE,txtDistance);
    }
}
