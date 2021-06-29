package com.bakuganApp.adapter;

import com.bakuganApp.model.User;
import com.bakuganApp.model.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SqlUserRepository extends UserRepository, JpaRepository<User, Integer> {
}
