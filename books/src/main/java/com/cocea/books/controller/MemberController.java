package com.cocea.books.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cocea.books.service.MemberService;
import com.cocea.books.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService memberservice;
	
	//ȸ������ ������ �̵�
	@GetMapping(value="join")
	public void joinGET() {
		logger.info("ȸ������ ������ ����");
	}
	//ȸ������ post
	@PostMapping(value="join")
	public String joinPOST(MemberVO member) throws Exception{
		logger.info("join ����");
		
		//ȸ������ ���� ����
		memberservice.memberJoin(member);
		logger.info("join Service ����");
		return "redirect:/main";
	}
	
		
	//�α��� ������ �̵�
	@GetMapping(value="login")
	public void loginGET() {
		logger.info("�α��� ������ ����");
	}
}