package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.StudentDto;
import com.app.entity.Student;
import com.app.repository.StudentRepository;
import com.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	// DTO -> Entity
	private Student dtoToEntity(StudentDto dto) {
		Student student = new Student();
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setCity(dto.getCity());
		student.setAge(dto.getAge());
		student.setMail(dto.getMail());
		student.setPhone(dto.getPhone());
		return student;
	}

	// Entity -> DTO
	private StudentDto entityToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setCity(student.getCity());
		dto.setAge(student.getAge());
		dto.setMail(student.getMail());
		dto.setPhone(student.getPhone());
		return dto;
	}

	@Override
	public StudentDto saveStudent(StudentDto dto) {

		Student student = dtoToEntity(dto);

		Student saved = repo.save(student);

		return entityToDto(saved);
	}

	@Override
	public List<StudentDto> getAllStudents() {

		List<Student> list = repo.findAll();

		return list.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	@Override
	public StudentDto getStudentById(Long id) {

		Student student = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id ));

		return entityToDto(student);
	}

	@Override
	public StudentDto updateStudent(Long id, StudentDto dto) {

		Student student = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id ));

		student.setName(dto.getName());
		student.setCity(dto.getCity());
		student.setAge(dto.getAge());
		student.setMail(dto.getMail());
		student.setPhone(dto.getPhone());

		Student updated = repo.save(student);

		return entityToDto(updated);
	}

	@Override
	public String deleteById(Long id) {

		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id);
		}

		repo.deleteById(id);
		return "Data Deleted Successfully";
	}

}