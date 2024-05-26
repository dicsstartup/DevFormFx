package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.CheckBox;

/**
 *
 * @author Didier
 */
public class Options extends CheckBox {

    String name;
    String label;
    boolean initValue= false;     

    public Options(String name, String label, boolean initValue) {
        super(label);
        this.name = name;
        this.label = label;
        this.initValue = initValue;
        this.setSelected(initValue);
    }
       public Options(String name, String label) {
        super(label);
        this.name = name;
        this.label = label;
        this.setSelected(initValue);
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isInitValue() {
        return initValue;
    }   
    public void restart(){
         this.setSelected(initValue);
    }
}
