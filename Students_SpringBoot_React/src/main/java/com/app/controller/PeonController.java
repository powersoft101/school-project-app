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

import com.app.dto.PeonDto;
import com.app.service.PeonServ;

@RestController
@RequestMapping("/base-url")
public class PeonController {

	@Autowired
	private PeonServ serv;

	@PostMapping("/add-peon")
	public PeonDto addPeon(@RequestBody PeonDto dto) {
		return serv.savePeon(dto);
	}

	@GetMapping("/get-all-peons")
	public List<PeonDto> getAllPeons() {
		return serv.getAllPeons();
	}

	@GetMapping("/get-peon/{id}")
	public PeonDto getPeon(@PathVariable Long id) {
		return serv.getPeonById(id);
	}

	@PutMapping("/update-peon/{id}")
	public PeonDto updatePeon(@PathVariable Long id, @RequestBody PeonDto dto) {
		return serv.updatePeonById(id, dto);
	}

	@DeleteMapping("/delete-person/{id}")
	public String deletePeon(@PathVariable Long id) {
		return serv.deletePeonById(id);
	}
}
