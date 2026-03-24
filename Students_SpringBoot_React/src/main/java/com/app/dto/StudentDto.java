package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

	private Long id;
    private String name;
    private String city;
    private Long age;
    private String mail;
    private Long phone;

    // getters and setters
}