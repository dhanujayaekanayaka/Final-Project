package lk.ijse.finalProject.repository;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import lk.ijse.finalProject.DB.Dbconnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {

    public static void checkCredintial(String username, String password) throws SQLException, IOException {
        String sql = "SELECT user_name,password FROM User WHERE user_name = ? || user_id = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,username);
        pstm.setObject(2,username);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            String dbPw = resultSet.getString("password");
                if (password.equals(dbPw)){
                    navigateToTheDashboard();
                } else {
                    new Alert(Alert.AlertType.ERROR,"Invalid password").show();
                }
        } else {
            new Alert(Alert.AlertType.ERROR,"Sorry can't find user").show();
        }
    }


    private static void navigateToTheDashboard() throws IOException {
        SplitPane splitPane = FXMLLoader.load(UserRepo.class.getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(splitPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
        stage.show();
    }
}
