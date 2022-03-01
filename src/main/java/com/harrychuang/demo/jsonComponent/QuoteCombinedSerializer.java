package com.harrychuang.demo.jsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.harrychuang.demo.model.Quote;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class QuoteCombinedSerializer {

  public static class QuoteJsonDeserializer extends JsonDeserializer<Quote> {

    @Override
    public Quote deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {

      TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
      TreeNode quoteObj = treeNode.get("contents").get("quotes").get(0);
      TextNode content = (TextNode) quoteObj.get("quote");
      TextNode author = (TextNode) quoteObj.get("author");
      TextNode source = (TextNode) quoteObj.get("permalink");
      ArrayNode tags = (ArrayNode) quoteObj.get("tags");
      // TODO-HC Figure out how to convert it to a list of strings
      return new Quote(content.asText(), author.asText(), source.asText(), null);
    }
  }
}
