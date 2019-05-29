package com.l99.imall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:config/spring-dubbo.xml"})
public class ImallSeckillWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImallSeckillWebApplication.class, args);
    }

}
