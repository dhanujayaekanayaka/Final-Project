package lk.ijse.finalProject.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.model.Client;
import lk.ijse.finalProject.model.tm.ClientTm;
import lk.ijse.finalProject.repository.ClientRepo;
import lk.ijse.finalProject.repository.PackageRepo;
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
    public BarChart<?,?> barChart1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable();
        setCellValueFactory();
        setProfile();
        setLabel();
        setBarChart();
    }

    private void setBarChart() {
        try {
            int packageCount1 = PackageRepo.getPackageCount1("C1");
            int packageCount2 = PackageRepo.getPackageCount1("C2");
            int packageCount3 = PackageRepo.getPackageCount1("C3");
            int packageCount4 = PackageRepo.getPackageCount1("C4");
            int packageCount5 = PackageRepo.getPackageCount1("C5");

            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data("1",packageCount1));
            series.getData().add(new XYChart.Data("2",packageCount2));
            series.getData().add(new XYChart.Data("3",packageCount3));
            series.getData().add(new XYChart.Data("4",packageCount4));
            series.getData().add(new XYChart.Data("5",packageCount5));
            barChart1.getData().add(series);
            barChart1.setTitle("Company Packages");
            userName.setText("admin");

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setLabel() {
        try {
            List<String> company = ClientRepo.getAllCompany();
            company1.setText(company.get(0));
            company2.setText(company.get(1));
            company3.setText(company.get(2));
            company4.setText(company.get(4));
            company5.setText(company.get(3));

            List<String> number = ClientRepo.getNumber();
            tel1.setText(number.get(0));
            tel2.setText(number.get(1));
            tel3.setText(number.get(2));
            tel4.setText(number.get(4));
            tel5.setText(number.get(3));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setProfile() {
        Image image = new Image(getClass().getResourceAsStream("/image/humen1.jpeg"));
        this.profilePicture.setFill(new ImagePattern(image));

        Image image1 = new Image(getClass().getResourceAsStream("/company/MAS.jpeg"));
        Image image2 = new Image(getClass().getResourceAsStream("/company/LALANNN.jpg"));
        Image image3 = new Image(getClass().getResourceAsStream("/company/brandixleed-002.jpg"));
        Image image4 = new Image(getClass().getResourceAsStream("/company/Ansell.jpg"));
        Image image5 = new Image(getClass().getResourceAsStream("/company/Outclass-Crystallized-Gems.jpg"));

        profilePicture1.setFill(new ImagePattern(image1));
        profilePicture2.setFill(new ImagePattern(image2));
        profilePicture3.setFill(new ImagePattern(image3));
        profilePicture4.setFill(new ImagePattern(image4));
        profilePicture5.setFill(new ImagePattern(image5));
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
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.NAME,txtCompany)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.WORD,txtAddress)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.PHONE,txtPhone)) return false;
        if (!Regex.setTextFieldColor(lk.ijse.finalProject.util.TextField.EMAIL,txtEmail)) return false;
        return true;
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
