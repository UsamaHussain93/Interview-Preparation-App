package com.fdmgroup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fdmgroup.model.Question;


@Configuration
public class AppConfig {

	@Bean
	public Question userDaoOld(){
		return new Question(); 
	}
}
