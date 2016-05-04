package com.sample.processors;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class FileSink implements MessageSink {

	@Override
	public boolean process(Message message) throws JMSException {
		System.out.println("In file processor =====>" + ((TextMessage)message).getText());
		return true;
	}
}
