package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.ComboBox;

/**
 *
 * @author Didier
 */
public class DevComboBox extends DevInput {

    ComboBox comboBox;

    public DevComboBox(String name, String title) {
        super(name, title);
        comboBox = new ComboBox();
        config();
    }

    public DevComboBox(String name, String title, ComboBox comboBox) {
        super(name, title);
        this.comboBox = comboBox;
        config();
    }

    @Override
    protected void config() {
        this.setSpacing(5);
        this.comboBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.comboBox);

    }

       @Override
    public InputValue getValue() {
        return new InputValue(this.key,this.comboBox.getValue());
   }
    @Override
    public void addError(String message) {
    }
        @Override
    public void clearError() {
    }

    @Override
    public void clean() {
    }
}
