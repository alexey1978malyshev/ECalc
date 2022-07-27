module com.example.electricalcalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.electricalcalc to javafx.fxml;
    exports com.example.electricalcalc;
}