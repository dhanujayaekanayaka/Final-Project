package lk.ijse.finalProject.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static boolean setTextFieldColor(TextField location, javafx.scene.control.TextField textField) {
        if (Regex.isTextFieldValid(location,textField.getText())){
            textField.setStyle("-fx-text-color: green");
            return true;
        } else {
            textField.setStyle("-fx-text-color: Red");
            return false;
        }
    }

    private static boolean isTextFieldValid(TextField location, String text) {
        String field = "";
        switch (location) {
            case ID:
                field = "^([A-Z][0-9]{3})$\"";
                break;
            case NAME:
                field = "^[A-z|\\\\s]{3,}$";
                break;
            case PASSWORD:
                field = "[A-z][0-9]{8,}$";
                break;
            case WORD:
                field = "";
                break;
            case DATE:
                field = "";
                break;
            case PRICE:
                field = "";
                break;
            case WEIGHT:
                field = "";
                break;
            case DISTANCE:
                field = "";
        }
        Pattern pattern = Pattern.compile(field);
        if (text != null){
            if (text.trim().isEmpty()){
                return false;
            }
        }else {
            return false;
        }

        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()){
            return true;
        }
        return false;
    }
}
