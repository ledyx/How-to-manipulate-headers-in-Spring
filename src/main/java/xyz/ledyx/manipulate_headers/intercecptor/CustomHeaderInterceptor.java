package xyz.ledyx.manipulate_headers.intercecptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import xyz.ledyx.manipulate_headers.model.CustomHeaderHolder;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CustomHeaderInterceptor implements HandlerInterceptor {
    private final CustomHeaderHolder customHeaderHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        customHeaderHolder.setRequestId(request.getHeader("request-id"));
        customHeaderHolder.setRequestName(request.getHeader("request-name"));
        customHeaderHolder.setRequestDate(LocalDateTime.parse(request.getHeader("request-date")));
        return true;
    }
}
