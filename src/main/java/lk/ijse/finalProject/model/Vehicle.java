package lk.ijse.finalProject.model;

import java.sql.Date;

public class Vehicle {
    private String id;
    private String name;
    private String vehicle_number;
    private String chassis;
    private String engineNum;
    private String color;
    private String yom;
    private Date regDate;
    private String currentDistance;
    private String profile_picture;

    public Vehicle(String vehiId,String model, String vehicleNumber, String chassis, String engineNumber, String color, String yom, Date date, String distance) {
        this.id=vehiId;
        this.name=model;
        this.vehicle_number=vehicleNumber;
        this.chassis=chassis;
        this.engineNum=engineNumber;
        this.color=color;
        this.yom=yom;
        this.regDate=date;
        this.currentDistance=distance;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }


    public Vehicle(String id, String name, String vehicle_number, String chassis, String engineNum, String color, String yom, Date regDate, String currentDistance, String profile_picture) {
        this.id = id;
        this.name = name;
        this.vehicle_number = vehicle_number;
        this.chassis = chassis;
        this.engineNum = engineNum;
        this.color = color;
        this.yom = yom;
        this.regDate = regDate;
        this.currentDistance = currentDistance;
        this.profile_picture = profile_picture;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
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
                ", profile_picture=" + profile_picture +
                '}';
    }

}
