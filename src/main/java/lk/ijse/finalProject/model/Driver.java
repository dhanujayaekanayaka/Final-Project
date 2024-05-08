package lk.ijse.finalProject.model;

import lombok.*;
import java.sql.Blob;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
    private String driver_id;
    private String firstName;
    private String lastname;
    private String address;
    private String nic;
    private String dob;
    private String vehicle_id;
    private String contact;
    private String email;
    private Blob pic;

    public Driver(String firstName, String lastName, Blob pic) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.pic = pic;
    }
}


