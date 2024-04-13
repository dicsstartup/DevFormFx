/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.devlist.DevItem;
import com.dicsstartup.devformfx.devlist.DevListItems;
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
    public Object getValue() {
        return null;
   }

}
