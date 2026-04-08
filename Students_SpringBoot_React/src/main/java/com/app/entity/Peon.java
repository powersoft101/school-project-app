package com.app.entity;

import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Peon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "peon_name")
	private String peonName;

	@NotNull
	@Column(name = "peon_number")
	private Long peonNumber;

	@Column(name = "peon_salary")
	private Double peonSalary;
}
