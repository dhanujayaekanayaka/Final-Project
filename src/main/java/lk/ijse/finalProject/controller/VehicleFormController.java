package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.model.Vehicle;
import lk.ijse.finalProject.model.tm.VehicleTm;
import lk.ijse.finalProject.repository.DriverRepo;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static lk.ijse.finalProject.repository.VehicleRepo.getVehicleId;

public class VehicleFormController {
    public AnchorPane rootNode;
    public ScrollPane scrollPane;
    public Circle vp1;
    public Circle vp2;
    public Circle vp3;
    public Circle vp4;
    public Circle vp5;
    public Circle vp6;
    public Circle vp7;
    public Circle vp8;
    public Label vnp1;
    public Label vnp2;
    public Label vnp3;
    public Label vnp4;
    public Label vnp5;
    public Label vnp6;
    public Label vnp7;
    public Label vnp8;
    public Label username;
    public JFXComboBox<String> comboBox;
    public Circle profilePicture;
    public Pane node;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnAlert;
    public JFXButton btnTips;
    public Hyperlink hplName1;
    public Hyperlink hplName2;
    public Hyperlink hplName3;
    public Hyperlink hplName4;
    public Hyperlink hplName5;
    public Hyperlink hplName6;
    public Hyperlink hplName7;
    public Hyperlink hplName8;

    public void initialize(){
        setProfile();
        setNumberPlate();
        setName();
    }

    private void setName() {
        try {
            List<String> vehicleName = VehicleRepo.getVehicleName();
            if(vehicleName.size() < 1){
                hplName1.setText("no data");
            } else {
                hplName1.setText(vehicleName.get(0));
            }
            if (vehicleName.size() < 2) {
                hplName2.setText("no data");
            } else {
                hplName2.setText(vehicleName.get(1));
            }
            if (vehicleName.size() < 3) {
                hplName3.setText("no data");
            } else {
                hplName3.setText(vehicleName.get(2));
            }
            if (vehicleName.size() < 4) {
                hplName4.setText("no data");
            } else {
                hplName4.setText(vehicleName.get(3));
            }
            if (vehicleName.size() < 5) {
                hplName5.setText("no data");
            } else {
                hplName5.setText(vehicleName.get(4));
            }
            if (vehicleName.size() < 6) {
                hplName6.setText("no data");
            } else {
                hplName6.setText(vehicleName.get(5));
            }
            if (vehicleName.size() < 7){
                hplName7.setText("no data");
            } else {
                hplName7.setText(vehicleName.get(6));
            }
            if (vehicleName.size() < 8) {
                hplName8.setText("no data");
            } else {
                hplName8.setText(vehicleName.get(7));
            }
//            hplName1.setText(vehicleName.get(0));
//            hplName2.setText(vehicleName.get(1));
//            hplName3.setText(vehicleName.get(2));
//            hplName4.setText(vehicleName.get(3));
//            hplName5.setText(vehicleName.get(4));
//            hplName6.setText(vehicleName.get(5));
//            hplName7.setText(vehicleName.get(6));
//            hplName8.setText(vehicleName.get(7));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setNumberPlate() {
        try {
            List<String> vehicleNumber = VehicleRepo.getVehicleNumber();
            if(vehicleNumber.size() < 1){
                vnp1.setText("no data");
            } else {
                vnp1.setText(vehicleNumber.get(0));
            }
            if (vehicleNumber.size() < 2) {
                vnp2.setText("no data");
            } else {
                vnp2.setText(vehicleNumber.get(1));
            }
            if (vehicleNumber.size() < 3) {
                vnp3.setText("no data");
            } else {
                vnp3.setText(vehicleNumber.get(2));
            }
            if (vehicleNumber.size() < 4) {
                vnp4.setText("no data");
            } else {
                vnp4.setText(vehicleNumber.get(3));
            }
            if (vehicleNumber.size() < 5) {
                vnp5.setText("no data");
            } else {
                vnp5.setText(vehicleNumber.get(4));
            }
            if (vehicleNumber.size() < 6) {
                vnp6.setText("no data");
            } else {
                vnp6.setText(vehicleNumber.get(5));
            }
            if (vehicleNumber.size() < 7){
                vnp7.setText("no data");
            } else {
                vnp7.setText(vehicleNumber.get(6));
            }
            if (vehicleNumber.size() < 8) {
                vnp8.setText("no data");
            } else {
                vnp8.setText(vehicleNumber.get(7));
            }
//            vnp1.setText(vehicleNumber.get(0));
//            vnp2.setText(vehicleNumber.get(1));
//            vnp3.setText(vehicleNumber.get(2));
//            vnp4.setText(vehicleNumber.get(3));
//            vnp5.setText(vehicleNumber.get(4));
//            vnp6.setText(vehicleNumber.get(5));
//            vnp7.setText(vehicleNumber.get(6));
//            vnp8.setText(vehicleNumber.get(7));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setProfile() {
        Image image = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
        profilePicture.setFill(new ImagePattern(image));

        Image image1 = new Image(String.valueOf(this.getClass().getResource("/truck/daf.jpeg")));
        Image image2 = new Image(String.valueOf(this.getClass().getResource("/truck/Scania3.jpg")));
        Image image3 = new Image(String.valueOf(this.getClass().getResource("/truck/image-2.jpeg")));
        Image image4 = new Image(String.valueOf(this.getClass().getResource("/truck/Scania1.jpeg")));
        Image image5 = new Image(String.valueOf(this.getClass().getResource("/truck/DAF1.jpeg")));
        Image image6 = new Image(String.valueOf(this.getClass().getResource("/truck/Scania2.jpg")));
        Image image7 = new Image(String.valueOf(this.getClass().getResource("/truck/daf.jpg")));
        Image image8 = new Image(String.valueOf(this.getClass().getResource("/truck/images.jpeg")));

        vp1.setFill(new ImagePattern(image1));
        vp2.setFill(new ImagePattern(image2));
        vp3.setFill(new ImagePattern(image3));
        vp4.setFill(new ImagePattern(image4));
        vp5.setFill(new ImagePattern(image5));
        vp6.setFill(new ImagePattern(image6));
        vp7.setFill(new ImagePattern(image7));
        vp8.setFill(new ImagePattern(image8));
    }
    public void btnTipsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/tipsForm.fxml"));
        this.node.getChildren().clear();
        this.node.getChildren().add(pane);
        btnTips.setCursor(Cursor.HAND);

    }

    public void btnVehicleAddOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/vehicleAddForm.fxml"));
        this.node.getChildren().clear();
        this.node.getChildren().add(pane);

    }

    public void btnVehicleUpdateOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/vehicleUpdateForm.fxml"));
        this.node.getChildren().clear();;
        this.node.getChildren().add(pane);

    }

    public void btnAlertOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/alertForm.fxml"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void comboIdOnAction(ActionEvent actionEvent) {
        VehicleUpdateFormController.sendComboVAlues(comboBox.getValue());

    }

    public void hpl1OnAction(ActionEvent actionEvent) throws IOException {
        String vehicleNumber = vnp1.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl2OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp2.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl3OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp3.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl4OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp4.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl5OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp5.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl6OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp6.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl7OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp7.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl8OnAction(ActionEvent actionEvent) {
        String vehicleNumber = vnp8.getText();
        try {
            Vehicle vehicle = VehicleRepo.getDetail(vehicleNumber);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/vehicleViewForm.fxml"));
            loader.load();
            VehicleViewFormController vehicleView = loader.getController();
            vehicleView.sendName(vehicle);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Vehicle View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
