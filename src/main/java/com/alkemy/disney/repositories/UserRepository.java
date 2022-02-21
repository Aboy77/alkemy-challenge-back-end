package com.alkemy.disney.repositories;

import com.alkemy.disney.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
