package com.luo.imall.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luo.imall.web.dao")
public class ImallWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImallWebApplication.class, args);
	}

}
