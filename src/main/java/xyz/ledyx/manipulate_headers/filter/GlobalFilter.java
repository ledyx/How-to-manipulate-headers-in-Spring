package xyz.ledyx.manipulate_headers.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Component
@Profile("dev")
public class GlobalFilter implements Filter {

    @Value("${auth.requestId}")
    private String requestId;

    @Value("${auth.requestName}")
    private String requestName;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(request);
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // Custom header
        mutableHttpServletRequest.putHeader("request-id", Optional.ofNullable(mutableHttpServletRequest.getHeader("request-id"))
                .orElse(requestId));
        mutableHttpServletRequest.putHeader("request-name", Optional.ofNullable(mutableHttpServletRequest.getHeader("request-name"))
                .orElse(requestName));
        mutableHttpServletRequest.putHeader("request-date", Optional.ofNullable(mutableHttpServletRequest.getHeader("request-date"))
                .orElse(LocalDateTime.now().toString()));
        chain.doFilter(mutableHttpServletRequest, httpServletResponse);
    }
}
