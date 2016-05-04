package com.sample.processors;

import javax.jms.JMSException;
import javax.jms.Message;

public interface MessageSink {
	public boolean process(Message message) throws JMSException;

	default String getName() {
		return this.getClass().getName();
	}
}
