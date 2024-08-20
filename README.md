<h1> DevFormFx </h1>

## Descripción

DevFormFx es una librería Java que te permite crear bibliotecas de manera dinámica y sencilla. Con DevFormFx, puedes diseñar y construir formularios personalizados con facilidad, integrando inputs y acciones según tus necesidades.

## Requisitos del Sistema

- Maven 3.9.5
- Eclipse Adoptium Temurin OpenJDK 17.0.12.7-hotspot
- Se recomienda utilizar Intellij IDEA como entorno de desarrollo integrado (IDE)
   
## Uso del Proyecto:

Se utiliza en el proyecto DevHelper

### DevFormBuilder: 

Define el layout principal del formulario, con opciones para agregar columnas y filas.
Inputs: Define los parámetros de entrada que los usuarios pueden completar.
Actions: Define los botones o acciones que los usuarios pueden realizar.
Colaboración:

Si deseas contribuir al desarrollo de DevFormFx, sigue estas pautas:
Realiza cambios significativos de manera detallada pero concisa.
Añade comentarios descriptivos dentro del código.
Envía tus cambios a través de una pull request.

### Ejemplo de Uso
```java
 DevFormBuilder form = new DevFormBuilder();
        form.grid.addColsWithWidth(100);
        form.grid.addRowsWithHeigtht(200);
        form.Buider();
        scene = new Scene(form.getFXMLLoader(), 480, 480);
```

## Contribuciones
¡Tus contribuciones son bienvenidas! Si deseas colaborar en el desarrollo de DevFormFx, no dudes en enviar una pull request con tus mejoras.

## Licencia
Este proyecto está bajo la Licencia Apache 2.0. Consulta el archivo LICENSE para obtener más detalles.
