package com.bakuganApp.service;

import com.bakuganApp.model.User;
import com.bakuganApp.model.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(int id){
        return userRepository.findById(id);
    }
}
