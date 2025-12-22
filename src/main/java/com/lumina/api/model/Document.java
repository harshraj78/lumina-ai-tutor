package com.lumina.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "documents")
@Getter @Setter @NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fileName;
    private String filePath; // This stores WHERE the file is on your computer
    private String contentType; // e.g., "application/pdf"

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
}