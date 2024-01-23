package com.example.springboot_playground.controller;

import com.example.springboot_playground.intercecptor.CustomHeaderHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/custom-headers")
@RequiredArgsConstructor
public class CustomHeaderController {
    private final CustomHeaderHolder customHeaderHolder;

    @GetMapping("/basic")
    public ResponseEntity<Map<String, String>> respondCustomHeader1(@RequestHeader Map<String, String> headers) {

        assert StringUtils.hasText(headers.get("requestId"));
        assert StringUtils.hasText(headers.get("requestName"));
        assert StringUtils.hasText(headers.get("requestDate"));

        return ResponseEntity.ok(headers);
    }

    @GetMapping("/enhanced")
    public ResponseEntity<CustomHeaderHolder> respondCustomHeader2() {

        assert StringUtils.hasText(customHeaderHolder.getRequestId());
        assert StringUtils.hasText(customHeaderHolder.getRequestName());
        assert customHeaderHolder.getRequestDate() != null;

        // request scope가 걸린 bean을 응답으로 반환하면 순환 참조 발생
        return ResponseEntity.ok(customHeaderHolder.clone());
    }
}