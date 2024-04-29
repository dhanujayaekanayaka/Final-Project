package lk.ijse.finalProject.repository;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import lk.ijse.finalProject.DB.Dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepo {
    public static boolean registerVehicle(String availableId,String model, String vehicleNumber, String chassisNumber, String engineNumber, String color, String yom, String registerDate, String currentDistance) throws SQLException {
        String sql = "INSERT INTO Vehicle VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,availableId);
        pstm.setObject(2,model);
        pstm.setObject(3,vehicleNumber);
        pstm.setObject(4,chassisNumber);
        pstm.setObject(5,engineNumber);
        pstm.setObject(6,color);
        pstm.setObject(7, yom);
        pstm.setObject(8,registerDate);
        pstm.setObject(9,currentDistance);
        return pstm.executeUpdate() > 0;
    }

    public static String getVehicleId() throws SQLException {
        String sql = "SELECT vehicle_id FROM Vehicle ORDER BY vehicle_id DESC LIMIT 1";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            String dbId = resultSet.getString("vehicle_id");
            return dbId;
        }
        return null;
    }

    public static String getVehicleId(String currentId) {
        if (currentId != null) {
            String[] split = currentId.split("V");
            int idNum = Integer.parseInt(split[1]);
            return "V" + ++idNum;
        } else {
            return "V1";
        }
    }

    public static void setUpScrollPane(ScrollPane scrollpane) throws SQLException {
        String sql = "SELECT first_name FROM Vehicle";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String dbName = resultSet.getString("first_name");
            List<String> dbNameList = new ArrayList();
            dbNameList.add(dbName);
            scrollpane.getChildrenUnmodifiable().add((Node) dbNameList);
        }
    }
}
