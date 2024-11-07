package cosea.co.codebooks;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//pom.xml을 사용하지 않을때 만드는 자바 설정파일
@Configuration//해당클래스의 인스턴스를 이용하여 설정파일을 대체합니다
@ComponentScan(basePackages= {"cosea.co.codebooks.sample"})
public class RootConfig {

}
