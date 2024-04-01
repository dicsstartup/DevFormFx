/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx;


import com.dicsstartup.devformfx.Actions.DevAction;
import com.dicsstartup.devformfx.inputs.DevInput;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Didier
 */
public class DevFormBuilder extends GridPane {

    public DevGrid grid;
    List<DevAction> actions;
    List<DevInput> inputs;
    public AnchorPane formFx;
    DevController controller;

    public DevFormBuilder() {
        grid = new DevGrid();
        grid.setMaxWidth(Double.MAX_VALUE);
    }

    public void Buider(String PageStyle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/devForm.fxml"));
        this.loander(loader);
        controller = loader.getController();
        changePageStyle(PageStyle);
    }

    public void Buider() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/devForm.fxml"));
        try {
            formFx = loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        controller = loader.getController();
    }

    public AnchorPane getFXMLLoader() {
        this.controller.grid(grid);
        return formFx;
    }

    private void loander(FXMLLoader loader) {
        try {
            this.formFx = loader.load();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void changePageStyle(String PageStyle) {
        formFx.getStylesheets().clear();
        formFx.getStylesheets().add(PageStyle);
    }

    public List<DevAction> getActions() {
        return actions;
    }

    public void setActions(List<DevAction> actions) {
        this.actions = actions;
    }

    public AnchorPane getFormFx() {
        return formFx;
    }

    public void setFormFx(AnchorPane formFx) {
        this.formFx = formFx;
    }

    public void addInput(DevInput input, int x, int y) {
         VBox.setVgrow(input, Priority.ALWAYS);
        this.grid.add(input, x, y);
    }

    public void addInput(DevInput input, int x, int y, int col, int row) {
        VBox.setVgrow(input, Priority.ALWAYS);
        this.grid.add(input, x, y);
    }
}
