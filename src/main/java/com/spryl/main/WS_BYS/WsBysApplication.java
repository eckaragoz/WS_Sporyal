package com.spryl.main.WS_BYS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.spryl.controllers")
@ComponentScan(basePackages="com.spryl.dao")
@ComponentScan(basePackages="com.jwt.config")
@ComponentScan(basePackages="com.spryl.services")
@EnableJpaRepositories(basePackages="com.spryl.repositories")
@EntityScan(basePackages = "com.spryl.models")
public class WsBysApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsBysApplication.class, args);
	}

}


