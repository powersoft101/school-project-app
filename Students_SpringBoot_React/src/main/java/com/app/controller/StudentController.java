package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDto;
import com.app.service.StudentService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/create")
	public StudentDto create(@RequestBody StudentDto dto) {
		return service.saveStudent(dto);
	}

	@GetMapping("/getAll")
	public List<StudentDto> getAll() {
		return service.getAllStudents();
	}

	@GetMapping("/getById/{id}")
	public StudentDto getById(@PathVariable Long id) {
		return service.getStudentById(id);
	}

	@PutMapping("/updateById/{id}")
	public StudentDto update(@PathVariable Long id, @RequestBody StudentDto dto) {
		return service.updateStudent(id, dto);
	}

	@DeleteMapping("/deleteById/{id}")
	public String delete(@PathVariable Long id) {
		return service.deleteById(id);
	}
}