package com.alkemy.disney.services;

import com.alkemy.disney.models.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    List<Film> getAll();
    Optional<Film> getById(Long id);
    Film save(Film film);
    void delete(Long id);
    Film getByTitle(String title);
}
