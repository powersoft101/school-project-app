package com.app.service;

import java.util.List;

import com.app.dto.MemberDto;

public interface MemberServ {

	MemberDto addMember(MemberDto dto);
	List<MemberDto> getAllMembers();
	MemberDto getMemberById(Long id);
	MemberDto updateMemberById(Long id, MemberDto dto);
	String deleteByMemberId(Long id);
}
