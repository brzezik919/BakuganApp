package com.bakuganApp.adapter;

import com.bakuganApp.model.Conversation;
import com.bakuganApp.model.ConversationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SqlConversationRepository extends ConversationRepository, JpaRepository<Conversation, Long> {
}
