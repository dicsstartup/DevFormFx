/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Didier
 */
public class DevPasswordField extends DevInput {

    private PasswordField passwordField;
    private List<Validation> patterns;
    private VisiblePasswordFieldSkin visibility;
    private boolean isStyleCorrect;

    public DevPasswordField(String name, String title) {
        super(name, title, TypeDevInput.PASSWORD_FIELD);
        this.passwordField = new PasswordField();
        this.patterns = new ArrayList<>();
        this.visibility=new VisiblePasswordFieldSkin(passwordField);
        config();
    }

    private void config() {
        this.setSpacing(5);
        passwordField.setSkin(this.visibility);
        passwordField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.passwordField, this.error);
        this.passwordField.getStyleClass().add(enumCSS.DEVTEXTFIELD);
    }

    @Override
    public Object getValue() {
        return passwordField.getText();
    }

    @Override
    public void addError(String message) {
        error.setText(message);
       enumCSS.addStyleClass(this.passwordField,enumCSS.ERROR);
       enumCSS.removeStyleClass(this.passwordField,enumCSS.CORRECT);
    }
    
    @Override
    public void clean() {
        clearError();
        passwordField.setText("");
        enumCSS.removeStyleClass(this.passwordField,enumCSS.ERROR);
    }

    @Override
    public void clearError() {
        error.setText("");
        passwordField.getStyleClass().remove(enumCSS.ERROR);
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
            if (!this.passwordField.getText().matches(validation.pattern)) {
                this.addError(validation.massage);
                return false;
            }
        }
        return true;
    }

    public void validate() {
        if (isValid()) {
            if (isStyleCorrect) {
                enumCSS.addStyleClass(this.passwordField,enumCSS.CORRECT);
            }
            clearError();
        }
    }

    public void validationActive(boolean applyStyle) {
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> validate());
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
        VBox.setVgrow(this.passwordField, Priority.ALWAYS);
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public VisiblePasswordFieldSkin getVisibility() {
        return visibility;
    }

    public void setVisibility(VisiblePasswordFieldSkin visibility) {
        this.visibility = visibility;
    }
    
    
}
