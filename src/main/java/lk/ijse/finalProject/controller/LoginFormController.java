package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.finalProject.repository.UserRepo;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public TextField txtUsername;
    public TextField txtPassword;

    public void txtUsernameOnAction(ActionEvent actionEvent) {
        txtPasswordOnAction(actionEvent);
    }

    public void txtPasswordOnAction(ActionEvent event) {
        btnLoginOnAction(event);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        try {
            UserRepo.checkCredintial(username,password);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void hplForgotPasswordOnAction(ActionEvent actionEvent) {
    }

    public void hplRegisterOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource("/view/registerForm.fxml"));
        Scene scene = new Scene(node);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Registration Form");
        stage.centerOnScreen();
        stage.show();

    }
}
