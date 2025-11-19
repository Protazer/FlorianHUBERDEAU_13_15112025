package com.example.back.controller;

import com.example.back.dto.SessionDto;
import com.example.back.service.implementation.SessionService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/session")
public class SessionController {

    final SessionService sessionService;
    final SimpMessagingTemplate simpMessagingTemplate;

    public SessionController(final SessionService sessionService, final SimpMessagingTemplate simpMessagingTemplate) {
        this.sessionService = sessionService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping("/current")
    public SessionDto getCurrentSession(){
       return sessionService.getOrCreateActiveSession();
    }

    @PostMapping("/{id}/close")
    public SessionDto closeSession(@PathVariable Long id){
        SessionDto session = sessionService.closeSession(id);
        simpMessagingTemplate.convertAndSend("/topic/session/" + id + "/status", "CLOSED");
        return session;
    }

}
