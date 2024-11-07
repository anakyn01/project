package cosea.co.codebooks.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(BlockJUnit4ClassRunner.class)
@Configuration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotelTests {
	
	@Setter(onMethod_= {@Autowired})
	private SampleHotel hotel;
	
	@Test
	public void testExist() {
		log.info(hotel);
		log.info("----------------------------");
		log.info(hotel.getChef());
		}
	
	
	
	
	
	
	

}
