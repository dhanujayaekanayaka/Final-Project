package lk.ijse.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shipment {
    private String shipment_id;
    private double cost;
    private String routId;
}
