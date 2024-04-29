package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.ijse.finalProject.repository.VehicleRepo;

import java.io.IOException;
import java.sql.SQLException;

public class VehicleFormController {
    public TextField txtModel;
    public TextField txtVehicleNumber;
    public TextField txtColor;
    public TextField txtYom;
    public TextField txtRegDate;
    public TextField txtCurrentMillage;
    public TextField txtChassisNumber;
    public TextField txtEngineNumber;
    public ImageView imvProfilePicture;
    public AnchorPane rootNode;
    public ScrollPane scrollPane;

    public void initialize(){
        try {
            VehicleRepo.setUpScrollPane(scrollPane);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();;
        }
    }
    public void btnConformOnAction(ActionEvent event) {
    }

    public void btnClearOnAction(ActionEvent event) {
    }

    public void btnSaveOnAction(ActionEvent event) {
        String model = txtModel.getText();
        String vehicleNumber = txtVehicleNumber.getText();
        String chassisNumber = txtChassisNumber.getText();
        String engineNumber = txtEngineNumber.getText();
        String color = txtColor.getText();
        String  yom = txtYom.getText();
        String registerDate = txtRegDate.getText();
        String currentDistance = txtCurrentMillage.getText();
        try {
            String currentId = VehicleRepo.getVehicleId();
            String availableId = VehicleRepo.getVehicleId(currentId);
            boolean isSaved = VehicleRepo.registerVehicle(availableId,model,vehicleNumber,chassisNumber,engineNumber,color,yom,registerDate,currentDistance);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Vehicle saved successfully").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Vehicle not saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnBackToLoginOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
    }

    public void btnMovetoDriverFormOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToVehicleFormAction(ActionEvent actionEvent) {
    }

    public void btnMoveToPackageFormOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToRouteOnAction(ActionEvent actionEvent) {
    }

    public void btnMyProfileOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToDashboardOnAction(ActionEvent actionEvent) {
    }

    public void btnMoveToServiceOnAction(ActionEvent actionEvent) {
    }
}
