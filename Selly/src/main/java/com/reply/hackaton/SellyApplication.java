package com.reply.hackaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SellyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellyApplication.class, args);
	}
}
