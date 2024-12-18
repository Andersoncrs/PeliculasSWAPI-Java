package com.aluracursos.peliculasswapi.modelos;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void bienvenidaMenu() {
        System.out.println("""
                
                ******************** Bienvenido a Peliculas SWAPI ********************
                **********************************************************************
                Aqui podras encontrar detalles acerca de las peliculas de Star Wars.
                """);
    }

    public String mostrarMenu() {
        do {
            System.out.println("Ingresa el Numero de Film que deseas consultar. (Para Salir Escribe \"salir\").");
            String eleccionUsuario = scanner.nextLine().trim().toLowerCase();
            if (validarEntradaUsuario(eleccionUsuario)) {
                System.out.println("Ha ingresado una opcion invalida, intentelo de nuevo por favor");
                continue;
            }
            return eleccionUsuario;
        } while (true);
    }

    public boolean validarEntradaUsuario(String EleccionUsuario) {

        return !EleccionUsuario.matches("\\d+") && !EleccionUsuario.contains("salir");
    }
}
