package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.dto.MemberDto;
import com.app.entity.Member;
import com.app.repository.MemberRepo;
import com.app.service.MemberServ;

@Service
public class MemberServImpl implements MemberServ {

	@Autowired
	private MemberRepo repo;

	// Dto to Entity
	private Member dtoToEntity(MemberDto dto) {
		Member m = new Member();
		m.setId(dto.getId());
		m.setMemberName(dto.getMemberName());
		m.setMemberAddress(dto.getMemberAddress());
		return m;
	}

	// Entity to Dto
	private MemberDto entityToDto(Member m) {
		MemberDto dto = new MemberDto();
		dto.setId(m.getId());
		dto.setMemberName(m.getMemberName());
		dto.setMemberAddress(m.getMemberAddress());
		return dto;
	}

	@Override
	public MemberDto addMember(MemberDto dto) {

		Member m = dtoToEntity(dto);

		Member saved = repo.save(m);

		return entityToDto(saved);
	}

	@Override
	public List<MemberDto> getAllMembers() {

		List<Member> list = repo.findAll();

		return list.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	@Override
	public MemberDto getMemberById(Long id) {
		Member m = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found " + id));

		return entityToDto(m);
	}

	@Override
	public MemberDto updateMemberById(Long id, MemberDto dto) {

		Member m = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not foung " + id));

		m.setMemberName(dto.getMemberName());
		m.setMemberAddress(dto.getMemberAddress());

		Member updated = repo.save(m);

		return entityToDto(updated);
	}

	@Override
	public String deleteByMemberId(Long id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found " + id);
		}

		repo.deleteById(id);
		return "Data deleted successfully";
	}

}
