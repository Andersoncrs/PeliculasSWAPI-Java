package com.aluracursos.peliculasswapi.Excepciones;

/**
 * Excepción personalizada para manejar casos donde no se encuentra una película en la API.
 */
public class FilmNoEncontradoExcepcion extends Exception {
  /**
   * Constructor que inicializa la excepción con un mensaje específico.
   *
   * @param message Mensaje de error que describe el problema.
   */
  public FilmNoEncontradoExcepcion(String message) {
    super(message);
  }
}

