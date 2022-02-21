package com.alkemy.disney.services;

import com.alkemy.disney.models.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<Character> getAll();
    Character getByName(String name);
    Character getByAge(Short age);
    void save(Character character);
    Optional<Character> getById(Long id);
    void delete(Long id);
}
