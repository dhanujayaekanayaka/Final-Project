package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class ServicceFormController {
    public TextField txtSearchBar;
    public Label lblUserName;
    public Circle userProfile;
    public Circle vp1;
    public Circle vp2;
    public Circle vp3;
    public Circle vp4;
    public Circle vp5;
    public TableColumn clmVehicleId;
    public TableColumn clmDescription;
    public TableColumn clmServiceCenter;
    public TableColumn clmServiceCost;
    public TableColumn clmServiceDate;
    public TableColumn clmEdit;
    public TextField txtDescription;
    public TextField textDate;
    public TextField txtServiceCenter;
    public JFXComboBox comboVehicleId;
    public JFXComboBox comboServiceType;

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToDateOnAction(ActionEvent actionEvent) {
    }

    public void txtJumpToServiceCenterOnAction(ActionEvent actionEvent) {
    }
}
