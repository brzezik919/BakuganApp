package com.bakuganApp.service;

import com.bakuganApp.adapter.SqlMessageRepository;
import com.bakuganApp.model.Message;
import com.bakuganApp.model.MessageRepository;
import com.bakuganApp.model.UserRepository;
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

    public MessageService(MessageRepository messageRepository, SqlMessageRepository sqlMessageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.sqlMessageRepository = sqlMessageRepository;
        this.userRepository = userRepository;
    }

    public Page<Message> getListPartnerConversation(int id, int currentPage, int pageSize){
        Pageable page = PageRequest.of(currentPage, pageSize);
        return sqlMessageRepository.findUniqueById(id, page);
    }

    public Message sendMessage(Message toSend, int idWriter, int idReader){
        toSend.setUserWriter(userRepository.findById(idWriter));
        toSend.setUserReader(userRepository.findById(idReader));
        toSend.setTime(LocalDateTime.now());
        return messageRepository.save(toSend);
    }
}
