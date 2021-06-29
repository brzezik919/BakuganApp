package com.bakuganApp.adapter;

import com.bakuganApp.model.Observer;
import com.bakuganApp.model.ObserverRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SqlObserverRepository extends ObserverRepository, JpaRepository<Observer, Integer> {
}
