package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.processors.FileSink;
import com.sample.processors.MessageSink;
import com.sample.processors.SysoutSink;

@Configuration
public class MessageSinkConfig {
	
	@Bean
	public MessageSink fileProcessor() {
		return new FileSink();
	}
	
	@Bean
	public MessageSink sysoutProcessor() {
		return new SysoutSink();
	}
	
}
