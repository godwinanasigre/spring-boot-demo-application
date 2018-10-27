package com.godwin.demo.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.godwin.demo.application.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class GodwinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GodwinDemoApplication.class, args);
	}
}
