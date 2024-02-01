package com.moblog.devblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DevBlogApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DevBlogApplication.class, args);
		var bs=run.getBean(BlogService.class);
	}

}
