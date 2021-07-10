package com.bakuganApp.controller;

import com.bakuganApp.model.Message;
import com.bakuganApp.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/api/message/send")
    ResponseEntity<?> sendMessage(@RequestParam("idWriter") int idFirstUser, @RequestParam("idReader") int idSecondUser, @RequestBody Message toSend){
        Message messageSent = messageService.sendMessage(toSend, idFirstUser, idSecondUser);
        return ResponseEntity.created(URI.create("/api/message/" + messageSent.getId())).body(messageSent);
    }

    @GetMapping("/api/message/find")
    ResponseEntity<Page<Message>> getMessagesWithUser(@RequestParam("first_user") int idFirstUser, @RequestParam("second_user") int idSecondUser, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        return ResponseEntity.ok(messageService.getAllMessagesWithUser(idFirstUser, idSecondUser, page.orElse(0), size.orElse(20)));
    }
}