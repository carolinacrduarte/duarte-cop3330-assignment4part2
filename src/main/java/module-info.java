module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens ucf.assignments to javafx.fxml;
    exports ucf.assignments;
}