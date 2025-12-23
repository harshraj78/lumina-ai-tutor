package com.lumina.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
@Data
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;

    private String role; // "user" or "assistant"

    @Column(columnDefinition = "TEXT") // Allows long AI responses
    private String content;

    private LocalDateTime timestamp = LocalDateTime.now();
}