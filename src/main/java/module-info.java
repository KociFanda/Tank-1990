module com.example.tank_1990 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tank_1990 to javafx.fxml;
    exports com.example.tank_1990;
}