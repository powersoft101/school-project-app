package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApp {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApp.class, args);
		System.out.println("Project Started");
	}

}
