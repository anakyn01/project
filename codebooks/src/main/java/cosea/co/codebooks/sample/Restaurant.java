package cosea.co.codebooks.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
//스프링 프레임 워크에서 관리해야 하는 객체 이를 빈이라고 함 root-context.xml에서


@Component
@Data
public class Restaurant {

	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
