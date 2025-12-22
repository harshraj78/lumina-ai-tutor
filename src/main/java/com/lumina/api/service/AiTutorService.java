package com.lumina.api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiTutorService {

    private final ChatClient chatClient;

    // This builder automatically finds the Ollama settings from your properties file
    public AiTutorService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String summarizeLesson(String lessonText) {
        return chatClient.prompt()
                .user("Summarize this lesson text into 5 clear bullet points: " + lessonText)
                .call()
                .content();
    }
}