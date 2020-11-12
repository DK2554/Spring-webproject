package com.spring.itjobgo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//Spring bean configuration xml 파일과 같은 역할을 하는 class

@Configuration
public class ServletConfiguration {

	//하나의 bean역할을 함
	@Bean
	public Logger getLogger() {
		return LoggerFactory.getLogger(ServletConfiguration.class);
	}

}
