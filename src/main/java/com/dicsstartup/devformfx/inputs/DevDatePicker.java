/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        super(name, title, TypeDevInput.DATE_PICKER);
        date = new DatePicker();
        configInitial();
    }

    public DevDatePicker(String name, String title, LocalDate ld) {
        super(name, title, TypeDevInput.DATE_PICKER);
        date = new DatePicker(ld);
        configInitial();
    }

    private void configInitial() {
        date.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        date.setMaxHeight(Double.MAX_VALUE);
        this.setSpacing(5);
        this.getChildren().addAll(this.title, this.date);
    }

       @Override
    public Object getValue() {
        return this.date.getChronology();
   }
    @Override
    public void addError(String message) {
    }
}
