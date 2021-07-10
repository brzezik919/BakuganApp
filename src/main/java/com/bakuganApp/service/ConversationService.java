package com.bakuganApp.service;

import com.bakuganApp.model.Conversation;
import com.bakuganApp.model.ConversationRepository;
import com.bakuganApp.model.Message;
import com.bakuganApp.model.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    public ConversationService(ConversationRepository conversationRepository, UserRepository userRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
    }

    public Conversation createConversation(Conversation conversationToSave){
        return conversationRepository.save(conversationToSave);
    }

    public Conversation findConversation(int firstUser, int secondUser){
        if(Objects.nonNull(conversationRepository.findByFirstUser_IdAndSecondUser_IdOrFirstUser_IdAndSecondUser_Id(firstUser, secondUser, secondUser, firstUser))){
            return conversationRepository.findByFirstUser_IdAndSecondUser_IdOrFirstUser_IdAndSecondUser_Id(firstUser, secondUser, secondUser, firstUser);
        }
        Conversation conversation = new Conversation();
        conversation.setFirstUser(userRepository.findById(firstUser));
        conversation.setSecondUser(userRepository.findById(secondUser));
        return createConversation(conversation);

    }

    public Page<Conversation> getListPartnerConversation(int id, int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        return conversationRepository.findByFirstUser_IdOrSecondUser_Id(id, id, page);
    }
}
