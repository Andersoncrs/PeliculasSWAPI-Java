package com.aluracursos.peliculasswapi.dtos;

/**
 * Clase de tipo Record que representa los datos básicos de una película obtenidos
 * de la API SWAPI.
 * <p>
 * Contiene información sobre el título, episodio, texto de apertura, director y productor.
 */
public record PeliculaSwapi(String title, int episode_id, String opening_crawl, String director, String producer) {
    // Los campos del Record son inmutables y públicos por defecto.
}
