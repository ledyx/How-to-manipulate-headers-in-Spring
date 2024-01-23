package xyz.ledyx.manipulate_headers.intercecptor;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomHeaderHolder implements Cloneable {
    private String requestId;
    private String requestName;
    private LocalDateTime requestDate;

    @Override
    public CustomHeaderHolder clone() {
        try {
            return (CustomHeaderHolder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
