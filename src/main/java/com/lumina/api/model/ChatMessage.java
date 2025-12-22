package com.lumina.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat_messages")
@Getter @Setter @NoArgsConstructor
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String sender; // "USER" or "AI"

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document; // Which PDF are we talking about?
}