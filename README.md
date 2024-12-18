# Proyecto: Películas SWAPI

## Descripción del Proyecto

Este proyecto es una aplicación en Java que permite a los usuarios consultar información sobre las películas de Star
Wars utilizando la API de SWAPI. Además, se puede convertir la información obtenida en objetos Java, procesarlos y
guardarlos en formato JSON. La aplicación está diseñada para ser interactiva a través de un menú de consola.

## Características Principales

- Consulta información sobre una película de Star Wars basada en el número de episodio proporcionado por el usuario.
- Convierte la información obtenida de JSON a objetos Java y viceversa.
- Guarda los datos de la película en un archivo JSON.
- Proporciona manejo de errores en caso de fallos en la comunicación con la API o episodios inexistentes.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación.
- **SWAPI**: API para obtener datos sobre películas de Star Wars.
- **Gson**: Biblioteca para la conversión de objetos Java a JSON y viceversa.

## Estructura del Proyecto

```
com.aluracursos.peliculasswapi
├── apis
│   └── PeticionApiSwapi.java
├── convertidorjson
│   └── ConvertidorJson.java
├── dtos
│   └── PeliculaSwapi.java
├── excepciones
│   └── FilmNoEncontradoExcepcion.java
├── manejopeliculas
│   └── GuardarPelicula.java
├── modelos
│   ├── Menu.java
│   └── Pelicula.java
└── principal
    └── Main.java
```

## Instalación y Ejecución

1. Clonar este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/usuario/proyecto-peliculas-swapi.git
   ```
2. Asegúrate de tener Java 17 instalado.
3. Importa el archivo `.jar` de Gson al proyecto.
4. Compila el proyecto:
   ```bash
   javac -cp .;gson-2.8.9.jar com/aluracursos/peliculasswapi/principal/Main.java
   ```
5. Ejecuta el programa:
   ```bash
   java -cp .;gson-2.8.9.jar com.aluracursos.peliculasswapi.principal.Main
   ```

## Uso

1. Al iniciar el programa, se mostrará un menú de bienvenida.
2. El usuario debe ingresar el número del episodio que desea consultar. Ejemplo: `1`.
3. Si el episodio existe, se mostrará la información de la película en consola y se guardará en un archivo
   `Peliculas.json`.
4. Si el episodio no existe, el programa notificará al usuario y permitirá realizar otra consulta.
5. Para salir, escribe `salir`.

## Excepciones y Manejo de Errores

- **FilmNoEncontradoExcepcion**: Se lanza cuando el episodio solicitado no existe en la API.
- **IOException**: Se maneja cuando hay problemas de comunicación con la API o al escribir en el archivo.
- **InterruptedException**: Se maneja cuando la petición a la API es interrumpida.

## Contribución

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad:
   ```bash
   git checkout -b nueva-funcionalidad
   ```
3. Realiza tus cambios y haz commit:
   ```bash
   git commit -m "Añadir nueva funcionalidad"
   ```
4. Sube tus cambios:
   ```bash
   git push origin nueva-funcionalidad
   ```
5. Abre un Pull Request.

## Futuras Mejoras

1. **Lista de Películas**: Implementar una funcionalidad que permita al usuario añadir varias películas a una lista y,
   cuando termine, guardarlas en un archivo JSON.
2. **Consulta de Episodios Disponibles**: Realizar una consulta inicial a la API para obtener y mostrar los episodios
   disponibles en el menú principal.
3. **Evitar Duplicados**: Antes de guardar una película en la lista, verificar si ya existe. Si está duplicada,
   notificar al usuario y permitirle seguir añadiendo nuevas películas.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.


