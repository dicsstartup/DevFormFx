package com.dicsstartup.devformfx.inputs;

import javafx.scene.Node;

/**
 *
 * @author Didier
 */
public class enumCSS {

    // Inputs
    public static final String DEV_INPUT = "devInput";
    public static final String ERROR_LABEL = "error_label";
    public static final String TITLE_LABEL = "title_label";

    // DevTextArea
    public static final String DEVTEXTAREA = "devTextArea";
    public static final String MAXLABEL = "maxlabel";

    public static final String DEVTEXTFIELD = "devTextField";
    
    //DevPassWordField
    public static final String DEVPASSWORDFIELD = "devPassWordField";
    public static final String VISIBILITY = "visibility";
    public static final String VISIBILITY_OFF = "visibility_off";
    public static final String SIZE_PASSWORD_OFF = "ic_password_off";
    public static final String SIZE_PASSWORD = "ic_password";
    
    //DevCheckBox
    public static final String DEVCHECKBOX = "devCheckBox";

    //DevCheckBox
    public static final String DEVSWITCHBUTTON = "devSwitchButton";

    //status
    public static final String ERROR = "error";
    public static final String CORRECT = "correct";
    public static final String CHECKED = "checked";


   
    public static void removeStyleClass(Node i, String c) {
            i.getStyleClass().remove(c);
    }

    public static void addStyleClass(Node i, String c) {
        if (!i.getStyleClass().contains(c)) i.getStyleClass().add(c);
    }
}
