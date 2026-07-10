package com.devconnect.feed.dto;

import jakarta.validation.constraints.NotBlank;

public record CreatePostRequest(

        @NotBlank(message = "authorId is required")
        String authorId,

        @NotBlank(message = "content is required")
        String content
) {
}