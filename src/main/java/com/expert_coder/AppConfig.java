package com.expert_coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@SpringBootApplication
@PropertySource("application.properties")
public class AppConfig {
    public static void main( String[] args )
    {
        SpringApplication springBootApplication=new SpringApplication(AppConfig.class);
        springBootApplication.run();
    }
}
