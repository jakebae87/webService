package com.project.member.service;

import org.springframework.stereotype.Service;

import com.project.member.dto.MemberDTO;
import com.project.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public int save(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO);
	}
}
