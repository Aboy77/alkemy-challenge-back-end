package com.alkemy.disney.services.impl;

import com.alkemy.disney.models.Character;
import com.alkemy.disney.repositories.CharacterRepository;
import com.alkemy.disney.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character getByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public Character getByAge(Short age) {
        return characterRepository.findByAge(age);
    }
}
