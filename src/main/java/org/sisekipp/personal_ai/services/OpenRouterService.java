package org.sisekipp.personal_ai.services;

import org.sisekipp.personal_ai.models.AIException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenRouterService {
    
    private final ChatClient chatClient;

    public OpenRouterService(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel)
        		.defaultAdvisors(
        				new SimpleLoggerAdvisor())
        		.build();
    }

    public String chat(@Nullable String systemMessage, @NonNull String message) throws AIException {
        try {
            return chatClient
                .prompt()
                .system(systemMessage)
                .user(message)
                .call()
                .content();
        } catch (Exception e) {
            log.error("Error during chat request", e);
            throw new AIException("Error during chat request", e);
        }
    }


}
