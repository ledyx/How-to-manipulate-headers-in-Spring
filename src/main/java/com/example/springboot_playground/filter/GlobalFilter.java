package com.example.springboot_playground.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class GlobalFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(request);
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // Custom header
        mutableHttpServletRequest.putHeader("foo", "bar");
        chain.doFilter(mutableHttpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
