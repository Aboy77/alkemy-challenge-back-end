package com.alkemy.disney.services.impl;

import com.alkemy.disney.models.Film;
import com.alkemy.disney.repositories.FilmRepository;
import com.alkemy.disney.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<Film> getById(Long id) {
        return filmRepository.findById(id);
    }

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film getByTitle(String title) {
        return filmRepository.findByTitle(title);
    }
}
