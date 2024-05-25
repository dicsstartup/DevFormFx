/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import com.dicsstartup.devformfx.Icons.DevIcon;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PasswordField;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


/**
 *
 * @author Didier
 */
class VisiblePasswordFieldSkin extends TextFieldSkin {

private final Button actionButton = new Button("View");
private final DevIcon actionIcon= new DevIcon(enumCSS.VISIBILITY ,"secundary","ic_password");

private boolean mask = true;

public VisiblePasswordFieldSkin(PasswordField textField) {

    super(textField);
    actionButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    actionButton.setPrefSize(40,20);
    actionButton.setFocusTraversable(false);
    actionButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(0))));
    getChildren().add(actionButton);
    actionButton.setCursor(Cursor.HAND);
    actionButton.toFront();
    actionButton.setGraphic(actionIcon);
    System.out.println(actionIcon.getStyle());
    actionButton.setVisible(true);
    actionButton.setOnMouseClicked(event -> {
        if(mask) {
            actionIcon.setIcon(enumCSS.VISIBILITY_OFF);
            actionIcon.setSize(enumCSS.SIZE_PASSWORD_OFF);
            mask = false;
        } else {
           actionIcon.setIcon(enumCSS.VISIBILITY);
           actionIcon.setSize(enumCSS.SIZE_PASSWORD);
            mask = true;
        }
        textField.setText(textField.getText());
        textField.end();
    });

    textField.textProperty().addListener((observable, oldValue, newValue) -> actionButton.setVisible(!newValue.isEmpty()));

}

@Override
protected void layoutChildren(double x, double y, double w, double h) {
    super.layoutChildren(x, y, w, h);

    layoutInArea(actionButton, x, y, w, h,0, HPos.RIGHT, VPos.CENTER);
}

@Override
protected String maskText(String txt) {
    if (getSkinnable() instanceof PasswordField && mask) {
        int n = txt.length();
        StringBuilder passwordBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            passwordBuilder.append("*");
        }
        return passwordBuilder.toString();
    } else {

        return txt;
    }
}

    public Button getActionButton() {
        return actionButton;
    }

    public DevIcon getActionIcon() {
        return actionIcon;
    }

    public boolean isMask() {
        return mask;
    }

}
