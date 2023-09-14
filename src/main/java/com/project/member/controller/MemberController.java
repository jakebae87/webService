package com.project.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.member.dto.MemberDTO;
import com.project.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member") // 공통주소 설정
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/save")
	public String saveForm() {
		return "save";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute MemberDTO memberDTO) {
		int saveResult = memberService.save(memberDTO);
		if (saveResult > 0) {
			return "login";
		} else {
			return "save";
		}
	}
}
