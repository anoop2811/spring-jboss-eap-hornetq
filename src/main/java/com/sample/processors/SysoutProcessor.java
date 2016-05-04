package com.sample.processors;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class SysoutProcessor implements MessageProcessor {

	@Override
	public boolean process(Message message) throws JMSException {
		System.out.println("In sysout processor +++++>" + ((TextMessage)message).getText());
		return true;
	}

}
