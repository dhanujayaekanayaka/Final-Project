package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.DB.Dbconnection;
import lk.ijse.finalProject.model.Shipment;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShipmentRepo {
    public static boolean inputShipment(Shipment shipment) throws SQLException {
        String sql = "INSERT INTO Shipment VALUES (?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        return pstm.executeUpdate() > 0;
    }
}
