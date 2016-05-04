package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.hornetq.HornetQAutoConfiguration;

@SpringBootApplication(exclude = { JmsAutoConfiguration.class, HornetQAutoConfiguration.class })
public class SpringBootHornetqApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHornetqApp.class, args);
	}
}
