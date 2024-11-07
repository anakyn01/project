package cosea.co.codebooks.sample;
/*
단일 생성자의 묵시적 자동주입
@Autowired와 같은 어노테이션을 통해서 스프링으로 부터 자신이 필요한 객체를 
주입해 주도록 합니다
생성자 주입은 이러한 주입을 생성자를 통해서 처리합니다
생성자 주입의 경우 객체 생성시 의존성 주입이 필요하므로 
좀더 엄격하게 의존성 주입을 체크하는 장점이 있다
기존에 스프링에서는 @AutoWired와 같은 어노테이션을 추가해야지만 생성자 주입이 
이루어 졌지만 스프링4.3 이후에는 묵시적 
*/
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel {

	@NonNull
	private Chef chef;
}
