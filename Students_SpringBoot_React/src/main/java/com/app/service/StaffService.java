package com.app.service;

import java.util.List;

import com.app.dto.StaffDto;

public interface StaffService {

	StaffDto saveStaff(StaffDto dto);
	List<StaffDto> getAllStaff();
	StaffDto getStaffById(Long id);
	StaffDto updateStaffById(Long id, StaffDto dto);
	String deleteStaffById(Long id);
}
