package lk.ijse.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Route {
    private String id;
    private String location;
    private String destination;
    private String description;
    private double distance;
}
