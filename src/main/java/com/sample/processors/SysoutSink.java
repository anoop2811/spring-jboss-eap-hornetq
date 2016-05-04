package com.sample.processors;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class SysoutSink implements MessageSink {

	@Override
	public boolean process(Message message) throws JMSException {
		System.out.println("In sysout processor +++++>" + ((TextMessage)message).getText());
		return true;
	}
}
