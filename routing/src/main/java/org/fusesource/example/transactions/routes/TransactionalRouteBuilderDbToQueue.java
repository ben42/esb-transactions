/**
 * Copyright (c) Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.example.transactions.routes;

import org.apache.camel.spring.SpringRouteBuilder;

/**
 * Camel route builder defining our transactional route.  Because we want to maximize the level of support Spring offers for transactions,
 * we are extending SpringRouteBuilder instead of a plain RouteBuilder.
 *
 * The transacted() DSL keyword  will configure the route with transaction support and add a specific transaction-aware error handler.
 * It will lookup the transactional policy in the Spring XML file by default, but you can also specify one explicitly.
 */
public class TransactionalRouteBuilderDbToQueue extends SpringRouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jpa://org.fusesource.example.transactions.database.Flight")
            .transacted()
            .log("Received DB message ${body}")
            .process(new ConvertToMessageBeanProcessor())
            .log("Storing ${body} in queue")
            .to("amq://Input.FlightBack?username=" + System.getProperty("xa-example.user") + "&password=" + System.getProperty("xa-example.password"));
    }
}
