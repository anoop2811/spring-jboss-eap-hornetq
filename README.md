# spring-jboss-eap-hornetq

This project came out of a lack of resources on how to connect to use spring boot and hornetq running remotely and
connecting through JNDI

This project is a sample all Java Config based spring boot project for subscribing to a queue in a horntq which
is deployed in jboss-eap version 6.4.

Inorder to run this, please create a queue with the name as `TestQueue`. You can do that using the jboss eap admin ui as shown below:

![jboss-eap](https://cloud.githubusercontent.com/assets/2038273/15016523/6ca06f96-11c6-11e6-83bd-13967da7f925.png)

The sample code currently reads a message from the queue and sends it to multiple processors of type [MessageProcessor](https://github.com/anoop2811/spring-jboss-eap-hornetq/blob/master/src/main/java/com/sample/processors/MessageProcessor.java).
If you need to add a new MessageProcessor, say eg: AWSSink, then just create a class that implements `MessageProcessor` and then create a bean of the same. You can look at the [MessageProcessorConfig](https://github.com/anoop2811/spring-jboss-eap-hornetq/blob/master/src/main/java/com/sample/config/MessageProcessorConfig.java) class for how its done.

The [Sender](https://github.com/anoop2811/spring-jboss-eap-hornetq/blob/master/src/main/java/com/sample/sender/Sender.java) sends timed messages, currently every 1 second to the `TestQueue`

