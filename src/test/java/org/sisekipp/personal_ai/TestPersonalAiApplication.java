package org.sisekipp.personal_ai;

import org.springframework.boot.SpringApplication;

public class TestPersonalAiApplication {

	public static void main(String[] args) {
		SpringApplication.from(PersonalAiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
