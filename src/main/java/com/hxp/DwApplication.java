package com.hxp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hxp.dao")
public class DwApplication {

	public static void main(String[] args) {
		SpringApplication.run(DwApplication.class, args);
	}

}
