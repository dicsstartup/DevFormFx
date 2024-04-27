/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Didier
 */
public class DevTextField extends DevInput {

    private TextField textField;
    private List<Validation> patterns;
    private boolean isStyleCorrect;

    public DevTextField(String name, String title) {
        super(name, title, TypeDevInput.TEXT_FIELD);
        this.textField = new TextField();
        this.patterns = new ArrayList<>();
        config();
    }

    private void config() {
        this.setSpacing(5);
        textField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.textField, this.error);
        this.textField.getStyleClass().add(enumCSS.DEVTEXTFIELD);
    }

    @Override
    public Object getValue() {
        return textField.getText();
    }

    @Override
    public void addError(String message) {
        error.setText(message);
       enumCSS.addStyleClass(this.textField,enumCSS.ERROR);
        enumCSS.removeStyleClass(this.textField,enumCSS.CORRECT);
    }
    
    @Override
    public void clean() {
        clearError();
        textField.setText("");
          enumCSS.removeStyleClass(this.textField,enumCSS.ERROR);
    }

    @Override
    public void clearError() {
        error.setText("");
        textField.getStyleClass().remove(enumCSS.ERROR);
    }

    public void addPattern(Validation pattern) {
        patterns.add(pattern);
    }

    public void clearPatterns() {
        patterns.clear();
    }

    public boolean isValid() {
        if (patterns.isEmpty()) {
            return true;
        }
        for (Validation validation : patterns) {
            if (!this.textField.getText().matches(validation.pattern)) {
                this.addError(validation.massage);
                return false;
            }
        }
        return true;
    }

    public void validate() {
        if (isValid()) {
            if (isStyleCorrect) {
                enumCSS.addStyleClass(this.textField,enumCSS.CORRECT);
            }
            clearError();
        }
    }

    public void validationActive(boolean applyStyle) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> validate());
    }


    public List<Validation> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Validation> patterns) {
        this.patterns = patterns;
    }

    public boolean isIsStyleCorrect() {
        return isStyleCorrect;
    }

    public void setIsStyleCorrect(boolean isStyleCorrect) {
        this.isStyleCorrect = isStyleCorrect;
    }

    public void addPattern(boolean IsActive, Validation validation) {
        this.addPattern(validation);
        validationActive(true);
    }

    public void extend(){
        VBox.setVgrow(this.textField, Priority.ALWAYS);
        
    }
}
