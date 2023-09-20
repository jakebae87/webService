package com.project.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		// https://oh-sh-2134.tistory.com/111
		boolean loginResult = memberService.login(memberDTO);
		if (loginResult) {
			session.setAttribute("loginEmail", memberDTO.getMemberEmail());
			return "main";
		} else {
			return "login";
		}
	}

	@GetMapping("/")
	public String findAll(Model model) {
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		return "list";
	}

	@GetMapping
	public String findById(@RequestParam("id") Long id, Model model) {
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		return "detail";
	}

	@GetMapping("/delete")
	public String deleteById(@RequestParam("id") Long id) {
		boolean deleteResult = memberService.deleteById(id);
		if (deleteResult) {
			return "redirect:/member/";
		} else {
			return "list";
		}
	}

	@GetMapping("/update")
	public String updateForm(Model model, HttpSession session) {
		String searchedEmail = (String) session.getAttribute("loginEmail");
		MemberDTO memberDTO = memberService.findByEmail(searchedEmail);
		model.addAttribute("member", memberDTO);
		return "update";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		boolean updateResult = memberService.update(memberDTO);
		if (updateResult) {
			return "redirect:/member?id=" + memberDTO.getId();
		} else {
			return "index";
		}
	}

	@PostMapping("/checkEmail")
	public void checkEmail(@RequestBody String map) {
		System.out.println(map+"hihi");
	}
}
