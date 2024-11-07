package com.cocea.books.service;

import javax.inject.Inject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import com.cocea.books.dao.MemberDAO;
import com.cocea.books.mapper.MemberMapper;
import com.cocea.books.vo.MemberVO;

@Service
@MapperScan("com.cocea.books.mapper")
public class MemberServiceImpl implements MemberService {
	

	
	@Inject
	MemberMapper membermapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception {
		membermapper.memberJoin(member);
	}

}
