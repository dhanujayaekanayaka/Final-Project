package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.DB.Dbconnection;

import javax.swing.text.StyledEditorKit;
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
    public JFXButton btnLogout;
    public Circle profilePicture2;
    public Circle profilePicture3;
    public Label lblEmployee1;
    public Label lblEmployee2;
    public Label lblEmployee3;
    public Label blEmployee4;
    public Label lblVehicle1;
    public Label lblVehicle2;
    public Label lblVehicle3;
    public Label lblVehicle4;
    public BarChart<?,?>  barChart;
    public TextField txtSearchBar;
    public Label lblPackage1;
    public Label lblPackage2;
    public Label lblPackage3;
    public Label lblPackage4;
    public Hyperlink hplTrackNum1;
    public Label lblCompany1;
    public Hyperlink hplTrackNum2;
    public Label lblCompany2;
    public Hyperlink hplTrackNum3;
    public Label lblCompany3;
    public Hyperlink hplTrackNum4;
    public Label lblCompany4;
    public Label lblCompanyProfile1;
    public Label lblCompanyProfile2;
    public Label lblCompanyProfile3;
    public Hyperlink hplCompany1;
    public Label lblAddress1;
    public Hyperlink hplCompany2;
    public Label lblAddress2;
    public Hyperlink hplCompany3;
    public Label lblAddress3;
    public JFXButton btnMap;
    public Box box;
    public Circle package1;
    public Circle package2;
    public Circle package3;
    public Circle package4;
    public Circle company1;
    public Circle company2;
    public Circle company3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image(getClass().getResourceAsStream("/driver/driver1.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(100,100,true,true,true,true));
        Background background = new Background(backgroundImage);
        lblEmployee1.setBackground(background);
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
        barChart.getData().add(series);
        barChart.setBarGap(10);
        barChart.setStyle("-fx-bar-color : blue");
        barChart.getData().add(series1);


    }

    private void setUserName() {

    }


    private void setProfilePicture() {
        Image dp = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
        profilePicture.setFill(new ImagePattern(dp));
        profilePicture1.setFill(new ImagePattern(dp));

        Image employee1 = new Image(getClass().getResourceAsStream("/driver/driver1.jpg"));
        Image employee2 = new Image(getClass().getResourceAsStream("/driver/humen3.jpeg"));
        Image employee3 = new Image(getClass().getResourceAsStream("/driver/driver2.jpg"));
        Image employee4 = new Image(getClass().getResourceAsStream("/driver/humen4.jpeg"));

        Image package1 = new Image(getClass().getResourceAsStream("/package/1_0x0_2119x1415_0x520_new_tyres.jpg"));
        Image package2 = new Image(getClass().getResourceAsStream("/package/086924c9-23b7-41c6-9218-45685c563a2e-h.jpeg"));
        Image package3 = new Image(getClass().getResourceAsStream("/package/fast-fashion2.jpeg"));
        Image package4 = new Image(getClass().getResourceAsStream("/package/HealthiestFruits-feb2318dc0a3454993007f57c724753f.jpg"));

        this.package1.setFill(new ImagePattern(package1));
        this.package2.setFill(new ImagePattern(package2));
        this.package3.setFill(new ImagePattern(package3));
        this.package4.setFill(new ImagePattern(package4));

        Image company1 = new Image(getClass().getResourceAsStream("/company/MAS.jpeg"));
        Image company2 = new Image(getClass().getResourceAsStream("/company/LALANNN.jpg"));
        Image company3 = new Image(getClass().getResourceAsStream("/company/brandixleed-002.jpg"));

        this.company1.setFill(new ImagePattern(company1));
        this.company2.setFill(new ImagePattern(company2));
        this.company3.setFill(new ImagePattern(company3));
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
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void btnMoveToServiceOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/ServiceForm.fxml"));
        btnDashboard.setTextFill(Paint.valueOf("#979696"));
        btnVehicle.setTextFill(Paint.valueOf("#979696"));
        btnPackage.setTextFill(Paint.valueOf("#979696"));
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

    }

    public void btnLoadMapOnAction(ActionEvent actionEvent) throws IOException {
        StackPane stackPane = FXMLLoader.load(this.getClass().getResource("/view/loadGoogleMap.fxml"));
        Scene scene = new Scene(stackPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Google Map");
        stage.centerOnScreen();

    }
}
