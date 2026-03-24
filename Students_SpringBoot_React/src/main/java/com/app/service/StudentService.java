package com.app.service;

import java.util.List;

import com.app.dto.StudentDto;

public interface StudentService {

	StudentDto saveStudent(StudentDto dto);

	List<StudentDto> getAllStudents();

	StudentDto getStudentById(Long id);

	StudentDto updateStudent(Long id, StudentDto dto);

	String deleteById(Long id);

}