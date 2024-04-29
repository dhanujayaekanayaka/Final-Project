package lk.ijse.finalProject.repository;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.finalProject.DB.Dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverRepo {
    public static void saveDriver(String driverId, String firstName, String lastName, String address, String dob, String nic, String phone, String email) throws SQLException {
        String sql = "INSERT INTO Driver VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,driverId);
        pstm.setObject(2,firstName);
        pstm.setObject(3,lastName);
        pstm.setObject(4,address);
        pstm.setObject(5,dob);
        pstm.setObject(6,nic);
        pstm.setObject(7,phone);
        pstm.setObject(8,phone);
        pstm.setObject(9,email);
        int resultSet = pstm.executeUpdate();
        if (resultSet > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Driver saved successfully").show();
        }
    }

    public static String generateDriverId(String currentDriverId) {
        if (currentDriverId != null) {
            String[] split = currentDriverId.split("D");
            int idNum = Integer.parseInt(split[1]);
            return "D" + ++idNum;
        } else {
            return "D1";
        }
    }

    public static String getCurrentDriverId() throws SQLException {
        String sql = "SELECT driver_id FROM Driver ORDER BY driver_id DESC LIMIT 1";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            String dbDriverId = resultSet.getString("driver_id");
            return dbDriverId;
        }
        return null;
    }

    public static void setValues() throws SQLException {
        String sql = "SELECT * FROM Driver";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.executeQuery();
    }
}
