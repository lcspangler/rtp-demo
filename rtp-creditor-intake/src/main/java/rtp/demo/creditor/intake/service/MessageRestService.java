package rtp.demo.creditor.intake.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.kafka.producer.ExampleProducer;

import rtp.demo.creditor.intake.service.model.CreditTransferMessagesRequest;

@Path("/credit-transfer-messages")
public class MessageRestService {

	private static final Logger log = LogManager.getLogger(MessageRestService.class);

	private ExampleProducer producer = new ExampleProducer();
	private final CamelContext context = new DefaultCamelContext();

	@POST
	@Consumes("application/xml")
	public void processCreditTransferMessages(CreditTransferMessagesRequest creditTransferMessageRequest) {
		log.info(creditTransferMessageRequest);
		ProducerTemplate camelProducer = context.createProducerTemplate();

		camelProducer.sendBody("direct:credit-transfers", creditTransferMessageRequest);
	}

}
