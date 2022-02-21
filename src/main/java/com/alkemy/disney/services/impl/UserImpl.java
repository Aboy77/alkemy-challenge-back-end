package com.alkemy.disney.services.impl;

import com.alkemy.disney.models.Users;
import com.alkemy.disney.repositories.UserRepository;
import com.alkemy.disney.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(Users users) {
        userRepository.save(users);
    }
}
