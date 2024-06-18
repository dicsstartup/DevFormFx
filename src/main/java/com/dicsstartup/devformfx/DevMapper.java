package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.devInputs.DevCheckBoxes;
import com.dicsstartup.devformfx.devInputs.core.DevInput;
import java.lang.reflect.Method;
import java.util.List;

public class DevMapper {

    // Mapea un objeto a una lista de inputs existente
    public void updateInputsFromObject( Object source, List<DevInput> inputs) throws Exception {
        Method[] methods = source.getClass().getMethods();
        for (Method method : methods) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && method.getParameterCount() == 0) {
                String key = method.getName().substring(method.getName().startsWith("is")?2: 3);
                key = Character.toLowerCase(key.charAt(0)) + key.substring(1);
                Object value = method.invoke(source);
                for (var input : inputs) {
                    if (input.getKey().equals(key)) {
                        input.setValue(value);
                        break;
                    }
                }
            }
        }
    }
    // Mapea una lista de inputs a un objeto
    public void inputsToObject( Object target, List<DevInput> inputs) throws Exception {
        for (DevInput input : inputs) {
            String key = input.getKey();
            Object value = input.getValue();
            if (input.getClass() == DevCheckBoxes.class) {
                DevCheckBoxes checkBoxes = (DevCheckBoxes) input;
                if (checkBoxes.isOnlyOneOpction()) {

                }
            }
            Method setter = findSetter(target.getClass(), key);
            if (setter != null) {
                setter.invoke(target, value);
            }
        }
    }

    // Encuentra el método setter para una propiedad dada
    private  Method findSetter(Class<?> clazz, String fieldName) {
        String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(setterName) && method.getParameterCount() == 1) {
                return method;
            }
        }
        return null;
    }
}
