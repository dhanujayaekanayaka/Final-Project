package lk.ijse.finalProject.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.Client;
import lk.ijse.finalProject.model.tm.ClientTm;
import lk.ijse.finalProject.repository.ClientRepo;
import lk.ijse.finalProject.util.Regex;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CompanyFormController implements Initializable {
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtEmail;
    public TableView<ClientTm> tblCompany;
    public TableColumn<?,?> clmCompany;
    public TableColumn<?,?> clmAddress;
    public TableColumn<?,?> clmPhone;
    public TableColumn<?,?> clmEmail;
    public AnchorPane oldPane;
    public TextField txtCompany;
    public TableColumn<?,?> clmEdit;
    public TableColumn<?,?> clmDelete;
    public Circle picture1;
    public Circle picture2;
    public Circle picture3;
    public Circle picture4;
    public Circle picture5;
    public Label company1;
    public Label tel1;
    public Label company2;
    public Label tel2;
    public Label company3;
    public Label tel3;
    public Label company4;
    public Label tel4;
    public Label company5;
    public Label tel5;
    public NumberAxis barChart;
    public Label userName;
    public Circle profilePicture;
    public TextField txtSearchBar;
    public Label lblDatePicker;
    public Circle profilePicture1;
    public Circle profilePicture2;
    public Circle profilePicture3;
    public Circle profilePicture4;
    public Circle profilePicture5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable();
        setCellValueFactory();
        setProfile();
    }

    private void setProfile() {
        Image image1 = new Image(getClass().getResourceAsStream("/company/images.png"));
        Image image2 = new Image(getClass().getResourceAsStream("/company/LALANNN.jpg"));
        Image image3 = new Image(getClass().getResourceAsStream("/company/brandixleed-002.jpg"));
        Image image4 = new Image(getClass().getResourceAsStream("/company/MAS.jpeg"));
        Image image5 = new Image(getClass().getResourceAsStream("/company/images.png"));
        
        
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String companyName = txtSearchBar.getText();
        try {
            Client client = ClientRepo.getValues(companyName);
            txtCompany.setText(client.getName());
            txtAddress.setText(client.getAddress());
            txtPhone.setText(client.getTel());
            txtEmail.setText(client.getEmail());
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String name = txtCompany.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        try {
            String currentId = ClientRepo.getCurrentId();
            String availableId = ClientRepo.getAvailableId(currentId);
            if (isValided()) {
                boolean isUpdated = ClientRepo.saveCompany(availableId, name, address, phone, email);
                if (isUpdated) {
                    clearFields();
                    setTable();
                    setCellValueFactory();
                    new Alert(Alert.AlertType.CONFIRMATION, "Company saved successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Company not saved").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private boolean isValided() {
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.NAME,txtCompany)) return true;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtAddress)) return true;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.PHONE,txtPhone)) return true;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.EMAIL,txtEmail)) return true;
        return false;
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String searchName = txtSearchBar.getText();
        String name = txtCompany.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        Client client = new Client(name,address,phone,email);
        try {
            if (isValided()) {
                boolean isUpdated = ClientRepo.updateClient(searchName, client);
                if (isUpdated) {
                    clearFields();
                    setTable();
                    setCellValueFactory();
                    new Alert(Alert.AlertType.CONFIRMATION, "Company updated successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Company not updated").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String searchName = txtSearchBar.getText();
        try {
            if (isValided()) {
                boolean isDeleted = ClientRepo.deleteClient(searchName);
                if (isDeleted) {
                    clearFields();
                    setTable();
                    setCellValueFactory();
                    new Alert(Alert.AlertType.CONFIRMATION, "Client deleted successfully").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Client deleted unsuccessfully").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    private void setCellValueFactory() {
        clmCompany.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmPhone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void clearFields() {
        txtCompany.clear();
        txtAddress.clear();
        txtPhone.clear();
        txtEmail.clear();
    }

    private void setTable() {
        ObservableList<ClientTm> observableList = FXCollections.observableArrayList();
        try {
            List<Client> clientList = ClientRepo.getAll();
            for (Client client : clientList){
                ClientTm tm = new ClientTm(
                        client.getCompany_id(),
                        client.getName(),
                        client.getAddress(),
                        client.getTel(),
                        client.getEmail()
                );
                observableList.add(tm);
            }
            tblCompany.setItems(observableList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void txtCompanyOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
        txtPhone.requestFocus();
    }

    public void companyNameKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtCompany);
    }

    public void addressKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtAddress);
    }

    public void emailKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.EMAIL,txtEmail);
    }

    public void phoneKeyReleasedOnAction(KeyEvent keyEvent) {
        Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.PHONE,txtPhone);
    }
}
