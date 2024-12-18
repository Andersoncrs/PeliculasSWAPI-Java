package com.aluracursos.peliculasswapi.principal;

import com.aluracursos.peliculasswapi.modelos.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.bienvenidaMenu();

        while(true){
            String eleccionUsuario = menu.mostrarMenu();

            if(eleccionUsuario.contains("salir")){
                break;
            }
        }
        System.out.println("Gracias por utilizar nuestros servicios");

    }
}