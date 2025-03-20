package org.sisekipp.personal_ai.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.annotation.Nullable;

public record ChatRequest(
    @NotNull(message = "Message is required") 
    @NotEmpty(message = "Message cannot be empty") 
    String message,
    @Nullable String systemMessage 
) {
    
    public ChatRequest {
        if (systemMessage == null) {
            systemMessage = "You are a helpful assistant.";
        }
    }

    public ChatRequest(String message) {
        this(message, null);
    }
}
