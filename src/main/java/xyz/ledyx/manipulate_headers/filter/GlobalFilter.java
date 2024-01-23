package xyz.ledyx.manipulate_headers.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@Component
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(request);
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // Custom header
        mutableHttpServletRequest.putHeader("requestId", "test-id");
        mutableHttpServletRequest.putHeader("requestName", "test-name");
        mutableHttpServletRequest.putHeader("requestDate", LocalDateTime.now().toString());
        chain.doFilter(mutableHttpServletRequest, httpServletResponse);
    }
}
