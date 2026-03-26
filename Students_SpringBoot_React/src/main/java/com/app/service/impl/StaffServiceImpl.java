package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.StaffDto;
import com.app.entity.Staff;
import com.app.repository.StaffRepository;
import com.app.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository repo;

	// Dto to Entity
	private Staff dtoToEntity(StaffDto dto) {
		Staff s = new Staff();
		s.setId(dto.getId());
		s.setStaffName(dto.getStaffName());
		s.setStaffAddress(dto.getStaffAddress());
		s.setStaffDesignation(dto.getStaffDesignation());
		return s;
	}

	// Entity to Dto
	private StaffDto entityToDto(Staff s) {
		StaffDto dto = new StaffDto();
		dto.setId(s.getId());
		dto.setStaffAddress(s.getStaffAddress());
		dto.setStaffDesignation(s.getStaffDesignation());
		dto.setStaffName(s.getStaffName());
		return dto;
	}

	@Override
	public StaffDto saveStaff(StaffDto dto) {
		Staff s = dtoToEntity(dto);

		Staff saved = repo.save(s);

		return entityToDto(saved);
	}

	@Override
	public List<StaffDto> getAllStaff() {

		List<Staff> list = repo.findAll();

		return list.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	@Override
	public StaffDto getStaffById(Long id) {
		Staff s = repo.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Provided id " + id + " not found"));

		return entityToDto(s);
	}

	@Override
	public StaffDto updateStaffById(Long id, StaffDto dto) {
		Staff s = repo.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Provided id " + id + " not found"));

		s.setStaffName(dto.getStaffName());
		s.setStaffAddress(dto.getStaffAddress());
		s.setStaffDesignation(dto.getStaffDesignation());

		Staff updated = repo.save(s);
		return entityToDto(updated);
	}

	@Override
	public String deleteStaffById(Long id) {

		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provided is " + id + " not found");
		}

		repo.deleteById(id);
		return "Data Deleted Successfully";
	}

}
