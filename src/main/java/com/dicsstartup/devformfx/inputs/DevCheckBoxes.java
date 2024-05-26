/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author Didier
 */
public class DevCheckBoxes extends DevInput {

    private List<Options> options;
    private HBox hbox;
    private boolean onlyOneOpction = false;

    public DevCheckBoxes(String name, String title, Options... options) {
        this.options = Arrays.stream(options).collect(Collectors.toCollection(ArrayList::new));
        hbox = new HBox();
        config();

    }

    public DevCheckBoxes(String name, String title, boolean OnlyOneOpction, Options... options) {
        super(name, title, TypeDevInput.CHECK_BOXES);
        this.onlyOneOpction = OnlyOneOpction;
        this.options = Arrays.stream(options).collect(Collectors.toCollection(ArrayList::new));
        hbox = new HBox();
        config();
    }

    private void config() {
        this.hbox.setSpacing(10);
        this.hbox.setAlignment(Pos.CENTER);
        this.hbox.getStyleClass().add("box");
        this.setSpacing(15);
        for (Options i : options) {
            this.changeonlyOneOpction(i);
            i.getStyleClass().add(enumCSS.DEVCHECKBOX);
            hbox.getChildren().add(i);
        }
        this.getChildren().addAll(this.title, this.hbox, this.error);
    }

    private void changeonlyOneOpction(CheckBox check) {
        if (this.onlyOneOpction) {
            check.setOnAction(event -> setOnlyOneTrue(check));
        } else {
            check.setOnAction(null);
        }
    }

    private void setOnlyOneTrue(CheckBox selectedCheckbox) {
        this.options.forEach(checkbox -> {
            if (checkbox != selectedCheckbox) {
                checkbox.setSelected(false);
            } else {
                checkbox.setSelected(true);
            }
        });
    }

    @Override
    public Object getValue() {
        if (this.onlyOneOpction) {
            for (Options o : this.options) {
                if (o.isSelected()) {
                    return o.getText();
                }
            }
            return null;
        } else {
            Map<String, Boolean> results = new HashMap<>();
            for (Options o : this.options) {
                results.put(o.name, o.isSelected());
            }
            return results;
        }

    }

    @Override
    public void addError(String message) {
        this.error.setText(message);
        enumCSS.addStyleClass(this, enumCSS.ERROR);
        enumCSS.removeStyleClass(this, enumCSS.CORRECT);
    }

    @Override
    public void clearError() {
        this.error.setText("");
        enumCSS.addStyleClass(this, enumCSS.CORRECT);
        enumCSS.removeStyleClass(this, enumCSS.ERROR);
    }

    @Override
    public void clean() {
        clearError();
        options.forEach(Options::restart);
    }

    public List<Options> getOptions() {
        return options;
    }

    public HBox getHbox() {
        return hbox;
    }

    public boolean isOnlyOneOpction() {
        return onlyOneOpction;
    }

    public void setOnlyOneOpction(boolean onlyOneOpction) {
        this.onlyOneOpction = onlyOneOpction;
    }

}
