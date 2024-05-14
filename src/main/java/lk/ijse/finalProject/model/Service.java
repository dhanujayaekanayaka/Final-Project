package lk.ijse.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private String id;
    private String serviceScheduleId;
    private String serviceType;
    private String description;
    private Date date;
    private String serviceCenterId;
}
