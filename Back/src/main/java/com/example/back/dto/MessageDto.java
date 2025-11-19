package com.example.back.dto;

public record MessageDto(Long sessionId, String sender, String content) {
}
