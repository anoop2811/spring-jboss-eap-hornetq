package com.sample.processors;

import javax.jms.JMSException;
import javax.jms.Message;

public interface MessageProcessor {
	public boolean process(Message message) throws JMSException;
}
