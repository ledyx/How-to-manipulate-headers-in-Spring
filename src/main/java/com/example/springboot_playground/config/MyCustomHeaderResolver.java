package com.example.springboot_playground.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyCustomHeaderResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.hasParameterAnnotation(RequestHeader.class) &&
                CustomHeader.class.isAssignableFrom(parameter.getParameterType()));
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class<?> paramType = parameter.getParameterType();
        if (CustomHeader.class.isAssignableFrom(paramType)) {
            CustomHeader result = new CustomHeader();
            result.setRequestId(webRequest.getHeader("requestId"));
            result.setRequestName(webRequest.getHeader("requestName"));
            result.setRequestDate(LocalDateTime.now());
            return result;
        }
        else {
            Map<String, String> result = new LinkedHashMap<>();
            for (Iterator<String> iterator = webRequest.getHeaderNames(); iterator.hasNext();) {
                String headerName = iterator.next();
                String headerValue = webRequest.getHeader(headerName);
                if (headerValue != null) {
                    result.put(headerName, headerValue);
                }
            }
            return result;
        }
    }
}
