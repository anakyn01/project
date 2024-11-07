package cosea.co.codebooks.config;
/*
 * 복잠함을 심플하게
 * 전체구조를 설계하는데 유용한 프레임 워크
 * 다른 프레임 워크들의 포용
 * 스프링 2.5 => 어노테이션 도입
 * 스프링 3.0 => 자바크래스로 설정파일 대신
 * POJO (plain old java object) => 자바코드를 이용해서 객체를 만드는 방식 드대로 사용
 * 의존성 => 하나의 객체가 다른 객체없이 제대로 된 역활을 할수 없는것을 의미
 * 주입[Injection] 밀어 넣는것
 * Aspect Oriented Programing => 횡단 관심사를 모듈오 분리
 * */

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//기존프로젝트에서 web.xml을 이용하여 스프링을 구동시켰지만 XML을 사용하지 않는 경우 클래스
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {//getRootConfig는 RootConfig클래스를 사용하므로 아래와 같이
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

}
