package com.sample.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.connection.TransactionAwareConnectionFactoryProxy;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private TransactionAwareConnectionFactoryProxy connectionFactoryProxy;

	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactoryProxy);
	}
	


	@Scheduled(fixedDelay = 1000L)
	public void send() {
		this.jmsTemplate().convertAndSend("TestQueue", "Hello");
	}
	


}