package com.md.shop.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.md.shop.domain.MemberVO;

//장시간 로그인 했을경우 로그인이 되어 있으면 콘틀로러 계속진행하고 아니라면 지정한 페이지로 이동
public class AdminInterceptor extends HandlerInterceptorAdapter{
/*
AdminInterceptor HandlerInterceptorAdapter를 상속받아서 
컨트롤러 실행 전에 실행되는 preHandel메서드와 
컨트롤로 실행 후 실해되는 postHandle로 나뉩니다
*/	
	
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member == null) {//로그인 하지 않은 상태
			res.sendRedirect("/member/signin");
			return false;
		}
		if(member.getVerify() != 9) {//로그인 후 검사
			res.sendRedirect("/");
			return false;
		}
		
		return true;
	}

}
