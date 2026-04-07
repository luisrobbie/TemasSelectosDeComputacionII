package com.online_courses.platform.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.online_courses.platform.models.User;
import com.online_courses.platform.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    
    public User newUser(@RequestBody User user){
            return userService.newUser(user);
        }

    @PostMapping("/send-correo")
    public String sendCorreo(@RequestParam String to) {
        try {
            User tempUser = new User();
            tempUser.setEmail(to);
            tempUser.setName("Usuario");
            userService.sendWelcomeEmail(tempUser);
            return "Correo enviado a " + to;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
    
}
