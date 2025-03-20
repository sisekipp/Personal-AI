package org.sisekipp.personal_ai.controller;

import org.sisekipp.personal_ai.models.AIException;
import org.sisekipp.personal_ai.models.ChatRequest;
import org.sisekipp.personal_ai.services.OpenRouterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OpenRouterService openRouterService;

    public ChatController(OpenRouterService openRouterService) {
        this.openRouterService = openRouterService;
    }

    @PostMapping("")
    public ResponseEntity<String> chat(@RequestBody @Valid ChatRequest request) {
        String response = openRouterService.chat(request.systemMessage(), request.message());

        return ResponseEntity.ok().contentType(MediaType.TEXT_MARKDOWN).body(response);
    }

    @ExceptionHandler(AIException.class)
    public ResponseEntity<String> handleRuntimeException(AIException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
