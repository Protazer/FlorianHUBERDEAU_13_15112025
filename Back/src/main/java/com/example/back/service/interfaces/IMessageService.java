package com.example.back.service.interfaces;

import com.example.back.dto.MessageDto;
import com.example.back.model.Session;

import java.util.List;

public interface IMessageService {

    void createMessage(MessageDto msg, Session session);

    List<MessageDto> getAllMessagesBySessionId(Long sessionId);
}
