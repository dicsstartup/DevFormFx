package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.devActions.DevActionSquare;
import com.dicsstartup.devformfx.devIcons.DevIcon;
import com.dicsstartup.devformfx.devList.DeleteDevItem;
import com.dicsstartup.devformfx.devList.DevItem;
import java.io.File;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Didier
 */
public class FileItem extends DevItem<File> {

    Label peso;
    DeleteDevItem eliminarCallback;
   
    public FileItem(String s, File value, DeleteDevItem eliminarCallback ){
        super(s,value);
        this.peso = new Label(obtenerTamanoFormateado(value.length()));
        this.add(this.peso, 0, 1);
        GridPane.setHalignment(this.peso, HPos.RIGHT);
        GridPane.setValignment(this.peso, VPos.TOP);
       this.getActions().setAlignment(Pos.CENTER_RIGHT);
       this.eliminarCallback=eliminarCallback;
       DevActionSquare delete = new DevActionSquare("small","primary-color",new DevIcon("delete","text-color","small"));
       delete.setOnAction(event -> {
            this.eliminarCallback.delete(this);
        });
         this.getActions().getChildren().add(delete);

    }

    @Override
    public GridPane getBox() {
        return this;
    }

    public String obtenerTamanoFormateado(long tamanoEnBytes) {
        if (tamanoEnBytes < 1024) {
            return tamanoEnBytes + " bytes";
        } else if (tamanoEnBytes < 1024 * 1024) {
            return String.format("%.2f KB", (double) tamanoEnBytes / 1024);
        } else if (tamanoEnBytes < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", (double) tamanoEnBytes / (1024 * 1024));
        } else {
            return String.format("%.2f GB", (double) tamanoEnBytes / (1024 * 1024 * 1024));
        }
    }

}
