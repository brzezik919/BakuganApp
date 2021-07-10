package com.bakuganApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageRepository {
    Message save (Message message);
    Page<Message> findByConversation_IdOrderByTimeDesc(Long id, Pageable pageable);
}
