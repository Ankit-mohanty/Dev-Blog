package com.moblog.devblog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BlogConfig {
    @Bean// Use to create object inside a method.
    ArrayList<Blog> arrayList(){
        return new ArrayList<>();
    }
}
