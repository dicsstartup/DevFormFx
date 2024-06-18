package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.devInputs.core.DevInput;
import javafx.geometry.Orientation;
import javafx.scene.control.Slider;

/**
 * @author Didier Piracoca
 */
public class DevSlider extends DevInput<Double> {

    Slider slider;

    public DevSlider(String name, String title) {
        super(name, title);
        slider = new Slider();
        config();
    }

    public DevSlider(String name, String title, double min, double max, double value) {
        super(name, title);
        slider = new Slider(min, max, value);
        config();
    }

    @Override
    protected void config() {
        this.setSpacing(5);
        this.slider.prefWidthProperty().bind(this.widthProperty());
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(10);
        slider.setOrientation(Orientation.HORIZONTAL);
        this.getChildren().addAll(this.title, this.slider);
    }

    public Slider getSlider() {
        return slider;
    }

    @Override
    public Double getValue() {
        return this.slider.getValue();
    }

    @Override
    public void setValue(Double value) {
        this.getSlider().setValue(value);
    }

    /**
     * Elimina el mensaje de error y el estilo de error.
     */
    @Override
    public void clearError() {
        this.error.setText("");
        this.setErrorStatus(false);
    }

    /**
     * Limpia el Slider, cambiando a el menor dato y mensaje de error.
     */
    @Override
    public void clean() {
        clearError();
        this.slider.setValue(this.slider.getMin());
        this.setCorrectStatus(false);
    }

}
