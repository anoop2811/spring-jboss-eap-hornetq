package com.sample.config;

import java.util.Properties;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.TransactionAwareConnectionFactoryProxy;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

@Configuration
@EnableJms
public class JmsConfig {
	
	@Bean
	public TransactionAwareConnectionFactoryProxy connectionFactoryProxy() {
	    return new TransactionAwareConnectionFactoryProxy((ConnectionFactory) jmsConnectionFactory().getObject());
	}
	
	@Bean
	public ScheduledAnnotationBeanPostProcessor scheduledAnnotationBeanPostProcessor() {
		return new ScheduledAnnotationBeanPostProcessor();
	}
	
	@Bean
	public JndiTemplate jndiTemplate() {
	    JndiTemplate jndiTemplate = new JndiTemplate();
	    Properties jndiProps = new Properties();
	    jndiProps.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
	    jndiProps.setProperty("java.naming.provider.url", "remote://localhost:4447"); // t3://serverAddress:port
	    jndiProps.setProperty("java.naming.security.principal", "guest"); // injected from properties file username
	    jndiProps.setProperty("java.naming.security.credentials", "guest"); //injected from properties file password

	    jndiTemplate.setEnvironment(jndiProps);
	    return jndiTemplate;
	}
	
	@Bean
	public JndiObjectFactoryBean jmsConnectionFactory() {
	    JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();


	    jndiObjectFactoryBean.setJndiTemplate(jndiTemplate());
	    jndiObjectFactoryBean.setJndiName("jms/RemoteConnectionFactory"); // connectionFactory name.

	    return jndiObjectFactoryBean;
	}
	
    @Bean
    public DefaultJmsListenerContainerFactory myContainerFactory() {
        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory((ConnectionFactory) jmsConnectionFactory().getObject());
        factory.setConcurrency("3-10");
        return factory;
    }
}