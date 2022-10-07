package com.sreviewonly.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing //jpa auditing을 활성화하여, 언제 데이터베이스가 생성되었는지를 감시한다.
@SpringBootApplication
public class SreviewApplication {

	public static void main(String[] args) {

		//Default : Tomcat을 킴,

		SpringApplication.run(SreviewApplication.class, args);

		//Database test중,None 설정값으로, 서버를 켜지 않고 테스트함.

//		SpringApplication application =
//				new SpringApplication((SreviewApplication.class));
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);

	}

}
