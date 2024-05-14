package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.Package;
import lk.ijse.finalProject.model.Shipment;
import lk.ijse.finalProject.repository.PackageRepo;
import lk.ijse.finalProject.repository.ShipmentRepo;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PackageFormController implements Initializable {
    public TableColumn<?,?> colmTrackingNumber;
    public TableColumn<?,?> columnCompany;
    public TableColumn<?,?> columnTypeOfGood;
    public TableColumn<?,?> columnWeight;
    public TableColumn<?,?> columnPrice;
    public TableColumn<?,?> columnEdit;
    public Circle userProfile;
    public TextField txtCompanyName;
    public TextField txtTypeOfGood;
    public TextField txtWeight;
    public TextField txtPrice;
    public TextField borrowerDate;
    public JFXComboBox<String> comboTransportMode;
    public TableView<?> tblPackage;
    public JFXComboBox<String> comboId;
    public Pane newPane;
    public AnchorPane oldPane;


    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String companyId = comboId.getValue();
        String typeOfGood = txtTypeOfGood.getText();
        double weight = Double.parseDouble(txtWeight.getText());
        String mode = comboTransportMode.getValue();
        Date date = Date.valueOf(borrowerDate.getText());
        String routId = txtCompanyName.getText();
        double shipmentCost = weight * 500;

        try {
            String currentId = PackageRepo.getCurrentId();
            String availableId = PackageRepo.getAvailableId(currentId);
            String currentTrackingNUmber = PackageRepo.getTrackingNumber();
            String availableNumber = PackageRepo.getAvailableNumber(currentTrackingNUmber);
            String currentShipmentId = PackageRepo.getCurrentShipmenId();
            String availableShipmentId = PackageRepo.getAvailableShipmentId(currentShipmentId);
            Shipment shipment = new Shipment(availableShipmentId,shipmentCost,routId);

            boolean isInputShipment = ShipmentRepo.inputShipment(shipment);
            if (isInputShipment){
                Package savePackage = new Package(availableId,availableNumber,companyId,typeOfGood,weight,mode,date,availableShipmentId);
                PackageRepo.savePackage(savePackage);
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void comboIdOnAction(ActionEvent actionEvent) {
    }

    public void btnConformOnAction(ActionEvent actionEvent) {
        if (comboId.getValue() != null) {
            newPane.setVisible(false);
            oldPane.setOpacity(1.0);
        } else {
            new Alert(Alert.AlertType.ERROR,"Please choose a company").show();
        }
    }

    public void txtCompanyOnAction(ActionEvent actionEvent) {
        txtTypeOfGood.requestFocus();
    }

    public void txtTypeOfGoodOnAction(ActionEvent actionEvent) {
        txtWeight.requestFocus();

    }

    public void txtWeightOnAction(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }

    public void txtPriceOnAction(ActionEvent actionEvent) {
        borrowerDate.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCombo();
        setTransportMode();

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
}
