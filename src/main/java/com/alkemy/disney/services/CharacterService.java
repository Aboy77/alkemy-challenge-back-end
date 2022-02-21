package com.alkemy.disney.services;

import com.alkemy.disney.models.Character;

import java.util.List;

public interface CharacterService {
    List<Character> getAll();
    Character getByName(String name);
    Character getByAge(Short age);
}
