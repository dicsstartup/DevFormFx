package com.dicsstartup.devformfx.devInputs.componets;

import com.dicsstartup.devformfx.devIcons.DevIcon;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PasswordField;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * Clase VisiblePasswordFieldSkin que extiende TextFieldSkin para personalizar el comportamiento de un PasswordField.
 * Proporciona un botón para mostrar/ocultar la contraseña.
 *
 *
 * Autor: Didier Piracoca
 */
public class VisiblePasswordFieldSkin extends TextFieldSkin {

    private static final String ICON_EYE = "visibility";
    private static final String ICON_CLOSE_EYE = "visibility_off";
    private static final String SIZE_CLOSE_EYE = "ic_password_off";
    private static final String SIZE_EYE = "ic_password";

    // Botón de acción para mostrar/ocultar la contraseña
    private final Button actionButton = new Button("View");

    // Icono del botón de acción
    private final DevIcon actionIcon = new DevIcon(ICON_EYE, "secondary", SIZE_EYE);

    // Bandera para indicar si la contraseña está enmascarada
    private boolean mask = true;

    /**
     * Constructor que configura el TextField y el botón de acción.
     *
     * @param textField El PasswordField asociado a este skin.
     */
    public VisiblePasswordFieldSkin(PasswordField textField) {
        super(textField);
        // Configuración del botón de acción
        actionButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        actionButton.setPrefSize(40, 20);
        actionButton.setFocusTraversable(false);
        actionButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(0))));
        getChildren().add(actionButton);
        actionButton.setCursor(Cursor.HAND);
        actionButton.toFront();
        actionButton.setGraphic(actionIcon);
        actionButton.setVisible(true);

        // Evento para cambiar la visibilidad de la contraseña
        actionButton.setOnMouseClicked(event -> {
            if (mask) {
                actionIcon.setIcon(ICON_CLOSE_EYE);
                actionIcon.setSize(SIZE_CLOSE_EYE);
                mask = false;
            } else {
                actionIcon.setIcon(ICON_EYE);
                actionIcon.setSize(SIZE_EYE);
                mask = true;
            }
            textField.setText(textField.getText());
            textField.end();
        });

        // Listener para mostrar/ocultar el botón dependiendo si hay texto
        textField.textProperty().addListener((observable, oldValue, newValue) -> actionButton.setVisible(!newValue.isEmpty()));
    }

    /**
     * Layout para posicionar el botón de acción pegado a la derecha.
     *
     * @param x Coordenada X del área de layout.
     * @param y Coordenada Y del área de layout.
     * @param w Ancho del área de layout.
     * @param h Alto del área de layout.
     */
    @Override
    protected void layoutChildren(double x, double y, double w, double h) {
        super.layoutChildren(x, y, w, h);
        // Posiciona el botón de acción pegado a la derecha
        layoutInArea(actionButton, x + w - actionButton.getPrefWidth(), y, actionButton.getPrefWidth(), h, 0, HPos.RIGHT, VPos.CENTER);
    }

    /**
     * Método para enmascarar el texto de la contraseña.
     *
     * @param txt El texto de la contraseña.
     * @return El texto enmascarado si la bandera mask es true, de lo contrario el texto original.
     */
    @Override
    protected String maskText(String txt) {
        if (getSkinnable() instanceof PasswordField && mask) {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                passwordBuilder.append("*");
            }
            return passwordBuilder.toString();
        } else {
            return txt;
        }
    }

    // Getters para el botón de acción, el icono de acción y la bandera de enmascaramiento
    public Button getActionButton() {
        return actionButton;
    }

    public DevIcon getActionIcon() {
        return actionIcon;
    }

    public boolean isMask() {
        return mask;
    }
}
