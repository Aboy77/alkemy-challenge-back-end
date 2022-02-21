package com.alkemy.disney.services;

import com.alkemy.disney.models.Gender;

import java.util.Optional;

public interface GenderService {
    Optional<Gender> getById(Long id);
}
