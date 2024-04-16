package lk.ijse.finalProject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.finalProject.DB.Dbconnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {
    @FXML
    public TextField txtUsername;
    @FXML
    public TextField txtPassword;
    public AnchorPane rootNode;

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
            checkCredintial(username,password);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    private void checkCredintial(String username, String password) throws SQLException {
        String sql = "SELECT user_name,password FROM User WHERE user_name = ? || user_id = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,username);
        pstm.setObject(2,username);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            String dbPw = resultSet.getString("password");
            if (password.equals(dbPw)){
                try {
                    navigateToTheDashboard();
                } catch (IOException e) {
                    new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

                }
            } else {
                new Alert(Alert.AlertType.ERROR,"Invalid password").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR,"Sorry can't find user").show();
        }
    }

    private void navigateToTheDashboard() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }

    public void hplForgotPasswordOnAction(ActionEvent actionEvent) {
    }

    public void hplRegisterOnAction(ActionEvent actionEvent) throws IOException {
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/registerForm.fxml"));
        Scene scene = new Scene(node);
        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Registration Form");
        stage.centerOnScreen();
        stage.show();

    }
}
