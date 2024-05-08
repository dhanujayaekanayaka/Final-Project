package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.model.Driver;
import lk.ijse.finalProject.repository.DriverRepo;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.zip.ZipFile;

public class DriverFormController {
    public TextField txtFirstName   ;
    public TextField txtLastName;
    public TextField txtAddress;
    public TextField txtDob;
    public TextField txtNic;
    public TextField txtPhone;
    public TextField txtEmail;
    public AnchorPane rootNode;
    public AnchorPane scrollPane;
    public Circle userProfile;
    public Circle driverProfile;
    public Circle dp1;
    public Label dnp1;
    public Circle dp2;
    public Label dn2;
    public Label dnp2;
    public Circle dp3;
    public Label dn3;
    public Label dnp3;
    public Circle dp4;
    public Label dn4;
    public Label dnp4;
    public Circle dp5;
    public Label dn5;
    public Label dnp5;
    public Circle dp6;
    public Label dn6;
    public Label dnp6;
    public Circle dp7;
    public Label dn7;
    public Label dnp7;
    public Circle dp8;
    public Label dn8;
    public Label dnp8;
    public ComboBox<String > comboBox;
    public Label dn1;
    public Pane node;
    public JFXButton txtTips;
    public JFXButton btnAdd;
    public JFXButton btnUpdate;
    public JFXButton btnAlert;
    public Hyperlink hplName1;
    public Hyperlink hplName2;
    public Hyperlink hplName3;
    public Hyperlink hplName4;
    public Hyperlink hplName5;
    public Hyperlink hplName6;
    public Hyperlink hplName7;
    public Hyperlink hplName8;
    public Label lblId2;
    public Label lblId3;
    public Label lblId4;
    public Label lblId5;
    public Label lblId6;
    public Label lblId7;
    public Label lblId8;
    public Label label;
    public Label lblid1;

//    public void initialize(){
////        setCombo();
//        setProfilePicture();
//       // setName();
//
//    }

    private void setName() {
        try {
            List<String > nameList = DriverRepo.getName() ;
            for (int i = 0; i < nameList.size(); i++) {
                System.out.println(nameList);
            }

        //    hplName1.setText(nameList.get(0));
//            hplName2.setText(nameList.get(1));
//            hplName3.setText(nameList.get(2));
//            hplName4.setText(nameList.get(3));
//            hplName5.setText(nameList.get(4));
//            hplName6.setText(nameList.get(5));
//            hplName7.setText(nameList.get(6));
//            hplName8.setText(nameList.get(7));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setCombo() {
    }


//    private void setProfilePicture() {
//        Image image = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
//        userProfile.setFill(new ImagePattern(image));
//
//        Image image1 = new Image(String.valueOf(this.getClass().getResource("/driver/humen2.jpeg")));
//        Image image2 = new Image(String.valueOf(this.getClass().getResource("/driver/humen3.jpeg")));
//        Image image3 = new Image(String.valueOf(this.getClass().getResource("/driver/humen4.jpeg")));
//        Image image4 = new Image(String.valueOf(this.getClass().getResource("/driver/driver1.jpg")));
//        Image image5 = new Image(String.valueOf(this.getClass().getResource("/driver/humen5.jpg")));
//        Image image6 = new Image(String.valueOf(this.getClass().getResource("/driver/manager1.jpg")));
//        Image image7 = new Image(String.valueOf(this.getClass().getResource("/driver/driver2.jpg")));
//        Image image8 = new Image(String.valueOf(this.getClass().getResource("/driver/dispatcher.jpeg")));
//
//
//        label.setBackground();
//        dp2.setFill(new ImagePattern(image2));
//        dp3.setFill(new ImagePattern(image3));
//        dp4.setFill(new ImagePattern(image4));
//        dp5.setFill(new ImagePattern(image5));
//        dp6.setFill(new ImagePattern(image6));
//        dp7.setFill(new ImagePattern(image7));
//        dp8.setFill(new ImagePattern(image8));
//    }

    public void btnClearOnAction(ActionEvent event) {
    }


    public void hplViewDriverOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane node = FXMLLoader.load(this.getClass().getResource("/view/driverViewForm.fxml"));
        Scene scene = new Scene(node);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Driver Info");
        stage.centerOnScreen();
    }

    public void btnNextOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/vehicleSelection.fxml"));
        this.node.getChildren().clear();
        this.node.getChildren().add(rootNode);
    }
    public void btnTipsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverTipsForm.fxml"));
        this.node.getChildren().clear();
        this.node.getChildren().add(pane);
    }
    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverAddForm.fxml"));
        this.node.getChildren().clear();
        this.node.getChildren().add(pane);
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverAddForm.fxml"));
        this.node.getChildren().clear();;
        this.node.getChildren().add(pane);
    }

    public void btnAlertOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/alertForm.fxml"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void hplNameOnAction(ActionEvent actionEvent) {
    }
}
