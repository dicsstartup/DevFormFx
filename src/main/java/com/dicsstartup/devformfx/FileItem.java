package com.dicsstartup.devformfx;



import com.dicsstartup.devformfx.Actions.DevActionSqueare;
import com.dicsstartup.devformfx.Icons.DevIcon;
import com.dicsstartup.devformfx.devlist.DeleteDevItem;
import com.dicsstartup.devformfx.devlist.DevItem;
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
       this.actions.setAlignment(Pos.CENTER_RIGHT);
       this.eliminarCallback=eliminarCallback;
       DevActionSqueare delete = new DevActionSqueare("small","primary",new DevIcon("delete","secondary","small"));
       delete.setOnAction(event -> {
            this.eliminarCallback.delete(this);
        });
         this.actions.getChildren().add(delete);

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
