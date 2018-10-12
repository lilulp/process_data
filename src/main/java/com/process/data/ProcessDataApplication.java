package com.process.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("com.process.data.dao")
public class ProcessDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessDataApplication.class, args);
	}
}
