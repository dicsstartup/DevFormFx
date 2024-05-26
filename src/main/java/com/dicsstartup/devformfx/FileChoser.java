package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.devlist.DevItem;
import com.dicsstartup.devformfx.devlist.DevListItems;
import java.io.File;

import com.dicsstartup.devformfx.inputs.InputValue;
import javafx.stage.FileChooser;

/**
 *
 * @author Didier
 *
 */
public class FileChoser extends DevListItems<File> {

    public FileChoser(String name,String title) {
        super(name,title);
      
    }

    @Override
    public void addItem() {
        FileChooser fileChooser = new FileChooser();

        // Mostrar el FileChooser
        File archivoSeleccionado = fileChooser.showOpenDialog(null);

        // Si se seleccionó un archivo, mostrar su nombre
        if (archivoSeleccionado != null) {
            this.addItemPanel(new FileItem(archivoSeleccionado.getName(), archivoSeleccionado, this.deleteCallback));
        }

    }

    @Override
    public void deleteItem(DevItem<File> object) {
        this.vbox.getChildren().remove(object);
    }
       @Override
    public InputValue getValue() {
        return null;
   }

    @Override
    public void addError(String message) {
        
    }
        @Override
    public void clearError() {
    }

    @Override
    public void clean() {
    }

}
