package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.devList.DevItem;
import com.dicsstartup.devformfx.devList.DevListItems;
import java.io.File;

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
    public File getValue() {
        return null;
   }

    @Override
    public void setValue(File value) {

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
