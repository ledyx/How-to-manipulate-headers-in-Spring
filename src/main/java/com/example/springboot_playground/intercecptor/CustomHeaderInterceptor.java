package com.example.springboot_playground.intercecptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CustomHeaderInterceptor implements HandlerInterceptor {
    private final CustomHeaderHolder customHeaderHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        customHeaderHolder.setRequestId(request.getHeader("requestId"));
        customHeaderHolder.setRequestName(request.getHeader("requestName"));
        customHeaderHolder.setRequestDate(LocalDateTime.parse(request.getHeader("requestDate")));
        return true;
    }
}
