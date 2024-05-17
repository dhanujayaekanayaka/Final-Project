package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.Service;
import lk.ijse.finalProject.model.ServiceCenter;
import lk.ijse.finalProject.model.ServiceCenterRepo;
import lk.ijse.finalProject.repository.ServiceRepo;
import lk.ijse.finalProject.util.Regex;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

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
        String text = txtSearchBar.getText();
        try {
            ServiceCenter centers = ServiceCenterRepo.getAll(text);
            txtCenter.setText(centers.getName());
            txtLocation.setText(centers.getLocation());
            txtPhone.setText(centers.getTel());
            txtEmail.setText(centers.getEmail());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
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
        String vehicleId = comboVehicleId.getValue();
        String serviceType = comboServiceType.getValue();
        String center = comboServiceCenter.getValue();
        String method = comboPayment.getValue();
        String description = txtDescription.getText();
        Date date = Date.valueOf(txtDate.getText());
        double amount = Double.parseDouble(txtAmount.getText());
        try {
            String currentId = ServiceRepo.getAvailableId();
            String availableId = ServiceRepo.getCurrentId(currentId);
            Service service = new Service(availableId,vehicleId,serviceType,description,date,center);
//            ServiceRepo.saveService();

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

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
        txtLocation.requestFocus();
    }

    public void btnClearCenterOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    private void clearFields() {
        txtCenter.clear();
        txtLocation.clear();
        txtPhone.clear();
        txtEmail.clear();
    }

    public void btnSaveCenterOnAction(ActionEvent actionEvent) {
        String center = txtCenter.getText();
        String location = txtLocation.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        try {
            String currentId = ServiceCenterRepo.getCurrentId();
            String avilableId = ServiceCenterRepo.getAvilableId(currentId);
            ServiceCenter serviceCenter = new ServiceCenter(avilableId,center,location,phone,email);
            boolean isSaved = ServiceCenterRepo.saveCenter(serviceCenter);
            if(isSaved){
                clearFields();
                new Alert(Alert.AlertType.CONFIRMATION,"Service center saved successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"Service center saved unsuccessfully").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnUpdateCenterOnAction(ActionEvent actionEvent) {
        String id = txtSearchBar.getText();
        String center = txtCenter.getText();
        String location = txtLocation.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        ServiceCenter serviceCenter = new ServiceCenter(id,center,location,phone,email);
        try {
            if (isValided()) {
                clearFields();
                boolean isUpdated = ServiceCenterRepo.update(serviceCenter);
                if (isUpdated) {
                    clearFields();
                    new Alert(Alert.AlertType.CONFIRMATION, "Service center update successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Service center update unsuccessfully").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private boolean isValided() {
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtCenter)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtLocation)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.PHONE,txtPhone)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.EMAIL,txtEmail)) return false;
        return true;
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();

    }

    public void txtLocationOnAction(ActionEvent actionEvent) {
        txtPhone.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }

    public void dateKeyReleasedOnAction(KeyEvent keyEvent) {
    }

    public void descriptionKeyReleasedOnAction(KeyEvent keyEvent) {
    }

    public void amountKeyReleasedOnAction(KeyEvent keyEvent) {

    }

    public void centersKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtCenter);
    }

    public void phoneOnKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.PHONE,txtPhone);
    }

    public void locationOnKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtLocation);
    }

    public void emailOnKeyReleasedAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.EMAIL,txtEmail);
    }
}
