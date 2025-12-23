package com.lumina.api.repository;

import com.lumina.api.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Long> {

    // This custom method finds all messages for a specific student's session
    // and orders them from oldest to newest.
    List<ChatMessage> findBySessionIdOrderByTimestampAsc(String sessionId);
}