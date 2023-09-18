package com.project.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.project.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository { // DB와 연결되는 부분 (MyBatis)

	private final SqlSessionTemplate sql; // MyBatis에서 제공하는 클래스

	public int save(MemberDTO memberDTO) {
		return sql.insert("Member.save", memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO);
	}

	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll");
	}

	public MemberDTO findById(Long id) {
		return sql.selectOne("Member.findById", id);
	}

}
