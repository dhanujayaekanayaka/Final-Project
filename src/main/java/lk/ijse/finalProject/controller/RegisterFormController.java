package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.finalProject.Launcher;
import lk.ijse.finalProject.repository.UserRepo;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public TextField txtReEnterPassword;
    @FXML
    public AnchorPane pane;

    public void txtUsernameOnAction(ActionEvent actionEvent) {
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
    }

    public void txtReEnterPasswordOnAction(ActionEvent actionEvent) {
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        String rePw = txtReEnterPassword.getText();

        try {
            String currentId = UserRepo.getCurrentId();
            String nextId = UserRepo.getNextAvailableId(currentId);
            UserRepo.registerUser(userName,password,rePw,nextId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/loginForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
        stage.show();
    }
}
