package com.bakuganApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConversationRepository {
    Conversation save(Conversation conversation);
    Conversation findByFirstUser_IdAndSecondUser_IdOrFirstUser_IdAndSecondUser_Id(int id, int id2, int id3, int id4);
    Page<Conversation> findByFirstUser_IdOrSecondUser_Id(int id, int id2, Pageable pageable);
}
