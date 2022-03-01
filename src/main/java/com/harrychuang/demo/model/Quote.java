package com.harrychuang.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.harrychuang.demo.jsonComponent.QuoteCombinedSerializer;
import java.util.ArrayList;
import java.util.Optional;

// NOTE-HC indicate that any properties not bound in this type should be ignored.
// @JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = QuoteCombinedSerializer.QuoteJsonDeserializer.class)
public class Quote {

  private final String content;
  private final String author;
  private final String source;
  private final Optional<ArrayList<String>> tags;

  public Quote(String content, String author, String source, Optional<ArrayList<String>> tags) {
    this.content = content;
    this.author = author;
    this.source = source;
    this.tags = tags;
  }

  @Override
  public String toString() {
    // TODO-HC Implement Tags
    return String.format(
        "Quote{content='%s', author='%s', source=%s, tags=%s}",
        content, author, source, "NOT_IMPLEMENTED");
  }
}
