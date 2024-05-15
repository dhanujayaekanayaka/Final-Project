package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.DB.Dbconnection;
import lk.ijse.finalProject.model.Package;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PackageRepo {
    public static List<String > getCompanyId() throws SQLException {
        String sql = "SELECT client_company_id FROM Client";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        List<String> idList = new ArrayList<>();
        while (resultSet.next()){
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

    public static String getCurrentId() throws SQLException {
        String sql = "SELECT order_id FROM Client_order ORDER BY order_id DESC LIMIT 1";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    public static String getAvailableId(String currentId) {
        if (currentId != null){
            String[] split = currentId.split("P");
            int idNum = Integer.parseInt(split[1]);
            return "P" + ++idNum;
        }
        return "P1";
    }

    public static String getTrackingNumber() throws SQLException {
        String sql = "SELECT tracking_number FROM Client_order";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
           return resultSet.getString(2);
        }
        return null;
    }

    public static String getAvailableNumber(String currentTrackingNUmber) {
        if (currentTrackingNUmber != null){
            String[] split = currentTrackingNUmber.split("TR");
            int idNum = Integer.parseInt(split[1]);
            return "TR" + ++idNum;
        }
        return "TR1";
    }
    public static String getCurrentShipmenId() throws SQLException {
        String sql = "SELECT shipment_id FROM Shipment";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return resultSet.getString("shipment_id");
        }
        return null;
    }

    public static String getAvailableShipmentId(String currentShipmentId) {
        if (currentShipmentId != null){
            String[] split = currentShipmentId.split("S");
            int idNum = Integer.parseInt(split[1]);
            return "S" + ++idNum;
        }
        return "S1";
    }

    public static boolean savePackage(Package savePackage) throws SQLException {
        String sql = "INSERT INTO Client_order VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,savePackage.getOrderId());
        pstm.setObject(2,savePackage.getTrackingNumber());
        pstm.setObject(3,savePackage.getCompanyId());
        pstm.setObject(4,savePackage.getTypeOfGood());
        pstm.setDouble(5,savePackage.getWeight());
        pstm.setObject(6,savePackage.getDeliveryType());
        pstm.setDate(7,savePackage.getBorrowDAte());
        pstm.setObject(8,savePackage.getShipmentId());
        return pstm.executeUpdate() > 0;
    }

    public static List<Package> getAll(String packageId) throws SQLException {
        String sql = "SELECT * FROM Client_order WHERE order_id = ?";
        PreparedStatement pstm = Dbconnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1,packageId);
        ResultSet resultSet = pstm.executeQuery();
        List<Package> packageList = new ArrayList<>();
        if (resultSet.next()){
            String id = resultSet.getString(1);
            String trNumber = resultSet.getString(2);
            String companyId = resultSet.getString(3);
            String typeOfGood = resultSet.getString(4);
            double weight = resultSet.getDouble(5);
            String deliveryType = resultSet.getString(6);
            Date date = resultSet.getDate(7);
            String shipmentId = resultSet.getString(8);
            Package pack = new Package(id,trNumber,companyId,typeOfGood,weight,deliveryType,date,shipmentId);
            packageList.add(pack);
        }
        return packageList;
    }
}
