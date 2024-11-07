package com.hbk.bbs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //해당 클래스를 스프링 설정클래스로 지정합니다
public class AppContext {

	@Bean//빈 객체를 구분할때 사용합니다 해당메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록합니다
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 시마이");
		return g;
	}
}
