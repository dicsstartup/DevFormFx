/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx;


import com.dicsstartup.devformfx.Actions.DevAction;
import com.dicsstartup.devformfx.Actions.DevActionSqueare;
import com.dicsstartup.devformfx.Icons.DevIcon;
import com.dicsstartup.devformfx.inputs.DevInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        this.actions= new ArrayList();
        this.inputs= new ArrayList();
        DevActionSqueare summit= new DevActionSqueare("large","primary",new DevIcon("add","secondary","large"));
        this.actions.add(summit);
    }

    public void Buider(String PageStyle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/devForm.fxml"));
        this.loander(loader);
        controller = loader.getController();
        changePageStyle(PageStyle);
        addActions();
    }

    public void Buider() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/devForm.fxml"));
        try {
            formFx = loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        controller = loader.getController();
        addActions();
    }
    
    public void addActions(){
        this.controller.controls.getChildren().addAll(actions);
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
        this.inputs.add(input);
    }

    public void addInput(DevInput input, int x, int y, int col, int row) {
        VBox.setVgrow(input, Priority.ALWAYS);
        this.grid.add(input, x, y);
         this.inputs.add(input);
    }
    
    public void removeInput(DevInput input){
       this.grid.getChildren().remove(input);
       this.inputs.remove(input);
    }
    
    public Map<String, Object> values(){
        Map<String, Object> resultMap = this.inputs.stream()
                .collect(Collectors.toMap(
                        DevInput::getName,
                        item -> item.getValue()) 
                );
        return resultMap;
    }
    
}
