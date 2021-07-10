package com.bakuganApp.service;

import com.bakuganApp.adapter.SqlMessageRepository;
import com.bakuganApp.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final SqlMessageRepository sqlMessageRepository;
    private final UserRepository userRepository;
    private final ConversationRepository conversationRepository;
    private final ConversationService conversationService;

    public MessageService(MessageRepository messageRepository, SqlMessageRepository sqlMessageRepository, UserRepository userRepository, ConversationRepository conversationRepository, ConversationService conversationService) {
        this.messageRepository = messageRepository;
        this.sqlMessageRepository = sqlMessageRepository;
        this.userRepository = userRepository;
        this.conversationRepository = conversationRepository;
        this.conversationService = conversationService;
    }

    public Message sendMessage(Message toSend, int idFirstUser, int idSecondUser){
        toSend.setConversation(conversationService.findConversation(idFirstUser, idSecondUser));
        toSend.setUserWriter(userRepository.findById(idFirstUser));
        toSend.setTime(LocalDateTime.now());
        return messageRepository.save(toSend);
    }

    public Page<Message> getAllMessagesWithUser(int idFirstUser, int idSecondUser, int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        Conversation conversation = conversationRepository.findByFirstUser_IdAndSecondUser_IdOrFirstUser_IdAndSecondUser_Id(idFirstUser, idSecondUser, idSecondUser, idFirstUser);
        try{
            return messageRepository.findByConversation_IdOrderByTimeDesc(conversation.getId(), page);
        }
        catch(NullPointerException e){
            return null;
        }
    }
}