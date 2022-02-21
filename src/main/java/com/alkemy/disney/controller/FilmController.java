package com.alkemy.disney.controller;

import com.alkemy.disney.dtos.FilmDTO;
import com.alkemy.disney.dtos.GenderDTO;
import com.alkemy.disney.models.Film;
import com.alkemy.disney.models.Gender;
import com.alkemy.disney.models.Order;
import com.alkemy.disney.services.FilmService;
import com.alkemy.disney.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenderService genderService;

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(@RequestParam(required = false) String name, @RequestParam(required = false) Long idGender, @RequestParam(required = false) Order order) {
        // find by params
        if(name != null) {
            Film film = filmService.getByTitle(name);
            if(film != null) {
                return new ResponseEntity<>(new FilmDTO(film), HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
            }
        }

        if(idGender != null) {
            Optional<Gender> gender = genderService.getById(idGender);
            if(gender.isPresent()) {
                return new ResponseEntity<>(new GenderDTO(gender.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Gender not found", HttpStatus.NOT_FOUND);
            }
        }

        if(order != null) {
            List<FilmDTO> films = filmService.getAll().stream().map(FilmDTO::new).collect(Collectors.toList());
            if(order.equals(Order.ASC)) {
                Collections.sort(films, new Comparator<FilmDTO>() {
                    @Override
                    public int compare(FilmDTO o1, FilmDTO o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });
                return new ResponseEntity<>(films, HttpStatus.OK);
            }
            if(order.equals(Order.DESC)) {
                Collections.sort(films, new Comparator<FilmDTO>() {
                    @Override
                    public int compare(FilmDTO o1, FilmDTO o2) {
                        return o2.getId().compareTo(o1.getId());
                    }
                });
                return new ResponseEntity<>(films, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(filmService.getAll().stream().map(FilmDTO::new).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies")
    public ResponseEntity<?> newMovie(@RequestParam String img, @RequestParam String title, @RequestParam Byte qualification) {
        // verify fields
        if(img.isEmpty()) {
            return new ResponseEntity<>("img field is empty", HttpStatus.FORBIDDEN);
        }

        if(title.isEmpty()) {
            return new ResponseEntity<>("title field is empty", HttpStatus.FORBIDDEN);
        }

        if(qualification == null) {
            return new ResponseEntity<>("qualification field is empty", HttpStatus.FORBIDDEN);
        } else {
            if(qualification > 5) {
                return new ResponseEntity<>("The qualification should not be more than 5", HttpStatus.FORBIDDEN);
            }
        }

        // save film at repository

        Film film = new Film(img, title, LocalDate.now(), qualification);

        filmService.save(film);

        return new ResponseEntity<>("Movie create", HttpStatus.CREATED);
    }

    @PutMapping("/movies")
    public ResponseEntity<?> editMovie(@RequestParam Long id, @RequestParam(required = false) String img, @RequestParam(required = false) String title, @RequestParam(required = false) Byte qualification) {
        if(id == null) {
            return new ResponseEntity<>("Need a id for find a film to edit", HttpStatus.FORBIDDEN);
        }

        // find movie to edit by id
        Optional<Film> film = filmService.getById(id);

        if(film.isEmpty()) {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }

        if(!title.isEmpty()) {
            film.get().setTitle(title);
        }

        if(qualification != null) {
            if(qualification > 5) {
                return new ResponseEntity<>("The qualification should not be more than 5", HttpStatus.FORBIDDEN);
            } else {
                film.get().setQualification(qualification);
            }
        }

        filmService.save(film.get());

        return new ResponseEntity<>("Movie edited", HttpStatus.CREATED);
    }

    @DeleteMapping("/movies")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if(id == null) {
            return new ResponseEntity<>("Need a id for find a film to delete", HttpStatus.FORBIDDEN);
        }

        // find movie to edit by id
        Optional<Film> film = filmService.getById(id);

        if(film.isEmpty()) {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }

        filmService.delete(id);

        return new ResponseEntity<>("Movie deleted", HttpStatus.OK);
    }
}
