package org.example.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleProducerConfig {
	private static final Logger log = LogManager.getLogger(ExampleProducerConfig.class);

	private final String bootstrapServers;
	private final String topic;
	private final String acks;
	private final String securityProtocol;
	private final String serializerClass;

	public ExampleProducerConfig(String bootstrapServers, String topic, String securityProtocol, String serializerClass, String acks) {
		this.bootstrapServers = bootstrapServers;
		this.topic = topic;
		this.securityProtocol = securityProtocol;
		this.serializerClass = serializerClass;
		this.acks = acks;
	}

	public static ExampleProducerConfig fromEnv() {
		String bootstrapServers = System.getenv("BOOTSTRAP_SERVERS");
		log.info("BOOTSTRAP_SERVERS: {}", bootstrapServers);
		
		String topic = System.getenv("PRODUCER_TOPIC");
		log.info("PRODUCER_TOPIC: {}", topic);
		
		String securityProtocol = System.getenv("SECURITY_PROTOCOL");
		log.info("SECURITY_PROTOCOL: {}", securityProtocol);
		
		String serializerClass = System.getenv("SERIALIZER_CLASS");
		log.info("SERIALIZER_CLASS: {}", serializerClass);

		String acks = System.getenv("ACKS");
		log.info("ACKS: {}", acks);
		
		return new ExampleProducerConfig(bootstrapServers, topic, securityProtocol, serializerClass, acks);
	}

	public static Properties createProperties(ExampleProducerConfig config) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
		props.put(ProducerConfig.ACKS_CONFIG, config.getAcks());
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, config.getSerializerClass());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, config.getSerializerClass());
		props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, config.getSecurityProtocol());

		return props;
	}

	public String getAcks() {
		return acks;
	}

	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public String getTopic() {
		return topic;
	}

	public String getSecurityProtocol() {
		return securityProtocol;
	}

	public String getSerializerClass() {
		return serializerClass;
	}

}
