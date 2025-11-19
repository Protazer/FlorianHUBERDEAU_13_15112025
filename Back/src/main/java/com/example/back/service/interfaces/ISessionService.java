package com.example.back.service.interfaces;

import com.example.back.dto.SessionDto;
import com.example.back.model.Session;

import java.util.Optional;

public interface ISessionService {

     Optional<Session> getSession(Long sessionId);
     SessionDto getOrCreateActiveSession();
     Session createSession();
     SessionDto closeSession(Long sessionId);
}
