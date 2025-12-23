package com.lumina.api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class AiTutorService {
    private final ChatClient chatClient;

    public AiTutorService(ChatClient.Builder builder, ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultAdvisors(new PromptChatMemoryAdvisor(chatMemory))
                .build();
    }

    public String askQuestion(String sessionId, String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                // The key for 1.0.0 is CHAT_MEMORY_CONVERSATION_ID_KEY
                .advisors(a -> a.param("chat_memory_conversation_id", sessionId))
                .call()
                .content();
    }
}