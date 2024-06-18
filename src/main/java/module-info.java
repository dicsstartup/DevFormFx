module com.dicsstartup.devformfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dicsstartup.devformfx to javafx.fxml;

    exports com.dicsstartup.devformfx;
    exports com.dicsstartup.devformfx.devInputs;
    exports com.dicsstartup.devformfx.devActions;
    exports com.dicsstartup.devformfx.devIcons;
    exports com.dicsstartup.devformfx.devInputs.core;
    exports com.dicsstartup.devformfx.devInputs.componets;
}
