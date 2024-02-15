package xyz.ledyx.manipulate_headers.model;

import java.time.LocalDateTime;

public record ExampleResponse(String requestId, String requestName, LocalDateTime requestDate) {
    public static ExampleResponse from(CustomHeaderHolder customHeaderHolder) {
        return new ExampleResponse(customHeaderHolder.getRequestId(), customHeaderHolder.getRequestName(), customHeaderHolder.getRequestDate());
    }
}
