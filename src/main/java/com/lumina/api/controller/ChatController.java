package com.lumina.api.controller;

import com.lumina.api.service.AiTutorService;
import org.springframework.beans.factory.annotation.Autowired; // <-- Fixes 'Autowired'
import org.springframework.web.bind.annotation.*; // <-- Fixes 'RequestMapping', 'PostMapping', etc.

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired // This connects the controller to your service
    private AiTutorService aiTutorService;

    @PostMapping("/ask")
    public String ask(@RequestParam String sessionId, @RequestBody String message) {
        // This method receives the request and sends it to the service we fixed earlier
        return aiTutorService.askQuestion(sessionId, message);
    }
}