package com.alkemy.disney.services.impl;

import com.alkemy.disney.models.Gender;
import com.alkemy.disney.repositories.GenderRepository;
import com.alkemy.disney.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;


    @Override
    public Optional<Gender> getById(Long id) {
        return genderRepository.findById(id);
    }
}
