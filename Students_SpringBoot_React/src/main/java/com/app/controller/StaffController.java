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
import com.app.dto.StaffDto;
import com.app.service.StaffService;

@RestController
@RequestMapping("/staff-base-url")
public class StaffController {

	@Autowired
	private StaffService service;

	@PostMapping("/add")
	public StaffDto addStaff(@RequestBody StaffDto dto) {
		return service.saveStaff(dto);
	}

	@GetMapping("/getAll")
	public List<StaffDto> getAllStaff() {
		return service.getAllStaff();
	}

	@GetMapping("/getById/{id}")
	public StaffDto get(@PathVariable Long id) {
		return service.getStaffById(id);
	}

	@PutMapping("/updateById/{id}")
	public StaffDto update(@PathVariable Long id, @RequestBody StaffDto dto) {
		return service.updateStaffById(id, dto);
	}

	@DeleteMapping("/deleteById/{id}")
	public String delete(@PathVariable Long id) {
		return service.deleteStaffById(id);
	}
}
