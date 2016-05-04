package com.sample.config;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sample.processors.MessageProcessor;

@Component
public class SampleJmsListener {

	@Resource
	public List<MessageProcessor> messageProcessors;

	@JmsListener(containerFactory = "myContainerFactory", destination = "TestQueue")
	public void processOrder(Message message) {
		for (MessageProcessor messageProcessor : messageProcessors) {
			try {
				messageProcessor.process(message);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
