package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.DB.Dbconnection;

import java.awt.image.DataBuffer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiseScheduleRepo {
    public static String getShchedule1(String vehicleService) throws SQLException {
        String sql = "SELECT service_schedule_id FROM Service_schedule WHERE service_type = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,vehicleService);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
