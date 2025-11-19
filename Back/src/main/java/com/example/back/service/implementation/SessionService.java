package com.example.back.service.implementation;

import com.example.back.dto.SessionDto;
import com.example.back.mapper.SessionMapper;
import com.example.back.model.Session;
import com.example.back.repository.SessionRepository;
import com.example.back.service.interfaces.ISessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessionService implements ISessionService {

    final SessionRepository sessionRepository;
    final SessionMapper sessionMapper;

    public SessionService(final SessionRepository sessionRepository, final SessionMapper sessionMapper){
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
    }

    public Optional<Session> getSession(Long sessionId){
        return this.sessionRepository.findById(sessionId);
    }

    public SessionDto getOrCreateActiveSession() {
        Session session = sessionRepository.findFirstByStatus("OPEN")
                .orElseGet(() -> {
                    Session s = new Session();
                    s.setStatus("OPEN");
                    s.setCreatedAt(LocalDateTime.now());
                    return sessionRepository.save(s);
                });

        return sessionMapper.toSessionDto(session);
    }

    public Session createSession(){
        Session session = new Session();
        session.setCreatedAt(LocalDateTime.now());
        session.setStatus("OPEN");
        return sessionRepository.save(session);
    }

    public SessionDto closeSession(Long sessionId){
        Session session = sessionRepository.findById(sessionId).orElseThrow(() -> new RuntimeException("session not found"));
        session.setClosedAt(LocalDateTime.now());
        session.setStatus("CLOSED");
        Session newSession = sessionRepository.save(session);
        return sessionMapper.toSessionDto(newSession);
    }
}
