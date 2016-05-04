package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.hornetq.HornetQAutoConfiguration;

@SpringBootApplication(exclude = { JmsAutoConfiguration.class, HornetQAutoConfiguration.class })
public class JmsFileApplication {
	public static void main(String[] args) {
		SpringApplication.run(JmsFileApplication.class, args);
	}
}
