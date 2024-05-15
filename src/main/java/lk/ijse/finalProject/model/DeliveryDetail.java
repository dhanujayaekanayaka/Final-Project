package lk.ijse.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class DeliveryDetail {
    private String shipmentId;
    private String vehicleId;
    private String destination;
}
