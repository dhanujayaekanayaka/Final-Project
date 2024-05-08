package lk.ijse.finalProject.repository;

import javafx.collections.FXCollections;
import javafx.scene.LightBase;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Circle;
import lk.ijse.finalProject.DB.Dbconnection;
import lk.ijse.finalProject.model.Driver;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverRepo {
    public static boolean saveDriver(String driverId, String firstName, String lastName, String address, String nic, Date dob, String vehicleId, String phone, String email, String profile) throws SQLException {
        String sql = "INSERT INTO Driver VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,driverId);
        pstm.setObject(2,firstName);
        pstm.setObject(3,lastName);
        pstm.setObject(4,address);
        pstm.setObject(5,nic);
        pstm.setObject(6,dob);
        pstm.setObject(7,vehicleId);
        pstm.setObject(8,phone);
        pstm.setObject(9,email);
        pstm.setObject(10,profile);
        return pstm.executeUpdate() > 0;
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

    public static void setComboBox(ComboBox comboBox) throws SQLException {
        String sql = "SELECT driver_id FROM Driver";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            String driverId = resultSet.getString("driver_id");
            comboBox.setItems(FXCollections.observableArrayList("driverId"));
        }
    }

    public static List<String> getName() throws SQLException {
        String sql = "SELECT first_name,second_name FROM Driver ORDER BY driver_id DESC LIMIT 1";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<String> nameList = new ArrayList<>();
        if (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("second_name");
            nameList.add(firstName + " " + lastName);
            return nameList;
        }
        return null;
    }
}



