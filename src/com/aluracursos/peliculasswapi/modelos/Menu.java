package com.aluracursos.peliculasswapi.modelos;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void bienvenidaMenu(){
        System.out.println("""
                
                ******************** Bienvenido a Peliculas SWAPI ********************
                **********************************************************************
                Aqui podras encontrar detalles acerca de las peliculas de Star Wars.
                
                """);
    }

    public String mostrarMenu(){
        do{
            System.out.println("Ingresa el Numero de Episodio que deseas consultar. (Para Salir Escribe \"salir\").");
            String EleccionUsuario = scanner.nextLine().trim().toLowerCase();
            if(validarEntradaUsuario(EleccionUsuario)){
                System.out.println("Ha ingresado una opcion invalida, intentelo de nuevo por favor");
                continue;
            }
            return EleccionUsuario;
        } while(true);
    }

    public boolean validarEntradaUsuario(String EleccionUsuario){

        if(EleccionUsuario.matches("\\d+") || EleccionUsuario.contains("salir")){
            return false;
        }
        return true;

    }
}
