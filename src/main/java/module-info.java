module com.example.autodoc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.autodoc.app to javafx.fxml;
    opens com.example.autodoc.controller to javafx.fxml;

    exports com.example.autodoc.app;
}
