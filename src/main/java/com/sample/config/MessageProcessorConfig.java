package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.processors.FileProcessor;
import com.sample.processors.MessageProcessor;
import com.sample.processors.SysoutProcessor;

@Configuration
public class MessageProcessorConfig {
	
	@Bean
	public MessageProcessor fileProcessor() {
		return new FileProcessor();
	}
	
	@Bean
	public MessageProcessor sysoutProcessor() {
		return new SysoutProcessor();
	}
	
}
