package lk.ijse.finalProject.repository;

import lk.ijse.finalProject.DB.Dbconnection;
import lk.ijse.finalProject.model.PackageSave;

import java.sql.Connection;
import java.sql.SQLException;

public class PackageSaveRepo {
    public static void placeClientOrder(PackageSave packageSave) throws SQLException {
        Connection connection = Dbconnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isSave = ShipmentRepo.saveShipment(packageSave.getShipment());
        if (isSave){
            boolean isSaved = PackageRepo.savePackage(packageSave.getAPackage());
            if (isSaved){
                boolean isOk = DeliveryDetailRepo.saveDetails(packageSave.getDeliveryDetail());
                if (isOk){
                    boolean isUpdated = VehicleRepo.updateCurrentDistance(Double.parseDouble(packageSave.getRoute().getDestination()), packageSave.getDeliveryDetail().getVehicleId());
                }
            }
        }
    }
}
