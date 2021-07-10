package com.bakuganApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
    User findById(int id);
    User save(User user);
    boolean existsById(int id);
    Page<User> findByRole(String role, Pageable pageable);
}
