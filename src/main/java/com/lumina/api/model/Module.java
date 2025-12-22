package com.lumina.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "modules")
@Getter @Setter @NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;

    @ManyToOne // Many modules can be created by one Instructor
    @JoinColumn(name = "instructor_id")
    private User instructor;
}