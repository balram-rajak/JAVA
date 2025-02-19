import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.springproject.properties.BuisnessService;

@Configuration
@ComponentScan("com.springproject.properties")
@PropertySource("classpath:connection.properties")
public class WebLayer {

	
	private static Logger logger=LoggerFactory.getLogger(WebLayer.class);
	public static void main(String[] args) {
		AnnotationConfigApplicationContext cont1=new AnnotationConfigApplicationContext(WebLayer.class);
				
		
		
		BuisnessService e1=cont1.getBean(BuisnessService.class);
		//BuisnessService e2=cont1.getBean(BuisnessService.class);
		
		System.out.println("///////////////");
		logger.info("{}",e1);
		logger.info("{}",e1.getDataAccess().getUrl());
		
		logger.info("{}",e1.getDataAccess());
		cont1.close();
		
		
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("WebLayer_postConstruct");
	}
	
	
	@PreDestroy
	public void Predestroy() {
		System.out.println("WebLayer_preDestroy");
	}

}
