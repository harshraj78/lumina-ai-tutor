package com.lumina.api.service;

import com.lumina.api.model.ChatMessage;
import com.lumina.api.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class AiTutorService {

    @Autowired
    private ChatRepository chatRepository; // This talks to your PostgreSQL

    private final RestTemplate restTemplate = new RestTemplate();
    private final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String askQuestion(String sessionId, String userMessage) {
//        // 1. SAVE the user's question to the database
//        ChatMessage userMsg = new ChatMessage();
//        userMsg.setSessionId(sessionId);
//        userMsg.setRole("user");
//        userMsg.setContent(userMessage);
//        chatRepository.save(userMsg);
//
//        // 2. FETCH previous messages to give the AI context
//        List<ChatMessage> history = chatRepository.findBySessionIdOrderByTimestampAsc(sessionId);
//
//        // 3. BUILD a combined prompt (History + New Question)
//        String context = history.stream()
//                .map(m -> m.getRole() + ": " + m.getContent())
//                .collect(Collectors.joining("\n"));
//
//        String fullPrompt = "You are Lumina, a helpful AI tutor. Use the conversation history below to answer:\n\n"
//                + context + "\nassistant: ";
//
//        // 4. CALL Ollama
//        String aiResponse = callOllama(fullPrompt);
//
//        // 5. SAVE the AI's response so it remembers it next time
//        ChatMessage assistantMsg = new ChatMessage();
//        assistantMsg.setSessionId(sessionId);
//        assistantMsg.setRole("assistant");
//        assistantMsg.setContent(aiResponse);
//        chatRepository.save(assistantMsg);
//
//        return aiResponse;

        String fullPrompt = "user: " + userMessage + "\nassistant: ";

        return callOllama(fullPrompt);
    }

    public String summarizeLesson(String lessonText) {
        return callOllama("Summarize this lesson text clearly for a student: \n" + lessonText);
    }

    private String callOllama(String prompt) {
        try {
            Map<String, Object> request = new HashMap<>();
            request.put("model", "phi3:latest"); // <--- Change this from "llama3" to "phi3"
            request.put("prompt", prompt);
            request.put("stream", false);

            Map<String, Object> response = restTemplate.postForObject(OLLAMA_URL, request, Map.class);
            return response != null ? (String) response.get("response") : "Error: No response";
        } catch (Exception e) {
            return "Error: Could not connect to Phi-3. Is it running? " + e.getMessage();
        }
    }
}