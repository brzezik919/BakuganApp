package com.bakuganApp.model;

public interface UserRepository {
    User findById(int id);
    User save(User user);
    boolean existsById(int id);
}
