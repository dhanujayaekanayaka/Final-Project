package lk.ijse.finalProject.controller;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class DashboardFormController {

    public AnchorPane rootNode;
    public Label lblDatePicker;

    public void initialize(){
        setDate();
    }
    public void setDate(){
        LocalDate now = LocalDate.now();
        lblDatePicker.setText(String.valueOf(now));
    }
}
