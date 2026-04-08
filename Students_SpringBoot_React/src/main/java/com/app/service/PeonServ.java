package com.app.service;

import java.util.List;

import com.app.dto.PeonDto;

public interface PeonServ {

	PeonDto savePeon(PeonDto dto);

	List<PeonDto> getAllPeons();

	PeonDto getPeonById(Long id);

	PeonDto updatePeonById(Long id, PeonDto dto);

	String deletePeonById(Long id);
}
