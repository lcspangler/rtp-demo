package org.example.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.kafka.producer.ExampleProducer;

@Path("/message")
public class MessageRestService {

	private static final Logger log = LogManager.getLogger(MessageRestService.class);

	private ExampleProducer producer = new ExampleProducer();

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Message: " + msg;

		try {
			producer.sendMessage(msg);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(200).entity(result).build();
	}

}
