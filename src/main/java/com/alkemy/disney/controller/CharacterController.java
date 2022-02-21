package com.alkemy.disney.controller;

import com.alkemy.disney.dtos.CharacterDTO;
import com.alkemy.disney.models.Character;
import com.alkemy.disney.models.Film;
import com.alkemy.disney.services.CharacterService;
import com.alkemy.disney.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private FilmService filmService;

    @GetMapping("/characters")
    public ResponseEntity<?> getAll(@RequestParam(required = false) String name,@RequestParam(required = false) Short age, @RequestParam(required = false) Long id) {
        // verify which field is filled
        //for name field
        if(name != null) {
            if(name.length() > 0) {
                Character character = characterService.getByName(name);
                if(character != null) {
                    return new ResponseEntity<>( new CharacterDTO(character),HttpStatus.OK);
                } else {
                    return new ResponseEntity<>( "Character not found",HttpStatus.NOT_FOUND);
                }
            }
        }

        // for age field
        if(age != null) {
            if(age > 0) {
                Character character = characterService.getByAge(age);
                if(character != null) {
                    return new ResponseEntity<>(new CharacterDTO(character), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
                }
            }
        }

        if(id != null) {
            Optional<Film> film = filmService.getById(id);
            List<Character> character = film.get().getCharacter();
            if(character != null) {
                return new ResponseEntity<>(character.stream().map(CharacterDTO::new).collect(Collectors.toList()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
            }
        }
            return new ResponseEntity<>(characterService.getAll().stream().map(CharacterDTO::new).collect(Collectors.toList()), HttpStatus.NOT_FOUND);

    }
}
