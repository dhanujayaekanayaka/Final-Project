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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.model.Vehicle;
import lk.ijse.finalProject.model.tm.VehicleTm;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
    public Label vn1;
    public Label vnp1;
    public Label vn2;
    public Label vnp2;
    public Label vn3;
    public Label vnp3;
    public Label vn4;
    public Label vnp4;
    public Label vn5;
    public Label vnp5;
    public Label vn6;
    public Label vnp6;
    public Label vn7;
    public Label vnp7;
    public Label vn8;
    public Label vnp8;
    public Label username;
    public JFXComboBox<String> comboBox;
    public Circle profilePicture;
    public Pane node;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnAlert;
    public JFXButton btnTips;

    public void initialize(){
        setProfile();
        getVehiclesId();
        VehicleUpdateFormController.sendComboVAlues(comboBox.getValue());
    }
    private void getVehiclesId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> idList = VehicleRepo.getId();
            for (String id : idList){
                obList.add(id);
                comboBox.setItems(obList);
            }
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
}
