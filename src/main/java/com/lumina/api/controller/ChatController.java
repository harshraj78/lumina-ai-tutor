package com.lumina.api.controller;

import com.lumina.api.service.AiTutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {

    private final AiTutorService aiTutorService;

    @PostMapping
    public String chat(@RequestParam String sessionId, @RequestParam String message) {
        return aiTutorService.askQuestion(sessionId, message);
    }
}