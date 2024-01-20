package com.example.springboot_playground.controller;

import com.example.springboot_playground.config.CustomHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/foo")
    public ResponseEntity<CustomHeader> foo(@RequestHeader CustomHeader headers) {
        return ResponseEntity.ok(headers);
    }
}