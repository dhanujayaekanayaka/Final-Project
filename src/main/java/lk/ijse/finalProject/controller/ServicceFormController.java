package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class ServicceFormController {
    public TextField txtSearchBar;
    public TableColumn<?,?> clmVehicleId;
    public TableColumn<?,?> clmDescription;
    public TableColumn<?,?> clmServiceCenter;
    public TableColumn<?,?> clmServiceCost;
    public TableColumn<?,?> clmServiceDate;
    public TableColumn<?,?> clmEdit;
    public TextField txtDescription;
    public JFXComboBox<String> comboVehicleId;
    public JFXComboBox<String> comboServiceType;
    public Circle profilePicture1;
    public Circle profilePicture2;
    public Circle profilePicture3;
    public Circle profilePicture4;
    public Circle profilePicture5;
    public Hyperlink hplName1;
    public Label lblNumber1;
    public Hyperlink hplName2;
    public Label lblNumber2;
    public Hyperlink hplName3;
    public Label lblNumber3;
    public Hyperlink hplName4;
    public Label lblNumber4;
    public Hyperlink hplName5;
    public Label lblNumber5;
    public TextField txtDate;
    public TextField txtAmount;
    public JFXComboBox<String> comboPayment;
    public JFXComboBox<String> comboServiceCenter;
    public TextField txtCenter;
    public TextField txtPhone;
    public TextField txtLocation;
    public TextField txtEmail;
    public Label userName;
    public Circle profilePicture;
    public Label lblDatePicker;
    public Pane newPane;
    public Pane oldPane;

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void hplName1OnAction(ActionEvent actionEvent) {
    }

    public void hplName2OnAction(ActionEvent actionEvent) {
    }

    public void hplName3OnAction(ActionEvent actionEvent) {
    }

    public void hplName4OnAction(ActionEvent actionEvent) {
    }

    public void hplName5OnAction(ActionEvent actionEvent) {
    }

    public void txtDateOnAction(ActionEvent actionEvent) {
    }

    public void txtDescriptionOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void txtTypeOnAction(ActionEvent actionEvent) {
    }

    public void btnAddCenterOnAction(ActionEvent actionEvent) {
        newPane.setVisible(true);
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        newPane.setVisible(false);

    }

    public void txtCenterOnAction(ActionEvent actionEvent) {
    }

    public void btnClearCenterOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveCenterOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateCenterOnAction(ActionEvent actionEvent) {
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
    }

    public void txtLocationOnAction(ActionEvent actionEvent) {
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }
}
