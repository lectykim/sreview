package com.sreviewonly.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SreviewApplication {

	public static void main(String[] args) {

		//Default : Tomcat을 킴,

		//SpringApplication.run(SreviewApplication.class, args);

		//Database test중,None 설정값으로, 서버를 켜지 않고 테스트함.

		SpringApplication application =
				new SpringApplication((SreviewApplication.class));
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);

	}

}
