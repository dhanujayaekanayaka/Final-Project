package lk.ijse.finalProject.model;

import lk.ijse.finalProject.DB.Dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ServiceCenterRepo {
    public static String getCurrentId() throws SQLException {
        String sql = "SELECT service_center_id FROM Service_center ORDER BY service_center_id DESC LIMIT 1";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return resultSet.getString("service_center_id");
        }
        return null;
    }

    public static String getAvilableId(String currentId) {
        if (currentId != null){
            String[] split = currentId.split("SCI");
            int idNum = Integer.parseInt(split[1]);
            return "SCI" + ++idNum;
        }
        return "SCI1";
    }

    public static boolean saveCenter(ServiceCenter serviceCenter) throws SQLException {
        String sql = "INSERT INTO Service_center VALUES(?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        return pstm.executeUpdate() > 0;
    }

    public static ServiceCenter getAll(String text) throws SQLException {
        String sql = "SELECT * FROM Service_center";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String location = resultSet.getString(3);
            String tel = resultSet.getString(4);
            String email = resultSet.getString(5);
            ServiceCenter center = new ServiceCenter(id,name,location,tel,email);
            return center;
        }
        return null;
    }

    public static boolean update(ServiceCenter serviceCenter) throws SQLException {
        String sql = "UPDATE Service_center SET center_name = ?,location = ?,contact_number = ?,email = ? WHERE service_center_id =? ";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,serviceCenter.getName());
        pstm.setObject(2,serviceCenter.getLocation());
        pstm.setObject(3,serviceCenter.getTel());
        pstm.setObject(4,serviceCenter.getEmail());
        pstm.setObject(5,serviceCenter.getId());
        return pstm.executeUpdate() > 0;
    }
}
