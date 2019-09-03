package com.ssmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsmdemoApplication {

	public static void main(String[] args) {
		System.out.println("spring Begin............................");
		SpringApplication.run(SsmdemoApplication.class, args);
		System.out.println("spring end............................");
	}

}
