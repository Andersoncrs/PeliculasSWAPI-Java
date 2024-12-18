package com.aluracursos.peliculasswapi.principal;

import com.aluracursos.peliculasswapi.apis.PeticionApiSwapi;
import com.aluracursos.peliculasswapi.modelos.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.bienvenidaMenu();

        while(true){
            String eleccionUsuario = menu.mostrarMenu();

            if(eleccionUsuario.contains("salir")){
                break;
            }

            try {
                PeticionApiSwapi peticionApiSwapi = new PeticionApiSwapi(eleccionUsuario);
                String resultadoPeticionApi = peticionApiSwapi.peticionPeliculaUsiario();
                System.out.println(resultadoPeticionApi);


            }catch (IOException e){
                System.out.println("Hubo un problema al intentar obtener los datos de la Pelicula");
                System.out.println("Error: " + e.getMessage());
            }catch (InterruptedException e){
                System.out.println("No se ha podido comunicar con el servidor para obtener los datos. " +
                        "Inetentelo mas tarde");
            }
        }
        System.out.println("Gracias por utilizar nuestros servicios");

    }
}