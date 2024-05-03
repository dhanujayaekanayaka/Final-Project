package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.DB.Dbconnection;
import lk.ijse.finalProject.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepo {
    public static boolean registerVehicle(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO Vehicle VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,vehicle.getId());
        pstm.setObject(2,vehicle.getName());
        pstm.setObject(3,vehicle.getVehicle_number());
        pstm.setObject(4,vehicle.getChassis());
        pstm.setObject(5,vehicle.getEngineNum());
        pstm.setObject(6,vehicle.getColor());
        pstm.setObject(7, vehicle.getYom());
        pstm.setObject(8,vehicle.getRegDate());
        pstm.setObject(9,vehicle.getCurrentDistance());
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

    public static List<Vehicle> getId() throws SQLException {
        String sql = "SELECT vehicle_id FROM Vehicle";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<Vehicle> idList = new ArrayList<>();
        while (resultSet.next()){
            String dbId = resultSet.getString("vehicle_id");
            Vehicle vehicle = new Vehicle();
            vehicle.setId(dbId);
            idList.add(vehicle);
        }
        return idList;
    }
}
