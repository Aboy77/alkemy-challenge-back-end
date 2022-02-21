package com.alkemy.disney.repositories;

import com.alkemy.disney.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitle(String title);
}
