package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.PeonDto;
import com.app.entity.Peon;
import com.app.repository.PeonRepo;
import com.app.service.PeonServ;

@Service
public class PeonServImpl implements PeonServ {

	@Autowired
	private PeonRepo repo;

	// Dto to Entity Mapping
	Peon dtoToEntity(PeonDto dto) {
		Peon p = new Peon();
		p.setId(dto.getId());
		p.setPeonName(dto.getPeonName());
		p.setPeonNumber(dto.getPeonNumber());
		p.setPeonSalary(dto.getPeonSalary());
		return p;
	}

	// Entity to Dto Mapping
	PeonDto entityToDto(Peon p) {
		PeonDto dto = new PeonDto();
		dto.setId(p.getId());
		dto.setPeonName(p.getPeonName());
		dto.setPeonNumber(p.getPeonNumber());
		dto.setPeonSalary(p.getPeonSalary());
		return dto;
	}

	@Override
	public PeonDto savePeon(PeonDto dto) {
		Peon p = dtoToEntity(dto);

		Peon saved = repo.save(p);

		return entityToDto(saved);
	}

	@Override
	public List<PeonDto> getAllPeons() {

		List<Peon> pList = repo.findAll();

		return pList.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	@Override
	public PeonDto getPeonById(Long id) {
		Peon p = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Id not Found: " + id));

		return entityToDto(p);
	}

	@Override
	public PeonDto updatePeonById(Long id, PeonDto dto) {

		Peon p = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Id not found: " + id));

		p.setPeonName(dto.getPeonName());
		p.setPeonNumber(dto.getPeonNumber());
		p.setPeonSalary(dto.getPeonSalary());

		Peon updated = repo.save(p);

		return entityToDto(updated);
	}

	@Override
	public String deletePeonById(Long id) {

		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Id not found: " + id);
		}
		repo.deleteById(id);

		return " Id succefully deleted";
	}
}
