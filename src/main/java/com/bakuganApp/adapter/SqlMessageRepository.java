package com.bakuganApp.adapter;

import com.bakuganApp.model.Message;
import com.bakuganApp.model.MessageRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SqlMessageRepository extends MessageRepository, JpaRepository<Message, Integer> {
}
