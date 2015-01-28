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
public class TransactionalRouteBuilder extends SpringRouteBuilder {

    @Override
    public void configure() throws Exception {
        from("amq://Input.Flights?username=admin&password=admin")
            .transacted()
            .log("Received JMS message ${body}")
            .process(new ConvertToJpaBeanProcessor())
            .log("Storing ${body} in the database")
            .to("jpa://org.fusesource.example.transactions.database.Flight");
    }
}
