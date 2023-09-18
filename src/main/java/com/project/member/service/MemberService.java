package com.project.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.member.dto.MemberDTO;
import com.project.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	// @RequiredArgsConstructor
	// final 변수에 대한 생성자 주입을 해주는 어노테이션
	// 만약 위 어노테이션을 사용하지 않는다면 아래와 같이 입력해야 한다.

//	  @Autowired
//	  public MemberService(MemberRepository memberRepository) {
//	    this.firstRepository = firstRepository;
//	  }

	public int save(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO);
	}

	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberRepository.login(memberDTO);
		if (loginMember != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<MemberDTO> findAll() {
		return memberRepository.findAll();
	}

	public MemberDTO findById(Long id) {
		return memberRepository.findById(id);
	}

	public boolean deleteById(Long id) {
		int deleteMember = memberRepository.deleteById(id);
		if (deleteMember != 0) {
			return true;
		} else {
			return false;
		}
	}

	public MemberDTO findByEmail(String searchedEmail) {
		return memberRepository.findByEmail(searchedEmail);
	}

	public boolean update(MemberDTO memberDTO) {
		int updateResult = memberRepository.update(memberDTO);
		if(updateResult > 0) {
			return true;
		}else {
			return false;
		}
	}

}
