package com.todoApp.todoback.CORS;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@Profile("production")
//public class ProdCorsConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/api/**")
//                .allowedOrigins("https://mihkli-todo-app.netlify.app/");
//    }
//}
