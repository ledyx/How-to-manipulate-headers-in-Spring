package xyz.ledyx.manipulate_headers.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ledyx.manipulate_headers.model.CustomHeaderHolder;

@Slf4j
@RestController
@RequestMapping("/interceptor")
@RequiredArgsConstructor
public class UsingInterceptorController {
    private final CustomHeaderHolder customHeaderHolder;

    @GetMapping("/call")
    public ResponseEntity<CustomHeaderHolder> respondCustomHeader1() {
        assert customHeaderHolder.getRequestId() != null;
        assert customHeaderHolder.getRequestName() != null;
        assert customHeaderHolder.getRequestDate() != null;

        // bean 순환 참조 방지로 clone() 호출
        return ResponseEntity.ok(customHeaderHolder.clone());
    }
}