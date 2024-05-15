package lk.ijse.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PackageSave {
    private Package aPackage;
    private Shipment shipment;
    private DeliveryDetail deliveryDetail;
    private Route route;
}
