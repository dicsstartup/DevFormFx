/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.Node;

/**
 *
 * @author Didier
 */
public class ClassCSS {

    // Inputs
    public static final String DEV_INPUT = "devInput";

    // DevTextArea
    public static final String DEVTEXTAREA = "devTextArea";
    public static final String MAXLABEL = "maxlabel";

    public static final String DEVTEXTFIELD = "devTextField";
    //status
    public static final String ERROR = "error";
    public static final String CORRECT = "correct";

    public static void removeStyleClass(Node i, String c) {
        if (i.getStyleClass().contains(c)) {
            i.getStyleClass().remove(c);
        }
    }

    public static void addStyleClass(Node i, String c) {
        if (!i.getStyleClass().contains(c)) {
            i.getStyleClass().add(c);
        }
    }
}
