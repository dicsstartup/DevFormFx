package com.dicsstartup.devformfx;

public class PalleteColors {
    String primary;
    String background;
    String secondary;
    String text;
    String correct;
    String warn;

    public PalleteColors(String primary, String background, String secondary, String text, String correct, String warn) {
        this.primary = primary;
        this.background = background;
        this.secondary = secondary;
        this.text = text;
        this.correct = correct;
        this.warn = warn;
    }

    public String getPrimary() {
        return primary;
    }

    public String getBackground() {
        return background;
    }

    public String getSecondary() {
        return secondary;
    }

    public String getText() {
        return text;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }
}
