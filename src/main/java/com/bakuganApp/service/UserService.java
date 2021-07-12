package com.bakuganApp.service;

import com.bakuganApp.model.User;
import com.bakuganApp.model.UserRepository;
import com.bakuganApp.model.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public boolean changePassword(int id, User userWithNewPassword){
        if(!userRepository.existsById(id)){
            return false;
        }
        User userFound = getUser(id);
        userFound.setPassword(userWithNewPassword.getPassword());
        userRepository.save(userFound);
        return true;
    }

    public boolean changeMail(int id, User userWithNewMail){
        if(!userRepository.existsById(id)){
            return false;
        }
        User userFound = getUser(id);
        userFound.setMail(userWithNewMail.getMail());
        userRepository.save(userFound);
        return true;
    }

    public User createUser(User toSave) {
        toSave.setRole(UserRole.USER_ROLE.toString());
        return userRepository.save(toSave);
    }

    public Page<User> getAllStandardUsers(int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        return userRepository.findByRole(UserRole.USER_ROLE.toString(), page);
    }
}
