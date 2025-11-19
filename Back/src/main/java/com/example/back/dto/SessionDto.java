package com.example.back.dto;

import java.time.LocalDateTime;
import java.util.List;

public record SessionDto(Long id, Long userId, LocalDateTime createdAt, LocalDateTime closedAt, List<MessageDto> messages) {
}
