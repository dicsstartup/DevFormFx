package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 *
 * @author Didier
 */
public class DevColorPicker extends DevInput {

    ColorPicker colorPicker;

    public DevColorPicker(String name, String title) {
        super(name, title);
        this.colorPicker = new ColorPicker();
        config();
    }

    public DevColorPicker(String name, String title, Color color) {
        super(name, title);
        this.colorPicker = new ColorPicker(color);
        config();
    }
    @Override
    protected void config() {
        this.setSpacing(5);
        this.colorPicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.colorPicker);
    }
    
       @Override
    public InputValue getValue() {
        return new InputValue(key, this.colorPicker.getValue());
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
