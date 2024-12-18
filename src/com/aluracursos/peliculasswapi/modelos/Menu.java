package com.aluracursos.peliculasswapi.modelos;

import java.util.Scanner;

/**
 * Clase que maneja la interacción con el usuario mediante un menú.
 */
public class Menu {
    private final Scanner scanner = new Scanner(System.in); // Scanner para capturar la entrada del usuario.

    /**
     * Muestra un mensaje de bienvenida al usuario.
     */
    public void bienvenidaMenu() {
        System.out.println("""
                
                ******************** Bienvenido a Peliculas SWAPI ********************
                **********************************************************************
                Aqui podras encontrar detalles acerca de las peliculas de Star Wars.
                """);
    }

    /**
     * Muestra el menú y permite al usuario ingresar su elección.
     *
     * @return La elección del usuario.
     */
    public String mostrarMenu() {
        do {
            System.out.println("Ingresa el Numero de Film que deseas consultar. (Para Salir Escribe \"salir\").");
            String eleccionUsuario = scanner.nextLine().trim().toLowerCase();

            if (validarEntradaUsuario(eleccionUsuario)) {
                System.out.println("Ha ingresado una opcion invalida, intentelo de nuevo por favor");
                continue;
            }

            return eleccionUsuario; // Devuelve la entrada válida del usuario.
        } while (true);
    }

    /**
     * Validar que la entrada del usuario sea un número o la palabra "salir".
     *
     * @param eleccionUsuario Entrada del usuario.
     * @return true si la entrada es inválida, false si es válida.
     */
    public boolean validarEntradaUsuario(String eleccionUsuario) {
        return !eleccionUsuario.matches("\\d+") && !eleccionUsuario.contains("salir");
    }
}
