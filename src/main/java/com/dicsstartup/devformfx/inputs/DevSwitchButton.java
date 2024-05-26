package com.dicsstartup.devformfx.inputs;

import com.dicsstartup.devformfx.DevGrid;

/**
 *
 * @author Didier
 */
public class DevSwitchButton extends DevInput {

    private SwitchButton button;
    private DevGrid box;
    private boolean initvalue = false;

    public DevSwitchButton(String name, String title) {
        super(name, title);
        button = new SwitchButton();
        box = new DevGrid();
        config();
    }

    public DevSwitchButton(String name, String title, boolean initvalue) {
        super(name, title);
        button = new SwitchButton();
        box = new DevGrid();
        this.initvalue = initvalue;
        config();
    }

    @Override
    protected void config() {
        this.box.getStyleClass().add("box");
        this.button.getStyleClass().add("devSwitchButton");
        this.button.setChecked(initvalue);
        this.box.setHgap(20);
        this.box.add(this.title, 0, 0);
        this.box.add(this.button, 1, 0);
        this.getChildren().addAll(this.box, this.error);
    }

    @Override
    public InputValue getValue() {
        return new InputValue(this.key, button.IsChecked());
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
        this.button.setChecked(initvalue);
    }

    public SwitchButton getButton() {
        return button;
    }

    public DevGrid getBox() {
        return box;
    }

    public boolean isInitvalue() {
        return initvalue;
    }

}
