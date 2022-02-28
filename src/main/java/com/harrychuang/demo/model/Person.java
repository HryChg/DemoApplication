package com.harrychuang.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Person {

  private final UUID id;
  private final String name;

  /**
   * NOTE-HC Map these params to a json object { "id": "893d4e11-1fe0-4f85-8bd6-35ea91a35f55",
   * "name": "James Bond" }
   **/
  public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
