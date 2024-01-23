package xyz.ledyx.manipulate_headers.config;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomHeader {
    private String requestId;
    private String requestName;
    private LocalDateTime requestDate;
}
