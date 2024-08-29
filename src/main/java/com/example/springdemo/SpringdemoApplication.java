package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringdemoApplication {

    //http://localhost:7777/swagger-ui/index.html
    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

}
