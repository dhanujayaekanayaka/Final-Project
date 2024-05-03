package lk.ijse.finalProject.model;

public class Vehicle {
    private String id;
    private String name;
    private String vehicle_number;
    private String chassis;
    private String engineNum;
    private String color;
    private String yom;
    private String regDate;
    private String currentDistance;

    public Vehicle(String id, String name, String vehicle_number, String chassis, String engineNum, String color, String yom, String regDate, String currentDistance) {
        this.id = id;
        this.name = name;
        this.vehicle_number = vehicle_number;
        this.chassis = chassis;
        this.engineNum = engineNum;
        this.color = color;
        this.yom = yom;
        this.regDate = regDate;
        this.currentDistance = currentDistance;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public Vehicle() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYom() {
        return yom;
    }

    public void setYom(String yom) {
        this.yom = yom;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getCurrentDistance() {
        return currentDistance;
    }

    public void setCurrentDistance(String currentDistance) {
        this.currentDistance = currentDistance;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", vehicle_number='" + vehicle_number + '\'' +
                ", chassis='" + chassis + '\'' +
                ", engineNum='" + engineNum + '\'' +
                ", color='" + color + '\'' +
                ", yom='" + yom + '\'' +
                ", regDate='" + regDate + '\'' +
                ", currentDistance='" + currentDistance + '\'' +
                '}';
    }

}
