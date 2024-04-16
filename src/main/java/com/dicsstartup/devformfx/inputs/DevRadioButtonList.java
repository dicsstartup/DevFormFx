package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Didier
 */
public class DevRadioButtonList extends DevInput {

    List<RadioButton> listRBottons;
    HBox hbox;
    ToggleGroup group;

    public DevRadioButtonList(String name, String title, String... options) {
        super(name, title, TypeDevInput.RADIO_BUTTON_LIST);
        listRBottons = new ArrayList<>();
        hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        for (String i : options) {
            RadioButton rb = new RadioButton(i);
            listRBottons.add(rb);
            hbox.getChildren().add(rb);
        }
        this.getChildren().addAll(this.title, this.hbox);
    }

    public DevRadioButtonList(String name, String title, Boolean group, String... options) {
        super(name, title, TypeDevInput.RADIO_BUTTON_LIST);
        this.group = new ToggleGroup();
        listRBottons = new ArrayList<>();
        hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        for (String i : options) {
            RadioButton rb = new RadioButton(i);
            if (group) {
                this.group.getToggles().add(rb);
            }
            listRBottons.add(rb);
            hbox.getChildren().add(rb);
        }
        this.getChildren().addAll(this.title, this.hbox);
    }

       @Override
    public Object getValue() {
        return null;
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
