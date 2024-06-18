package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.devInputs.core.DevInput;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * @author Didier
 */
public class DevDatePicker extends DevInput<LocalDate> {

    public static final String DEVDATEPICKER = "devDatePicker";

    DatePicker datePicker;

    public DevDatePicker(String name, String title) {
        super(name, title);
        this.datePicker = new DatePicker();
        config();
    }

    public DevDatePicker(String name, String title, LocalDate ld) {
        super(name, title);
        this.datePicker = new DatePicker(ld);
        config();
    }

    @Override
    protected void config() {
        this.setSpacing(5);
        this.datePicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.datePicker.setMaxHeight(Double.MAX_VALUE);
        this.datePicker.setShowWeekNumbers(false);
        this.getStyleClass().add(DEVDATEPICKER);
        this.getChildren().addAll(this.title, this.datePicker, this.error);
    }

    @Override
    public LocalDate getValue() {
        return this.datePicker.getValue();
    }

    @Override
    public void setValue(LocalDate value) {
        this.datePicker.setValue(value);
    }

    @Override
    public void clearError() {
        this.error.setText("");
        this.setErrorStatus(false);
    }

    @Override
    public void clean() {
        this.clearError();
        this.setCorrectStatus(false);
    }
}
