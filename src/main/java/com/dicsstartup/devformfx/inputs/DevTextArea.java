package com.dicsstartup.devformfx.inputs;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;

/**
 * Clase DevTextArea que representa un área de texto con funcionalidad adicional.
 * Extiende la clase abstracta DevInput.
 *
 * Autor: Didier Piracoca
 */
public class DevTextArea extends DevInput {

    // Área de texto para la entrada del usuario
    private TextArea area;

    // Longitud máxima permitida para el texto
    private int max;

    // Etiqueta para mostrar la longitud actual del texto
    private Label maxLabel;

    // Contenedor para la etiqueta de error y la etiqueta de longitud máxima
    private HBox footer;

    /**
     * Constructor que inicializa el área de texto con un nombre y un título.
     *
     * @param name Clave identificadora del área de texto.
     * @param title Título del área de texto.
     */
    public DevTextArea(String name, String title) {
        super(name, title);
        this.area = new TextArea();
        this.maxLabel = new Label();
        config();
    }

    /**
     * Constructor que inicializa el área de texto con un nombre, un título y una longitud máxima.
     *
     * @param name Clave identificadora del área de texto.
     * @param title Título del área de texto.
     * @param maxlength Longitud máxima permitida para el texto.
     */
    public DevTextArea(String name, String title, int maxlength) {
        super(name, title);
        this.area = new TextArea();
        this.maxLabel = new Label();
        config();
        addMaxLength(maxlength);
    }

    /**
     * Configuración inicial del DevTextArea.
     * Configura estilos, alineaciones, vínculos de propiedades y añade elementos al contenedor.
     */
    @Override
    protected void config() {
        // Añadir estilo a la etiqueta de longitud máxima
        this.maxLabel.getStyleClass().add(enumCSS.MAXLABEL);

        // Crear y configurar el contenedor footer
        this.footer = new HBox();
        this.footer.prefWidthProperty().bind(this.widthProperty());
        this.error.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.footer.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(this.error, Priority.ALWAYS);
        this.error.setTextAlignment(TextAlignment.LEFT);

        // Añadir la etiqueta de error y la etiqueta de longitud máxima al footer
        this.footer.getChildren().addAll(this.error, this.maxLabel);

        // Configurar el espaciado entre elementos y añadirlos al contenedor principal
        this.setSpacing(5);
        this.getChildren().addAll(this.title, this.area, this.footer);

        // Añadir estilo al área de texto
        this.area.getStyleClass().add(enumCSS.DEVTEXTAREA);
    }

    /**
     * Añade un límite máximo de longitud al texto y configura un listener para controlar la longitud.
     *
     * @param max Longitud máxima permitida para el texto.
     */
    public void addMaxLength(int max) {
        this.max = max;

        // Añadir un listener para controlar la longitud del texto
        this.area.textProperty().addListener((observable, oldValue, newValue) -> {
            setMaxLength(newValue);

            // Si el nuevo valor excede la longitud máxima, restaurar el valor anterior
            if (newValue.length() > max) {
                this.area.setText(oldValue);
            }
        });
    }

    /**
     * Actualiza la etiqueta de longitud máxima con el tamaño actual del texto.
     *
     * @param texto Texto actual del área de texto.
     */
    private void setMaxLength(String texto) {
        this.maxLabel.setText(texto.length() + "/" + this.max);
    }

    /**
     * Obtiene el valor actual del área de texto.
     *
     * @return Un objeto InputValue con la clave y el texto del área.
     */
    @Override
    public InputValue getValue() {
        return new InputValue(this.key, this.area.getText());
    }

    /**
     * Añade un mensaje de error al área de texto.
     *
     * @param message El mensaje de error a mostrar.
     */
    @Override
    public void addError(String message) {
        error.setText(message);
        enumCSS.addStyleClass(this.area, enumCSS.ERROR);
    }

    /**
     * Limpia el mensaje de error del área de texto.
     */
    @Override
    public void clearError() {
        error.setText("");
        this.area.getStyleClass().remove(enumCSS.ERROR);
    }

    /**
     * Limpia el área de texto y los estilos de error.
     */
    @Override
    public void clean() {
        this.clearError();
        this.area.setText("");
        enumCSS.removeStyleClass(this.area, enumCSS.ERROR);
    }

    /**
     * Obtiene la longitud máxima permitida para el texto.
     *
     * @return La longitud máxima permitida.
     */
    public int getMax() {
        return max;
    }

    /**
     * Establece la longitud máxima permitida para el texto.
     *
     * @param max La nueva longitud máxima permitida.
     */
    public void setMax(int max) {
        this.max = max;
    }

}