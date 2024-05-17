package lk.ijse.finalProject.model.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ServiceTm {
        private String id;
        private String serviceScheduleId;
        private String serviceType;
        private String description;
        private Date date;
        private String serviceCenterId;
}
