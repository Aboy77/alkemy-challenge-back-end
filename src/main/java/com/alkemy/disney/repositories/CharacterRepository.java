package com.alkemy.disney.repositories;

import com.alkemy.disney.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findByName(String name);
    Character findByAge(Short age);
}
