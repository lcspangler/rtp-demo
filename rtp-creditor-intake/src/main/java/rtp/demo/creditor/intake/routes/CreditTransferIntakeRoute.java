package rtp.demo.creditor.intake.routes;

import org.apache.camel.builder.RouteBuilder;

import rtp.demo.creditor.intake.beans.HelloBean;

public class CreditTransferIntakeRoute extends RouteBuilder {

	private HelloBean hBean = new HelloBean();

	@Override
	public void configure() throws Exception {
		try {
			from("direct:credit-transfers").bean(HelloBean.class, "hello");
		} catch (Exception e) {

		}

	}

}
