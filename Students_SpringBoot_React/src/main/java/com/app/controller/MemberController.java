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

import com.app.dto.MemberDto;
import com.app.service.MemberServ;

@RestController
@RequestMapping("/base-url")
public class MemberController {

	@Autowired
	private MemberServ serv;

	@PostMapping("/add")
	public MemberDto addMember(@RequestBody MemberDto dto) {
		return serv.addMember(dto);
	}

	@GetMapping("/getAll")
	public List<MemberDto> getAllMember() {
		return serv.getAllMembers();
	}

	@GetMapping("/getMemberById/{id}")
	public MemberDto getById(@PathVariable Long id) {
		return serv.getMemberById(id);
	}

	@PutMapping("/updateMemberById/{id}")
	public MemberDto update(@PathVariable Long id, @RequestBody MemberDto dto) {
		return serv.updateMemberById(id, dto);
	}

	@DeleteMapping("/deleteById/{id}")
	public String delete(@PathVariable Long id) {
		return serv.deleteByMemberId(id);
	}

}
