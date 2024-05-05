package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class PackageFormController {
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
    public JFXComboBox<?> comboTransportMode;
    public TableView<?> tblPackage;

    public void txtJumptoTypeOfGoodOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToWeihtOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToPriceOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToBorrowdateOnaction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }
}
