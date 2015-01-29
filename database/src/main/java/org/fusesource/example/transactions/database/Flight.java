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

    private String id;
    private String text;

    @Id
    @Column(length = 200)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(length = 30)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return String.format("[message %s with id %s]", id, text);
    }
}
