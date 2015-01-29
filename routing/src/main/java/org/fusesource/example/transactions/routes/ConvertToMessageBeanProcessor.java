package org.fusesource.example.transactions.routes;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.fusesource.example.transactions.database.Flight;

/*
 * Just a simple Camel processor to transform a plain text message into a Flight object.
 */
public class ConvertToMessageBeanProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		exchange.getOut().copyFrom(exchange.getIn());

		Flight flight = exchange.getIn().getBody(Flight.class);

		exchange.getOut().setBody(flight.getText());

	}
}