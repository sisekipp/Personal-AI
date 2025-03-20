package org.sisekipp.personal_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PersonalAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalAiApplication.class, args);
	}

}
