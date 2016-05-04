package com.sample.listener;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sample.processors.MessageSink;

@Component
public class SampleJmsListener {

	@Resource
	public List<MessageSink> messageProcessors;
	

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@JmsListener(containerFactory = "myContainerFactory", destination = "TestQueue")
	public void processOrder(Message message) {
		for (MessageSink messageProcessor : messageProcessors) {
			try {
				logger.debug("Going to process message in [{}]",messageProcessor.getName());
				messageProcessor.process(message);
			} catch (JMSException e) {
				logger.error("Error is processing the message", e);
			}
		}
	}

}
