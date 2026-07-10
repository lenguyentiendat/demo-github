package com.devconnect.feed.dto;

import java.time.LocalDateTime;

public record PostResponse(
        String postId,
        String authorId,
        String content,
        LocalDateTime createdAt
) {
}