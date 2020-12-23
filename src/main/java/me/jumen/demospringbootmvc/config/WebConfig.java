package me.jumen.demospringbootmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
    spring boot가 제공하는 기본 리소스 핸들러
    classpath:/static
    classpath:/public
    classpath:/resources/
    classpath:/META-INF/resources
    를 유지하면서, 커스텀 핸들러를 추가하고 싶으면 사용하는 것
    캐싱전략
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")    // 기존 핸들러에 추가하는 것
                .addResourceLocations("classpath:/m/")      // 반드시 /로 끝나야함
                .setCachePeriod(20);
    }
}
