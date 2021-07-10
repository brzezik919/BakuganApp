package com.bakuganApp.controller;

import com.bakuganApp.model.Conversation;
import com.bakuganApp.service.ConversationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConversationController {
    private final ConversationService conversationService;


    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/api/conversation/contact")
    ResponseEntity<Page<Conversation>> getListProduct(@RequestParam("id_user") int id, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        return ResponseEntity.ok(conversationService.getListPartnerConversation(id, page.orElse(0), size.orElse(20)));
    }
}
