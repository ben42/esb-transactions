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
package org.fusesource.example.transactions.database;

import javax.persistence.*;

/**
 * A very simple entity class for a flight - every flight has:
 * - a flight number
 * - a departure airport
 * - an arrival airport
 */
@Entity
@Table(name = "FLIGHTS")
public class Flight {

    private String number;
    private String departure;
    private String arrival;

    @Id
    @Column(length = 20)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column(length = 3)
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Column(length = 3)
    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return String.format("[flight %s from %s to %s]", number, departure, arrival);
    }
}
