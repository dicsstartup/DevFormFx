package com.dicsstartup.devformfx.devlist;

import com.dicsstartup.devformfx.Actions.DevActionCircle;
import com.dicsstartup.devformfx.Icons.DevIcon;
import com.dicsstartup.devformfx.inputs.DevInput;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Clase abstracta DevListItems que extiende DevInput.
 * Proporciona la estructura para una lista de elementos con funcionalidad de añadir y eliminar ítems.
 *
 * @param <T> Tipo del valor de los ítems.
 * @autor Didier
 */
abstract public class DevListItems<T> extends DevInput {

    public DevActionCircle addButton; // Botón para agregar ítems
    private AnchorPane header; // Cabecera que contiene el título y el botón de agregar
    public VBox vbox; // Contenedor vertical para los ítems
    private ScrollPane scrollPane; // Panel con scroll para la lista de ítems
    public List<DevItem<T>> itemList; // Lista de ítems
    public DeleteDevItem deleteCallback; // Callback para eliminar ítems

    /**
     * Constructor que inicializa la lista de ítems con un nombre y un título.
     *
     * @param name Nombre de la lista de ítems.
     * @param title Título de la lista de ítems.
     */
    public DevListItems(String name, String title) {
        super(name, title);
        config();
    }

    /**
     * Configuración inicial de la lista de ítems.
     */
    @Override
    protected void config() {
        this.addButton = new DevActionCircle("medium", "primary", new DevIcon("add", "secondary", "medium"));
        this.addButton.getStyleClass().add("dev-add-item");
        this.header = new AnchorPane();
        this.vbox = new VBox();
        this.header.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.itemList = new ArrayList<>();
        AnchorPane.setLeftAnchor(this.title, 5.0);
        AnchorPane.setBottomAnchor(this.title, 5.0);
        AnchorPane.setTopAnchor(this.title, 5.0);
        AnchorPane.setRightAnchor(this.addButton, 1.0);
        this.header.getChildren().addAll(this.title, this.addButton);
        this.scrollPane = new ScrollPane();
        this.scrollPane.setContent(vbox);
        this.scrollPane.setFitToWidth(true);
        this.setSpacing(5);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        this.vbox.setSpacing(3);
        this.vbox.setPadding(new javafx.geometry.Insets(5));
        this.getChildren().addAll(this.header, scrollPane);
        this.addButton.setOnAction(event -> {
            addItem();
        });
        this.deleteCallback = (item) -> {
            deleteItem(item);
        };
    }

    /**
     * Método para agregar un ítem al panel.
     *
     * @param item El ítem a agregar.
     */
    public void addItemPanel(DevItem<T> item) {
        this.itemList.add(item);
        this.vbox.getChildren().add(item);
    }

    /**
     * Método abstracto para agregar un ítem.
     * Debe ser implementado por las subclases.
     */
    public abstract void addItem();

    /**
     * Método abstracto para eliminar un ítem.
     * Debe ser implementado por las subclases.
     *
     * @param item El ítem a eliminar.
     */
    public abstract void deleteItem(DevItem<T> item);
}
