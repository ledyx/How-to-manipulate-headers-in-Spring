package xyz.ledyx.manipulate_headers.intercecptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomHeaderHolderConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customHeaderInterceptor());
    }

    @Bean
    public CustomHeaderInterceptor customHeaderInterceptor() {
        return new CustomHeaderInterceptor(customHeaderHolder());
    }

    @Bean
    @RequestScope
    public CustomHeaderHolder customHeaderHolder() {
        return new CustomHeaderHolder();
    }
}
