package org.sisekipp.personal_ai.models;

/**
 * Custom exception for AI-related errors
 */

public class AIException extends RuntimeException {
    public AIException(String message) {
        super(message);
    }

    public AIException(String message, Throwable cause) {
        super(message, cause);
    }
}
