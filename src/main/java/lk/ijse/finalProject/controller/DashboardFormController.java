package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.DB.Dbconnection;

import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public Label lblDatePicker;
    public Circle profilePicture;
    public Label userName;
    public Circle profilePicture1;
    public Label lblCompanyCount;
    @FXML
    public LineChart<?,?> lineChart;
    @FXML
    public BorderPane parent;
    public Pane rootNode;
    public JFXButton btnDashboard;
    public JFXButton btnVehicle;
    public JFXButton btnDriver;
    public JFXButton btnPackage;
    public JFXButton btnService;
    public JFXButton btnCompany;
    public JFXButton btnRoute;

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
        Stage stage = (Stage) this.parent.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.centerOnScreen();
    }

    public void btnMoveToDriverFormOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverForm.fxml"));
        DriverFormController driverFormController = new DriverFormController();
        driverFormController.sendParent(this.parent);
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#979696"));
        btnRoute.setTextFill(Paint.valueOf("#979696"));
        btnService.setTextFill(Paint.valueOf("#979696"));
        btnCompany.setTextFill(Paint.valueOf("#979696"));
        btnDriver.setTextFill(Paint.valueOf("#1d4e89"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void btnMoveToVehicleFormAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/vehicleForm.fxml"));
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#979696"));
        btnRoute.setTextFill(Paint.valueOf("#979696"));
        btnService.setTextFill(Paint.valueOf("#979696"));
        btnDriver.setTextFill(Paint.valueOf("#979696"));
        btnCompany.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#1d4e89"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void btnMoveToPackageFormOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/packageForm.fxml"));
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#979696"));
        btnRoute.setTextFill(Paint.valueOf("#979696"));
        btnService.setTextFill(Paint.valueOf("#979696"));
        btnDriver.setTextFill(Paint.valueOf("#979696"));
        btnCompany.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#1d4e89"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void btnMoveToRouteOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/routeForm.fxml"));
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#979696"));
        btnService.setTextFill(Paint.valueOf("#979696"));
        btnDriver.setTextFill(Paint.valueOf("#979696"));
        btnCompany.setTextFill(Paint.valueOf("#979696"));
        btnRoute.setTextFill(Paint.valueOf("#1d4e89"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void btnMoveToServiceOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/ServiceForm.fxml"));
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#979696"));
        btnRoute.setTextFill(Paint.valueOf("#979696"));
        btnDriver.setTextFill(Paint.valueOf("#979696"));
        btnCompany.setTextFill(Paint.valueOf("#979696"));
        btnService.setTextFill(Paint.valueOf("#1d4e89"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void btnMyProfileOnAction(ActionEvent event) {
    }

    public void btnMoveToDashboardOnAction(ActionEvent event) throws IOException {
        BorderPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.parent.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
    }

    public void btnMoveToCompanyFormOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/companyForm.fxml"));
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#979696"));
        btnRoute.setTextFill(Paint.valueOf("#979696"));
        btnService.setTextFill(Paint.valueOf("#979696"));
        btnDriver.setTextFill(Paint.valueOf("#979696"));
        btnCompany.setTextFill(Paint.valueOf("#1d4e89"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void hplSeeAllPackageOnAction(ActionEvent actionEvent) {
    }

    public void hplTrackNum1OnAction(ActionEvent actionEvent) {
    }

    public void hplTrackNum2OnAction(ActionEvent actionEvent) {
    }

    public void hplTrackNum3OnAction(ActionEvent actionEvent) {
    }

    public void hplSeeAllCompanyOnAction(ActionEvent actionEvent) {
    }

    public void hplCompany1OnAction(ActionEvent actionEvent) {
    }

    public void hplCompany2OnAction(ActionEvent actionEvent) {
    }

    public void hplCompany3OnAction(ActionEvent actionEvent) {
    }

    public void hplTrackNum4OnAction(ActionEvent actionEvent) {
    }

    public void btnMouseClickOnAction(MouseEvent mouseEvent) {
        btnDashboard.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");
        btnDriver.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");
        btnVehicle.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");
        btnCompany.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");
        btnPackage.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");
        btnService.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");
        btnRoute.setStyle("-fx-background-color: #BDE0FE;\n" +
                "    -fx-border-color: #0F4D87;\n" +
                "    -fx-border-width: 0px 0px 0px 5px;");

    }
}
