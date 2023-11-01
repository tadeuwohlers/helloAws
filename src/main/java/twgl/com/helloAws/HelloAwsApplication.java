package twgl.com.helloAws;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloAwsApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HelloAwsApplication.class);
	  	//application.setAdditionalProfiles("prod");
	  	application.run(args);
	}

	@Bean
    public ModelMapper getModelMapper() { 
        return new ModelMapper(); 
    }
}