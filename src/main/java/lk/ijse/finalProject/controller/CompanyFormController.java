package lk.ijse.finalProject.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.Client;
import lk.ijse.finalProject.model.tm.ClientTm;
import lk.ijse.finalProject.repository.ClientRepo;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CompanyFormController implements Initializable {
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtEmail;
    public TextField txtSearch;
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

    public void txtNAmeOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void txtAddresOnAction(ActionEvent actionEvent) {
        txtPhone.requestFocus();
    }

    public void txtPhoneOnAction(ActionEvent actionEvent) {
        txtEmail.requestFocus();
    }

    public void txtEmailOnAction(ActionEvent actionEvent) {
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String companyName = txtSearch.getText();
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
            boolean isUpdated = ClientRepo.saveCompany(availableId, name, address, phone, email);
            if (isUpdated){
                clearFields();
                setTable();
                setCellValueFactory();
                new Alert(Alert.AlertType.CONFIRMATION,"Company saved successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"Company not saved").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String searchName = txtSearch.getText();
        String name = txtCompany.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        Client client = new Client(name,address,phone,email);
        try {
            boolean isUpdated = ClientRepo.updateClient(searchName, client);
            if (isUpdated){
                clearFields();
                setTable();
                setCellValueFactory();
                new Alert(Alert.AlertType.CONFIRMATION,"Company updated successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"Company not updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String searchName = txtSearch.getText();
        try {
            boolean isDeleted = ClientRepo.deleteClient(searchName);
            if (isDeleted){
                clearFields();
                setTable();
                setCellValueFactory();
                new Alert(Alert.AlertType.CONFIRMATION,"Client deleted successfully").show();
            } else {
                new Alert(Alert.AlertType.ERROR,"Client deleted unsuccessfully").show();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable();
        setCellValueFactory();
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
    }

    public void txtAddressOnAction(ActionEvent actionEvent) {
    }
}
