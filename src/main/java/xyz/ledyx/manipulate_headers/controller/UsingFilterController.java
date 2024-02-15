package xyz.ledyx.manipulate_headers.controller;

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
@RequestMapping("/filter")
@RequiredArgsConstructor
public class UsingFilterController {
    @GetMapping("/call")
    public ResponseEntity<Map<String, String>> respondCustomHeader1(@RequestHeader Map<String, String> headers) {
        assert StringUtils.hasText(headers.get("request-id"));
        assert StringUtils.hasText(headers.get("request-name"));
        assert StringUtils.hasText(headers.get("request-date"));

        return ResponseEntity.ok(headers);
    }
}