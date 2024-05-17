package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.DB.Dbconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceRepo {
    public static String  getAvailableId() throws SQLException {
        String sql = "SELECT service_id FROM Service ORDER BY service_id DESC LIMIT 1";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    public static String  getCurrentId(String currentId) {
        if (currentId != null){
            String[] split = currentId.split("SE");
            int idNum = Integer.parseInt(split[1]);
            return "SE" + ++idNum;
        }
        return "SE1";
    }
}
