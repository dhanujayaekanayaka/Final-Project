package lk.ijse.finalProject.model;

public class Driver {
   private String driver_id;
   private String name;
   private String dob;
   private String vehicle_id;
   private String contact;
   private String email;

    public Driver() {
    }

    public Driver(String driver_id, String name, String dob, String vehicle_id, String contact, String email) {
        this.driver_id = driver_id;
        this.name = name;
        this.dob = dob;
        this.vehicle_id = vehicle_id;
        this.contact = contact;
        this.email = email;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driver_id='" + driver_id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", vehicle_id='" + vehicle_id + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
