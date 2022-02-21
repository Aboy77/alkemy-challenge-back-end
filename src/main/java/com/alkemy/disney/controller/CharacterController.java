package com.alkemy.disney.controller;

import com.alkemy.disney.dtos.CharacterDTO;
import com.alkemy.disney.models.Character;
import com.alkemy.disney.models.Film;
import com.alkemy.disney.services.CharacterService;
import com.alkemy.disney.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/characters")
    public ResponseEntity<?> createCharacter(@RequestParam String img, @RequestParam String name, @RequestParam Short age, @RequestParam String weight, @RequestParam String story) {
        if(img.isEmpty()) {
            return new ResponseEntity<>("img field is empty", HttpStatus.FORBIDDEN);
        }

        if(name.isEmpty()) {
            return new ResponseEntity<>("name field is empty", HttpStatus.FORBIDDEN);
        }

        if(age == null) {
            return new ResponseEntity<>("age field is empty", HttpStatus.FORBIDDEN);
        }

        if(weight.isEmpty()) {
            return new ResponseEntity<>("weight field is empty", HttpStatus.FORBIDDEN);
        }

        if(story.isEmpty()) {
            return new ResponseEntity<>("story field is empty", HttpStatus.FORBIDDEN);
        }

        Character character = new Character(img, name, age, weight, story);

        characterService.save(character);

        return new ResponseEntity<>("Character created", HttpStatus.CREATED);
    }

    @PutMapping("/characters")
    public ResponseEntity<?> editCharacter(@RequestParam Long id,@RequestParam(required = false) String img, @RequestParam(required = false) String name, @RequestParam(required = false) Short age, @RequestParam(required = false) String weight, @RequestParam(required = false) String story) {
        Optional<Character> character = characterService.getById(id);

        if(character.isEmpty()) {
            return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
        }

        Character character1 = character.get();

        if(img != null) {
            character1.setImg(img);
        }

        if(name != null) {
            character1.setName(name);
        }

        if(age != null) {
            character1.setAge(age);
        }

        if(weight != null) {
            character1.setWeight(weight);
        }

        if(story != null) {
            character1.setStory(story);
        }

        characterService.save(character1);

        return new ResponseEntity<>("Character edited", HttpStatus.OK);
    }

    @DeleteMapping("/characters")
    public ResponseEntity<?> deleteCharacter(@RequestParam Long id) {
        Optional<Character> character = characterService.getById(id);

        if(character.isEmpty()) {
            return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
        }

        characterService.delete(id);

        return new ResponseEntity<>("Character deleted", HttpStatus.OK);
    }
}
