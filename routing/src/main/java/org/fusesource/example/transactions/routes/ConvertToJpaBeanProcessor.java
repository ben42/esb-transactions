package org.fusesource.example.transactions.routes;

import static org.fusesource.example.transactions.routes.Airports.randomAirport;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.fusesource.example.transactions.database.Flight;

/*
 * Just a simple Camel processor to transform a plain text message into a Flight object.
 */
public class ConvertToJpaBeanProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		
		exchange.getOut().copyFrom(exchange.getIn());
		

		String text = exchange.getIn().getBody(String.class);

		Flight flight = new Flight();
		flight.setText(text);
		flight.setId(exchange.getIn().getMessageId());

		exchange.getOut().setBody(flight);
	}
}