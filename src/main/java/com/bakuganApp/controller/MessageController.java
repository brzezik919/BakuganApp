package com.bakuganApp.controller;

import com.bakuganApp.model.Message;
import com.bakuganApp.service.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/api/{id}/message/contact")
    ResponseEntity<Page<Message>> getListProduct(@PathVariable int id, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        return ResponseEntity.ok(messageService.getListPartnerConversation(id, page.orElse(0), size.orElse(20)));
    }

    @PostMapping("/api/{idWriter}/message/send")
    ResponseEntity<?> sendMessage(@PathVariable int idWriter, @RequestParam("idReader") int idReader, @RequestBody Message toSend){
        Message messageSent = messageService.sendMessage(toSend, idWriter, idReader);
        return ResponseEntity.created(URI.create("/api/message/" + messageSent.getId())).body(messageSent);
    }
}
