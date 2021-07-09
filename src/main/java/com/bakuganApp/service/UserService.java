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

    public boolean updateUser(int id, User userToSave){
        if(!userRepository.existsById(id)){
            return false;
        }
        User userFound = getUser(id);
        userToSave.setId(id);
        userToSave.setLogin(userFound.getLogin());
        userToSave.setPassword(userFound.getPassword());
        userToSave.setMail(userFound.getMail());
        userToSave.setRole(userFound.getRole());
        userRepository.save(userToSave);
        return true;
    }
}
