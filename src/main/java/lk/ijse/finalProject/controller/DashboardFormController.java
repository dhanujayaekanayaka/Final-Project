package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.DB.Dbconnection;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    public AnchorPane rootNode;
    public Label lblDatePicker;
    public Circle profilePicture;
    public Label userName;
    public Circle profilePicture1;
    public TableView tblRoute;
    public TableColumn clanRoute;
    public TableColumn clmnAvailability;
    @FXML
    private LineChart<?, ?> lineChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserName();
        setProfilePicture();
        setDate();

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1",5));
        series.getData().add(new XYChart.Data("2",4));
        series.getData().add(new XYChart.Data("3",6));
        series.getData().add(new XYChart.Data("4",7));
        series.getData().add(new XYChart.Data("5",7));
        lineChart.getData().add(series);

        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data("1",4));
        series1.getData().add(new XYChart.Data("2",3));
        series1.getData().add(new XYChart.Data("3",7));
        series1.getData().add(new XYChart.Data("4",7));

        lineChart.getData().add(series1);
    }

    private void setUserName() {

    }


    private void setProfilePicture() {
        Image dp = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
        profilePicture.setFill(new ImagePattern(dp));
        profilePicture1.setFill(new ImagePattern(dp));
    }

    public void setDate(){
        LocalDate now = LocalDate.now();
        lblDatePicker.setText(String.valueOf(now));
    }

    public void btnBackToLoginOnAction(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnMoveToDriverFormOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverForm.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Driver Form");
        stage.centerOnScreen();
    }

    public void btnMoveToVehicleFormAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/vehicleForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Vehicle Form");
        stage.centerOnScreen();
    }

    public void btnMoveToPackageFormOnAction(ActionEvent event) {
    }

    public void btnMoveToRouteOnAction(ActionEvent event) {
    }

    public void btnMoveToServiceOnAction(ActionEvent event) {
    }

    public void btnMyProfileOnAction(ActionEvent event) {
    }

    public void btnMoveToDashboardOnAction(ActionEvent event) {
    }


}
