package com.bakuganApp.controller;

import com.bakuganApp.model.User;
import com.bakuganApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/{id}")
    ResponseEntity<User> getUser(@PathVariable int id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/api/user/{id}/save")
    ResponseEntity<?> changeDetailsUser(@PathVariable int id, @RequestBody User toUpdate) {
        return userService.updateUser(id, toUpdate) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

}
