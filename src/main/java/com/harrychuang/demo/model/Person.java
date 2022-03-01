package com.harrychuang.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;

public class Person {

  private final UUID id;

  // NOTE-HC We are not using @NotNull because it would still permit empty string
  // This tells Spring-Boot when we pass in Person in request body, name cannot be null or empty str
  @NotBlank private final String name;

  /**
   * NOTE-HC Map these params to a json object { "id": "893d4e11-1fe0-4f85-8bd6-35ea91a35f55",
   * "name": "James Bond" }
   */
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
