package com.alkemy.disney.controller;

import com.alkemy.disney.models.Users;
import com.alkemy.disney.services.Email;
import com.alkemy.disney.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersService usersService;

    @Autowired
    private Email email;

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestParam String user, @RequestParam String password) {
        // verify fields
        if(user.isEmpty()) {
            return new ResponseEntity<>("Field user is empty", HttpStatus.FORBIDDEN);
        }

        if(password.isEmpty()) {
            return new ResponseEntity<>("Field user is empty", HttpStatus.FORBIDDEN);
        }

        email.sendMail(user, "Welcome to Disney", "The account has been created, your user is " + user);

        usersService.register(new Users(user, passwordEncoder.encode(password)));
        return new ResponseEntity<>("User created" ,HttpStatus.CREATED);
    }
}
