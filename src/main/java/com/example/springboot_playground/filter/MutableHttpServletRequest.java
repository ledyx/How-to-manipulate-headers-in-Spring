package com.example.springboot_playground.filter;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.util.*;

public class MutableHttpServletRequest extends HttpServletRequestWrapper {
    private final Map<String, String> customHeaders;

    public MutableHttpServletRequest(ServletRequest request) {
        super((HttpServletRequest) request);
        this.customHeaders = new HashMap<>();
    }

    public void putHeader(String name, String value) {
        this.customHeaders.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        return Optional.ofNullable(customHeaders.get(name))
                .orElse(super.getHeader(name));
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        Set<String> set = new HashSet<>(customHeaders.keySet());

        Enumeration<String> headerNames = super.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            set.add(headerNames.nextElement());
        }

        return Collections.enumeration(set);
    }
}
