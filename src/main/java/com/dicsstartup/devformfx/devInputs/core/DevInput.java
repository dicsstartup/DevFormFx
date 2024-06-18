package com.dicsstartup.devformfx.devInputs.core;

import com.dicsstartup.devformfx.DevException;
import javafx.css.PseudoClass;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta DevInput que representa un componente de entrada de datos en la UI.
 * Esta clase extiende VBox e incluye elementos para una clave, un título y un mensaje de error.
 *
 * Autor: Didier Piracoca
 */
public abstract class DevInput<T> extends VBox {

    // Constantes para los nombres de las clases de estilo CSS
    private static final String DEV_INPUT = "devInput";
    private static final String ERROR_LABEL = "error_label";
    private static final String TITLE_LABEL = "title_label";

    // Clave identificadora del input
    protected String key;

    // Etiqueta para el título del input
    protected final Label title;

    // Etiqueta para mostrar mensajes de error
    protected final Label error;

    // Lista de validadores para el input
    protected List<Validator<T>> validators = new ArrayList<>();;

    // Lista de mensajes de error correspondientes a los validadores
    protected List<String> errorMessages = new ArrayList<>();;

    // Pseudo-clases para los estados correctos y de error
    private static final PseudoClass PSEUDO_CLASS_CORRECT = PseudoClass.getPseudoClass("correct");
    private static final PseudoClass PSEUDO_CLASS_ERROR = PseudoClass.getPseudoClass("error");

    /**
     * Constructor de la clase DevInput.
     * Inicializa el input con una clave y un título, y configura las clases de estilo.
     *
     * @param key Clave identificadora del input.
     * @param title Título del input.
     */
    public DevInput(String key, String title) {
        super();
        this.key = key;
        this.title = new Label(title);
        this.error = new Label();
        addClassStyle(); // Añade las clases de estilo CSS
    }

    /**
     * Método para añadir las clases de estilo CSS a los elementos del input.
     */
    public void addClassStyle() {
        this.getStyleClass().add(DEV_INPUT);
        this.error.getStyleClass().add(ERROR_LABEL);
        this.title.getStyleClass().add(TITLE_LABEL);
    }

    /**
     * Método para añadir un validador al input.
     *
     * @param validator El validador.
     * @param errorMessage El mensaje de error asociado al validador.
     */
    public void addValidator(Validator<T> validator, String errorMessage) {
        validators.add(validator);
        errorMessages.add(errorMessage);
    }

    /**
     * Método para validar el input.
     *
     * @return true si la validación es exitosa, false en caso contrario.
     */
    public boolean validate() {
        T value = getValue();
        if (this.isErrorStatus()) {
            return false;
        }
        for (int i = 0; i < validators.size(); i++) {
            if (!validators.get(i).validate(value)) {
                addError(errorMessages.get(i));
                return false;
            }
        }
        clearError();
        this.setCorrectStatus(true);
        return true;
    }

    /**
     * Método para añadir un mensaje de error al input.
     * Debe ser implementado por las subclases.
     *
     * @param message El mensaje de error.
     */
    public void addError(String message) {
        this.error.setText(message);
        this.setErrorStatus(true);
    }

    /**
     * Configura el componente de entrada.
     * Este método debe ser utilizado para añadir cualquier configuración específica del componente.
     */
    protected abstract void config();

    /**
     * Obtiene el valor actual del input.
     * Debe ser implementado para devolver el valor específico del tipo T.
     *
     * @return El valor del input.
     */
    public abstract T getValue();

    /**
     * Establece el valor del input.
     * Debe ser implementado para establecer el valor específico del tipo T.
     *
     * @param value El valor a establecer.
     */
    public abstract void setValue(T value);

    /**
     * Limpia el mensaje de error del input.
     * Este método debe ser utilizado para restablecer el estado visual del error.
     */
    public abstract void clearError();

    /**
     * Limpia el contenido del input.
     * Este método debe ser utilizado para restablecer el estado inicial del input.
     */
    public abstract void clean();


    /**
     * Método para obtener el título del input.
     *
     * @return La etiqueta del título.
     */
    public Label getTitle() {
        return title;
    }

    /**
     * Método para obtener el mensaje de error del input.
     *
     * @return La etiqueta del error.
     */
    public Label getError() {
        return error;
    }

    /**
     * Método para obtener la clave del input.
     *
     * @return La clave del input.
     */
    public String getKey() {
        return key;
    }

    /**
     * Método para establecer el estado correcto del input.
     *
     * @param correct true para establecer el estado correcto, false en caso contrario.
     */
    public void setCorrectStatus(boolean correct) {
        if (correct && isErrorStatus()) {
            setErrorStatus(false);
        }
        pseudoClassStateChanged(PSEUDO_CLASS_CORRECT, correct);
    }

    /**
     * Método para establecer el estado de error del input.
     *
     * @param error true para establecer el estado de error, false en caso contrario.
     */
    public void setErrorStatus(boolean error) {
        if (error && isCorrectStatus()) {
            setCorrectStatus(false);
        }
        pseudoClassStateChanged(PSEUDO_CLASS_ERROR, error);
    }

    /**
     * Método para comprobar si el input está en estado correcto.
     *
     * @return true si el input está en estado correcto, false en caso contrario.
     */
    public boolean isCorrectStatus() {
        return getPseudoClassStates().contains(PSEUDO_CLASS_CORRECT);
    }

    /**
     * Método para comprobar si el input está en estado de error.
     *
     * @return true si el input está en estado de error, false en caso contrario.
     */
    public boolean isErrorStatus() {
        return getPseudoClassStates().contains(PSEUDO_CLASS_ERROR);
    }

}