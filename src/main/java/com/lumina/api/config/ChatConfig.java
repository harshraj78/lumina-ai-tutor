package com.lumina.api.config;

import org.springframework.ai.chat.memory.ChatMemory;
// Ensure this import is exactly this for version 1.0.0
import org.springframework.ai.chat.memory.JdbcChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ChatConfig {
    @Bean
    public ChatMemory chatMemory(JdbcTemplate jdbcTemplate) {
        return new JdbcChatMemory(jdbcTemplate);
    }
}