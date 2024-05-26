package com.dicsstartup.devformfx.inputs;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;

/**
 *
 * @author Didier
 */
public class DevDatePicker extends DevInput {

    DatePicker date = new DatePicker();

    public DevDatePicker(String name, String title) {
        super(name, title);
        date = new DatePicker();
        config();
    }

    public DevDatePicker(String name, String title, LocalDate ld) {
        super(name, title);
        date = new DatePicker(ld);
        config();
    }

    @Override
    protected void config() {
        date.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        date.setMaxHeight(Double.MAX_VALUE);
        this.setSpacing(5);
        this.getChildren().addAll(this.title, this.date);
    }

       @Override
    public InputValue getValue() {
        return new InputValue(this.key, this.date.getChronology());
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
