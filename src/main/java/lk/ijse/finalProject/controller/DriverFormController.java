package lk.ijse.finalProject.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lk.ijse.finalProject.model.Driver;
import lk.ijse.finalProject.model.Vehicle;
import lk.ijse.finalProject.repository.DriverRepo;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public class DriverFormController {

    public AnchorPane rootNode;
    public AnchorPane scrollPane;
    public Circle userProfile;
    public Circle dp1;
    public Circle dp2;
    public Circle dp3;
    public Circle dp4;
    public Circle dp5;
    public Circle dp6;
    public Circle dp7;
    public Circle dp8;
    public ComboBox<String > comboBox;
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
    public Label lblid1;

    public void initialize(){
        setProfilePicture();
        setName();
        setId();

    }

    private void setId() {
        try {
            List<String> id = DriverRepo.getId();
            if(id.size() < 1){
                lblid1.setText("no data");
            } else {
                lblid1.setText(id.get(0));
            }
            if (id.size() < 2) {
                lblId2.setText("no data");
            } else {
                lblId2.setText(id.get(1));
            }
            if (id.size() < 3) {
                lblId3.setText("no data");
            } else {
                lblId3.setText(id.get(2));
            }
            if (id.size() < 4) {
                lblId4.setText("no data");
            } else {
                lblId4.setText(id.get(3));
            }
            if (id.size() < 5) {
                lblId5.setText("no data");
            } else {
                lblId5.setText(id.get(4));
            }
            if (id.size() < 6) {
                lblId6.setText("no data");
            } else {
                lblId6.setText(id.get(5));
            }
            if (id.size() < 7){
                lblId7.setText("no data");
            } else {
                lblId7.setText(id.get(6));
            }
            if (id.size() < 8) {
                lblId8.setText("no data");
            } else {
                lblId8.setText(id.get(7));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void setName() {
        try {
            List<String> nameList = DriverRepo.getName() ;
            if(nameList.size() < 1){
                hplName1.setText("no data");
            } else {
                hplName1.setText(nameList.get(0));
            }
            if (nameList.size() < 2) {
                hplName2.setText("no data");
            } else {
                hplName2.setText(nameList.get(1));
            }
            if (nameList.size() < 3) {
                hplName3.setText("no data");
            } else {
                hplName3.setText(nameList.get(2));
            }
            if (nameList.size() < 4) {
                hplName4.setText("no data");
            } else {
                hplName4.setText(nameList.get(3));
            }
            if (nameList.size() < 5) {
                lblId4.setText("no data");
            } else {
                hplName5.setText(nameList.get(4));
            }
            if (nameList.size() < 6) {
                hplName6.setText("no data");
            } else {
                hplName6.setText(nameList.get(5));
            }
            if (nameList.size() < 7){
                hplName7.setText("no data");
            } else {
                hplName7.setText(nameList.get(6));
            }
            if (nameList.size() < 8) {
                hplName8.setText("no data");
            } else {
                hplName8.setText(nameList.get(7));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }



    private void setProfilePicture() {
        Image image = new Image(String.valueOf(this.getClass().getResource("/image/humen1.jpeg")));
        userProfile.setFill(new ImagePattern(image));

        Image image1 = new Image(String.valueOf(this.getClass().getResource("/driver/humen2.jpeg")));
        Image image2 = new Image(String.valueOf(this.getClass().getResource("/driver/humen3.jpeg")));
        Image image3 = new Image(String.valueOf(this.getClass().getResource("/driver/humen4.jpeg")));
        Image image4 = new Image(String.valueOf(this.getClass().getResource("/driver/manager1.jpg")));
        Image image5 = new Image(String.valueOf(this.getClass().getResource("/driver/humen5.jpg")));
        Image image6 = new Image(String.valueOf(this.getClass().getResource("/driver/manager1.jpg")));
        Image image7 = new Image(String.valueOf(this.getClass().getResource("/driver/driver2.jpg")));
        Image image8 = new Image(String.valueOf(this.getClass().getResource("/driver/dispatcher.jpeg")));

       dp1.setFill(new ImagePattern(image1));
       dp2.setFill(new ImagePattern(image2));
       dp3.setFill(new ImagePattern(image3));
       dp4.setFill(new ImagePattern(image4));
       dp5.setFill(new ImagePattern(image5));
       dp6.setFill(new ImagePattern(image6));
       dp7.setFill(new ImagePattern(image7));
       dp8.setFill(new ImagePattern(image8));
    }

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
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/driverUpdateForm.fxml"));
        this.node.getChildren().clear();;
        this.node.getChildren().add(pane);
    }

    public void btnAlertOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/view/alertForm.fxml"));
        this.rootNode.getChildren().clear();
        this.rootNode.getChildren().add(pane);
    }

    public void hplNameOnAction(ActionEvent actionEvent) {
        String id = lblid1.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl1NameOnAction(ActionEvent actionEvent) {
        String id = lblId2.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl2NameOnAction(ActionEvent actionEvent) {
        String id = lblId3.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl3NameOnAction(ActionEvent actionEvent) {
        String id = lblId4.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl4NameOnAction(ActionEvent actionEvent) {
        String id = lblId5.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl5NameOnAction(ActionEvent actionEvent) {
        String id = lblId6.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl6NameOnAction(ActionEvent actionEvent) {
        String id = lblId7.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hpl7NameOnAction(ActionEvent actionEvent) {
        String id = lblId8.getText();
        try {
            Driver driver = DriverRepo.getDetail(id);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/driverViewForm.fxml"));
            loader.load();
            DriverViewFormController driverView = loader.getController();
            driverView.sendDriver(driver);
            BorderPane pane = loader.getRoot();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle("Driver View");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
