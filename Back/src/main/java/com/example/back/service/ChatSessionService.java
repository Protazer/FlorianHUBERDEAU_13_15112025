package com.example.back.service;

import com.example.back.model.ChatSession;
import com.example.back.repository.ChatSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ChatSessionService {

    final ChatSessionRepository chatSessionRepository;

    public  ChatSessionService(final ChatSessionRepository chatSessionRepository){
        this.chatSessionRepository = chatSessionRepository;
    }

    public Optional<ChatSession> getChatSession(Long sessionId){
        return this.chatSessionRepository.findById(sessionId);
    }

    public ChatSession CreateChatSession(){
        ChatSession chatSession = new ChatSession();
        chatSession.setCreatedAt(LocalDateTime.now());
        chatSession.setStatus("OPEN");
        return chatSessionRepository.save(chatSession);
    }
}
