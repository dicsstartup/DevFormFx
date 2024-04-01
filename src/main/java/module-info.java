module com.dicsstartup.devformfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dicsstartup.devformfx to javafx.fxml;
    exports com.dicsstartup.devformfx;
}
