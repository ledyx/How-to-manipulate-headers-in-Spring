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
        customHeaderHolder.setRequestId(request.getHeader("requestId"));
        customHeaderHolder.setRequestName(request.getHeader("requestName"));
        customHeaderHolder.setRequestDate(LocalDateTime.parse(request.getHeader("requestDate")));
        return true;
    }
}
